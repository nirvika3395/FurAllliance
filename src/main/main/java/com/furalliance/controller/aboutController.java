package com.furalliance.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = {"/about"} ) 
public class aboutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/about.jsp").forward(request, response);
		
		
		if (request.getAttribute("error") != null) {
		    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
		}
		
	}

	
}
