package com.furalliance.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/rescue"} ) 
public class RescueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/rescue.jsp").forward(request, response);
		
		
		if (request.getAttribute("error") != null) {
		    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
		}
		
	}
	
}
