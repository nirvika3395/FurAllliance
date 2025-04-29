<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - FurAlliance</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
    <div class="container">
        <!-- Left Panel -->
        <div class="left-panel">
            <h1>FurAlliance</h1>
            <p>Welcome Back!</p>
            <p>Manage, rescue, and rehome stray animals with ease.</p>
        </div>

        <!-- Divider -->
        <div class="divider"></div>

        <!-- Right Panel (Login Form) -->
        <div class="login-box">
            <h2>Login</h2>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="row">
                    <div class="col">
                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username" required>
                    </div>
                </div>     
                <div class="row">
                    <div class="col">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required>
                    </div>
                </div>

                <div style="text-align: right; margin-bottom: 10px;">
                    <a href="${pageContext.request.contextPath}/forgot-password" class="forgot-link">Forgot Password?</a>
                </div>

                <button type="submit" class="login-button">Login</button>

                <div class="link-container">
                    <a href="${pageContext.request.contextPath}/register">Don't have an account? Register</a>
                    
                </div>
            </form>
        </div>
    </div>
</body>
</html>
