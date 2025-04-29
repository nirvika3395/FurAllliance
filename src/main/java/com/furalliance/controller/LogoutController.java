package com.furalliance.controller;

import java.io.IOException;

import com.furalliance.util.CookieUtil;
import com.furalliance.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


	@WebServlet(asyncSupported = true, urlPatterns = { "/logout" })
	public class LogoutController extends HttpServlet {
		private static final long serialVersionUID = 1L;

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			CookieUtil.deleteCookie(resp, "role");
			SessionUtil.invalidateSession(req);
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

