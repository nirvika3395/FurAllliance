package com.furalliance.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.time.LocalDate;

import com.furalliance.model.UserModel;
import com.furalliance.services.PortfolioService;
import com.furalliance.util.ImageUtil;
import com.furalliance.util.SessionUtil;
import com.furalliance.util.ValidationUtil;

@WebServlet(asyncSupported = true, urlPatterns =  "/portfolio")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class PortfolioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PortfolioService portfolioService;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PortfolioController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() throws ServletException {
		// Initializing dependencies in init()
		this.portfolioService = new PortfolioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Using SessionUtil to get the username
	    String userName = (String) SessionUtil.getAttribute(req, "username");

		req.setAttribute("user", portfolioService.getUserInfo(userName));
		
		
		
		
		
		req.getRequestDispatcher("WEB-INF/pages/portfolio.jsp").forward(req, resp);
	}
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Using SessionUtil to get the username
	    String userName = (String) SessionUtil.getAttribute(req, "username");
		int userId = portfolioService.getUserInfo(userName).getId();
		
		try {
			
			String validationMessage = validateForm(req, userId);
			if (validationMessage != null) {
				handleError(req, resp, validationMessage);
				return;
			}
			
			// Get the image part from the request
			Part imagePart = req.getPart("image");
			String imageUrl = null;
			
			// Only process image if a new one was uploaded
			if (imagePart != null && imagePart.getSize() > 0) {
				boolean imageUploaded;
				imageUploaded = ImageUtil.uploadImage(imagePart, req.getParameter("userName"), "users");

				if (!imageUploaded) {
					handleError(req, resp, "Could not upload the image. Please try again later!");
					return;
				}
				
				// Get the uploaded image URL
				String originalImageName = ImageUtil.getImageNameFromPart(imagePart);
				String username = req.getParameter("userName");
				String savedImageName = username + "_" + originalImageName; 
				imageUrl = "/userimages/users/" + savedImageName;
			}
			
			// Extract user model with optional new image URL
			UserModel userModel = extractUserModel(req, imageUrl);
			Boolean isUpdated = portfolioService.updateUser(userModel, userId);
			
			if (isUpdated == null) {
				handleError(req, resp, "Our server is under maintenance. Please try again later!");
				return;
			} else if (isUpdated) {
				String newUserName = req.getParameter("userName");
			    if (!userName.equals(newUserName)) {
			        SessionUtil.setAttribute(req, "username", newUserName); 
			    }
			
				// Using SessionUtil to get the updated username
				String updatedUserName = (String) SessionUtil.getAttribute(req, "username");
				UserModel updatedUser = portfolioService.getUserInfo(updatedUserName);
				req.setAttribute("user", updatedUser);
				handleSuccess(req, resp, "Your details are successfully updated!", "/WEB-INF/pages/portfolio.jsp");

			} else {
				handleError(req, resp, "Could not update your details. Please try again later!");
			}
				
		} catch(Exception e) {
			e.printStackTrace(); // Log the exception for troubleshooting
			handleError(req, resp, "An unexpected error occurred. Please try again later!");
		}
	}
	
	
	private void handleError(HttpServletRequest req, HttpServletResponse resp, String validationMessage) {
	// TODO Auto-generated method stub
	
}

	private String validateForm(HttpServletRequest request, int userId) {
		
		// Getting form parameters
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String birthdayStr = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		// Checking for null or empty fields first using isNullorEmpty Method form
		// ValidationUtil
		if (ValidationUtil.isNullOrEmpty(firstName))
			return "First name is required.";
		if (ValidationUtil.isNullOrEmpty(lastName))
			return "Last name is required.";
		if (ValidationUtil.isNullOrEmpty(userName))
			return "Username is required.";
		if (ValidationUtil.isNullOrEmpty(birthdayStr))
			return "Date of birth is required.";
		if (ValidationUtil.isNullOrEmpty(email))
			return "Email is required.";
		if (ValidationUtil.isNullOrEmpty(phone))
			return "Phone number is required.";

		// Converting date of birth
		LocalDate dob;
		try {
			dob = LocalDate.parse(birthdayStr);
		} catch (Exception e) {
			return "Invalid date format. Please use YYYY-MM-DD.";
		}

		// Validating if username begins with letter and only contains alphabets and
		// numeric values
		if (!ValidationUtil.isAlphanumericStartingWithLetter(userName))
			return "Username must start with a letter and contain only letters and numbers beginning with letters.";

		// Validating email
		if (!ValidationUtil.isValidEmail(email))
			return "Invalid email format.";

		// Validating phone number
		if (!ValidationUtil.isValidPhoneNumber(phone))
			return "Phone number must be 10 digits and start with 98.";
	
		// Checking if the date of birth is at least 16 years before today
		if (!ValidationUtil.isAgeAtLeast16(dob))
			return "You must be at least 16 years old to register.";

		// Checking into database if the username already exists
		if (portfolioService.isUsernameExistsForOtherUser(userName, userId)) {
			return "Username already exists.";
		}
		// Checking into database if the phone already exists
		if (portfolioService.isPhoneExistsForOtherUser(phone, userId)) {
			return "The phone is already registered in our system.";
		}
		// Checking into database if the email already exists
		if (portfolioService.isEmailExistsForOtherUser(email, userId)) {
			return "The email is already registered in our system.";
		}

		// Only validate image if one is uploaded
		try {
			Part image = request.getPart("image");
			if (image != null && image.getSize() > 0) {
				if (!ValidationUtil.isValidImageExtension(image))
					return "Invalid image format. Only jpg, jpeg, png, and gif are allowed.";
			}
		} catch (IOException | ServletException e) {
			e.printStackTrace();
			return "Error handling image file. Please ensure the file is valid.";
		}

		return null; // returning null if all validation pass
	}

	private UserModel extractUserModel(HttpServletRequest req, String newImageUrl) throws IOException, ServletException {
		// Getting form parameters
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String userName = req.getParameter("userName");
		LocalDate birthdate = LocalDate.parse(req.getParameter("birthday"));
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");

		// If no new image URL provided, get the current user's image URL
		String imageUrl;
		if (newImageUrl == null) {
			// Get current user info to preserve existing image URL
			String currentUserName = (String) SessionUtil.getAttribute(req, "username");
			UserModel currentUser = portfolioService.getUserInfo(currentUserName);
			imageUrl = currentUser.getImageUrl();
		} else {
			imageUrl = newImageUrl;
		}

		return new UserModel(userName, email, phone, birthdate, firstName, lastName, imageUrl, imageUrl, imageUrl);
	}
	
	private void handleSuccess(HttpServletRequest req, HttpServletResponse resp, String message, String redirectPage)
			throws ServletException, IOException {
		req.setAttribute("success", message);
		req.getRequestDispatcher(redirectPage).forward(req, resp);
}
	
}
	