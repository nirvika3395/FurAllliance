package com.furalliance.controller;

import jakarta.servlet.ServletException;

import com.furalliance.model.RescueModel;
import com.furalliance.service.RescueService;
import com.furalliance.util.RedirectionUtil;

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
	private RescueService rescueService;
    private RedirectionUtil redirectionUtil;
    private RescueModel rescuemodel;
    
    
    @Override
    public void init() throws ServletException {
        this.rescueService = new RescueService();
        this.redirectionUtil = new RedirectionUtil();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/rescue.jsp").forward(request, response);
		
		
		if (request.getAttribute("error") != null) {
		    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
		}
		
		
	}
	
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        try {
	            RescueModel request = extractRescueRequest(req);
	            Boolean isAdded = rescueService.addRescueRequest(request);
	            if (isAdded == null || !isAdded) {
	                redirectionUtil.setMsgAndRedirect(req, resp, "error",
	                        "Failed to submit rescue request. Please try again.", RedirectionUtil.rescueUrl);
	            } else {
	                redirectionUtil.setMsgAndRedirect(req, resp, "success",
	                        "Rescue request submitted successfully!", RedirectionUtil.homeUrl);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            redirectionUtil.setMsgAndRedirect(req, resp, "error",
	                    "An unexpected erro r occurred. Please try again.", RedirectionUtil.rescueUrl);
	        }
	    }
	 
	 
	 private RescueModel extractRescueRequest(HttpServletRequest req) {
			String name = req.getParameter("name");
			String contactNumber = req.getParameter("contactNumber");
			String typeOfAnimal = req.getParameter("typeOfAnimal");
			String descriptionOfInjury = req.getParameter("descriptionOfInjury");
			String urgencyLevel = req.getParameter("urgencyLevel");
			String location = req.getParameter("location");
			String additionalNotes = req.getParameter("additionalNotes");

			return new RescueModel(name, contactNumber, typeOfAnimal, descriptionOfInjury, urgencyLevel, location, additionalNotes);

		}
	}
	
	

