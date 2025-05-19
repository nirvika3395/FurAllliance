package com.furalliance.util;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RedirectionUtil {

	private static final String baseUrl = "/WEB-INF/pages/";
	public static final String registerUrl = baseUrl + "register.jsp";
	public static final String loginUrl = baseUrl + "login.jsp";
	public static final String homeUrl = baseUrl + "home.jsp";
	public static final String adminUrl = baseUrl + "admin.jsp";
	public static final String rescueUrl = "rescue.jsp";

	public void setMsgAttribute(HttpServletRequest req, String msgType, String msg) {
		req.setAttribute(msgType, msg);
	}

	public void redirectToPage(HttpServletRequest req, HttpServletResponse resp, String page)
			throws ServletException, IOException {
		req.getRequestDispatcher(page).forward(req, resp);
	}

	public void setMsgAndRedirect(HttpServletRequest req, HttpServletResponse resp, String msgType, String msg,
			String page) throws ServletException, IOException {
		setMsgAttribute(req, msgType, msg);
		redirectToPage(req, resp, page);
	}
	
	 /**
     * Redirects to login page with optional return URL
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws IOException if redirect fails
     */
    public static void redirectToLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String contextPath = request.getContextPath();
        String returnUrl = request.getRequestURI();
        String queryString = request.getQueryString();
        
        if (queryString != null) {
            returnUrl = returnUrl + "?" + queryString;
        }
        
        String encodedUrl = URLEncoder.encode(returnUrl, StandardCharsets.UTF_8.toString());
        response.sendRedirect(contextPath + "/login?returnUrl=" + encodedUrl);
    }

    /**
     * Redirects with flash message that persists across redirect
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @param url Target URL (without context path)
     * @param messageType Type of message (success, error, warning)
     * @param message The message content
     * @throws IOException if redirect fails
     */
    public static void redirectWithMessage(HttpServletRequest request, HttpServletResponse response,
                                         String url, String messageType, String message) throws IOException {
        String contextPath = request.getContextPath();
        String redirectUrl = contextPath + url;
        
        // Store message in session for flash scope
        request.getSession().setAttribute(messageType, message);
        
        // Add session ID to URL if cookies are disabled
        if (request.isRequestedSessionIdFromURL()) {
            redirectUrl = response.encodeRedirectURL(redirectUrl);
        }
        
        response.sendRedirect(redirectUrl);
    }


}
	
	// indent control shift f
	
	

