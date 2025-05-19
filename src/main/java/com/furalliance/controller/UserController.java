package com.furalliance.controller;

import com.furalliance.model.UserModel;
import com.furalliance.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/admin/users/*")
public class UserController extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        
        if (pathInfo == null || pathInfo.equals("/")) {
            // Show all users
            request.setAttribute("users", userService.getAllUsers());
            request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
        } else if (pathInfo.equals("/edit")) {
            // Show edit form
            String username = request.getParameter("username");
            UserModel user = userService.getUserByUsername(username);
            if (user != null) {
                request.setAttribute("editUser", user);
                request.setAttribute("users", userService.getAllUsers());
                request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/admin/users");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        
        if (pathInfo == null || pathInfo.equals("/")) {
            // Handle insert
            insertUser(request, response);
        } else if (pathInfo.equals("/update")) {
            // Handle update
            updateUser(request, response);
        } else if (pathInfo.equals("/delete")) {
            // Handle delete
            deleteUser(request, response);
        }
    }
    private void insertUser(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            UserModel user = new UserModel();
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setUserName(request.getParameter("username"));
            user.setDob(LocalDate.parse(request.getParameter("dob")));
            user.setGender(request.getParameter("gender"));
            user.setEmail(request.getParameter("email"));
            user.setNumber(request.getParameter("number"));
            user.setPassword(request.getParameter("password"));
            user.setImageUrl(request.getParameter("imageUrl"));

            if (userService.createUser(user)) {
                request.setAttribute("message", "User created successfully");
            } else {
                request.setAttribute("error", "Failed to create user");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error creating user: " + e.getMessage());
        }
        
        response.sendRedirect(request.getContextPath() + "/admin/users");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            UserModel user = new UserModel();
            user.setUserName(request.getParameter("username"));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setDob(LocalDate.parse(request.getParameter("dob")));
            user.setGender(request.getParameter("gender"));
            user.setEmail(request.getParameter("email"));
            user.setNumber(request.getParameter("number"));
            user.setPassword(request.getParameter("password"));
            user.setImageUrl(request.getParameter("imageUrl"));

            if (userService.updateUser(user)) {
                request.setAttribute("message", "User updated successfully");
            } else {
                request.setAttribute("error", "Failed to update user");
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error updating user: " + e.getMessage());
        }
        
        response.sendRedirect(request.getContextPath() + "/admin/users");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        
        if (userService.deleteUser(username)) {
            request.setAttribute("message", "User deleted successfully");
        } else {
            request.setAttribute("error", "Failed to delete user");
        }
        
        response.sendRedirect(request.getContextPath() + "/admin/users");
    }
}
