package com.furalliance.controller;

import com.furalliance.model.UserModel;
import com.furalliance.service.DashboardService;
import com.furalliance.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@WebServlet(asyncSupported = true, urlPatterns = "/dashboard")
public class DashboardController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DashboardService dashboardService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardController() {
		super();
		
		
	}
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(request, response);
			
			
			if (request.getAttribute("error") != null) {
			    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
			}
			
		UserService userService = new UserService();
		List<UserModel> users = userService.getAllUsers();
		request.setAttribute("users", users);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String action = request.getParameter("action");
			if (action != null) {
				switch (action) {
					case "add":
						UserModel newUser = new UserModel(
							request.getParameter("firstName"),
							request.getParameter("lastName"), 
							request.getParameter("username"),
							LocalDate.parse(request.getParameter("dob")),
							request.getParameter("gender"),
							request.getParameter("email"),
							request.getParameter("number"),
							request.getParameter("password"),
							request.getParameter("imageUrl")
						);
						UserService userService = new UserService();
						userService.createUser(newUser);
						break;
					case "update":
						UserModel updatedUser = new UserModel(
							request.getParameter("firstName"),
							request.getParameter("lastName"),
							request.getParameter("username"), 
							LocalDate.parse(request.getParameter("dob")),
							request.getParameter("gender"),
							request.getParameter("email"),
							request.getParameter("number"),
							request.getParameter("password"),
							request.getParameter("imageUrl")
						);
						userService = new UserService();
						userService.updateUser(updatedUser);
						break;
					case "delete":
						String username = request.getParameter("username");
						userService = new UserService();
						userService.deleteUser(username);
						break;
				}
			}
		}
}