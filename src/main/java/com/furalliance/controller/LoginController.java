package com.furalliance.controller;

import jakarta.servlet.ServletException;
  
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.furalliance.util.ValidationUtil;
import com.furalliance.model.UserModel;
import com.furalliance.service.LoginService;
import com.furalliance.util.CookieUtil;
import com.furalliance.util.SessionUtil;
import com.furalliance.util.RedirectionUtil;


/**
 * Servlet implementation class LoginController
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/login"} ) //array for multiple , if single '/login'

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValidationUtil validationUtil;
	private RedirectionUtil redirectionUtil;
	private LoginService loginService;
	
   public LoginController() {
	   super();
	   this.loginService = new LoginService();
	   this.validationUtil = new ValidationUtil();
	   
   }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response); 
	}
	
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//message can have different values accoringly while validating 
		//if (ValidationUtil.isNullOrEmpty("Username")|| ValidationUtil.isNullOrEmpty("Password")) {
			//message = "PLease enter all the fields"; 
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (!validationUtil.isNullOrEmpty("username") && !validationUtil.isNullOrEmpty("password")) {

			UserModel userModel = new UserModel(username, password);
			Boolean loginStatus = loginService.loginUser(userModel);

			if (loginStatus != null && loginStatus) {	
				SessionUtil.setAttribute(request, "username", username);
				if (username.equals("admin")) {
					CookieUtil.addCookie(response, "role", "admin", 5 * 30);
					response.sendRedirect(request.getContextPath() + "/dashboard"); // Redirect to /home
				} else {
					CookieUtil.addCookie(response, "role", "student", 5 * 30);
					response.sendRedirect(request.getContextPath() + "/home"); // Redirect to /home
				}
			} else {
				handleLoginFailure(request, response, loginStatus);
			}
		} else {
			redirectionUtil.setMsgAndRedirect(request, response, "error", "Please fill all the fields!",
					RedirectionUtil.loginUrl);
		}
	}
	 /**Handles login failures by setting attributes and forwarding to the login
	 * page.
	 *
	 * @param req         HttpServletRequest object
	 * @param resp        HttpServletResponse object
	 * @param loginStatus Boolean indicating the login status
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	private void handleLoginFailure(HttpServletRequest req, HttpServletResponse resp, Boolean loginStatus)
			throws ServletException, IOException {
		String errorMessage;
		if (loginStatus == null) {
			errorMessage = "Our server is under maintenance. Please try again later!";
		} else {
			errorMessage = "User credential mismatch. Please try again!";
		}
		req.setAttribute("error", errorMessage);
		req.getRequestDispatcher(RedirectionUtil.loginUrl).forward(req, resp);
	}
	}
