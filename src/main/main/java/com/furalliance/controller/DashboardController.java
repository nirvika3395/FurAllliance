package com.furalliance.controller;

import com.furalliance.model.UserModel;
import com.furalliance.services.DashboardService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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
			
			
			
		}
		}