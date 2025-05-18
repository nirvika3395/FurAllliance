package com.furalliance.controller;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;

import com.furalliance.model.UserModel;
import com.furalliance.services.RegisterService;
import com.furalliance.util.ImageUtil;
import com.furalliance.util.PasswordUtil;
import com.furalliance.util.RedirectionUtil;

@WebServlet(asyncSupported = true, urlPatterns = { "/register" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ImageUtil imageUtil;
	private RegisterService registerService;
	private RedirectionUtil redirectionUtil;

	@Override
	public void init() throws ServletException {
		this.registerService = new RegisterService();
		this.imageUtil = new ImageUtil();
		this.redirectionUtil = new RedirectionUtil();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(RedirectionUtil.registerUrl).forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserModel studentModel = extractStudentModel(req, resp);
			Boolean isAdded = registerService.addStudent(studentModel);

			if (isAdded == null) {
				redirectionUtil.setMsgAndRedirect(req, resp, "error",
						"An unexpected error occurred. Please try again later!", RedirectionUtil.registerUrl);
			} else if (isAdded) {
				if (uploadImage(req)) {
					redirectionUtil.setMsgAndRedirect(req, resp, "success", "Your account is successfully created!",
							RedirectionUtil.loginUrl);
				} else {
					redirectionUtil.setMsgAndRedirect(req, resp, "error",
							"Could not upload the image. Please try again later!", RedirectionUtil.registerUrl);
				}
			} else {
				redirectionUtil.setMsgAndRedirect(req, resp, "error",
						"Could not register your account. Please try again later!", RedirectionUtil.registerUrl);
			}
		} catch (Exception e) {
			redirectionUtil.setMsgAndRedirect(req, resp, "error",
					"An unexpected error occurred. Please try again later!", RedirectionUtil.registerUrl);
			e.printStackTrace(); // Log the exception
		}
	}

	private UserModel extractStudentModel(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String username = req.getParameter("username");
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String number = req.getParameter("phoneNumber");

		String password = req.getParameter("password");
		String retypePassword = req.getParameter("retypePassword");

		if (password == null || !password.equals(retypePassword)) {
			redirectionUtil.setMsgAndRedirect(req, resp, "error", "Please correct your password & retype-password!",
					RedirectionUtil.registerUrl);
		}

		password = PasswordUtil.encrypt(username, password);

		Part image = req.getPart("image");
		String imageUrl = imageUtil.getImageNameFromPart(image);

		return new UserModel(firstName, lastName, username, dob, gender, email, number, password,
				imageUrl);
	}

	private boolean uploadImage(HttpServletRequest req) throws IOException, ServletException {
		Part image = req.getPart("image");
		return imageUtil.uploadImage(image, req.getServletContext().getRealPath("/"), "student");
	}

}