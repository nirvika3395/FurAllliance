<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="page-wrapper">
        <!-- Header Section -->
          
            <jsp:include page="header.jsp" />
        

        <!-- Main Content Section -->
        <main class="main-content">
            <div class="admin-container">
                <h1>User Management</h1>
                
                <%-- Status Messages --%>
                <c:if test="${not empty success}">
                    <div class="alert alert-success">${success}</div>
                </c:if>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                
                <div class="admin-content-wrapper">
                    <%-- User Form --%>
                    <div class="user-form-container">
                        <h2>
                            <c:choose>
                                <c:when test="${empty user}">Add New User</c:when>
                                <c:otherwise>Edit User: ${user.userName}</c:otherwise>
                            </c:choose>
                        </h2>
                        
                        <form id="userForm" method="post" 
                              action="${pageContext.request.contextPath}/admin/users/${empty user ? 'insert' : 'update'}">
                            <c:if test="${not empty user}">
                                <input type="hidden" name="id" value="${user.id}">
                            </c:if>
                            
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="firstName">First Name</label>
                                    <input type="text" id="firstName" name="firstName" value="${user.firstName}" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="lastName">Last Name</label>
                                    <input type="text" id="lastName" name="lastName" value="${user.lastName}" required>
                                </div>
                            </div>
                            
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="username">Username</label>
                                    <input type="text" id="username" name="username" value="${user.userName}" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" id="email" name="email" value="${user.email}" required>
                                </div>
                            </div>
                            
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="dob">Date of Birth</label>
                                    <input type="date" id="dob" name="dob" value="${user.dob}">
                                </div>
                                
                                <div class="form-group">
                                    <label>Gender</label>
                                    <div class="radio-group">
                                        <label><input type="radio" name="gender" value="Male" ${user.gender == 'Male' ? 'checked' : ''}> Male</label>
                                        <label><input type="radio" name="gender" value="Female" ${user.gender == 'Female' ? 'checked' : ''}> Female</label>
                                        <label><input type="radio" name="gender" value="Other" ${user.gender == 'Other' ? 'checked' : ''}> Other</label>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-row">
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" id="password" name="password" ${empty user ? 'required' : ''}>
                                    <c:if test="${not empty user}">
                                        <small class="text-muted">Leave blank to keep current password</small>
                                    </c:if>
                                </div>
                                
                                <div class="form-group">
                                    <label for="imageUrl">Profile Image URL</label>
                                    <input type="url" id="imageUrl" name="imageUrl" value="${user.imageUrl}">
                                </div>
                            </div>
                            
                            <div class="form-row">
                                <div class="form-group checkbox-group">
                                    <label>
                                        <input type="checkbox" name="isAdmin" ${user.admin ? 'checked' : ''}>
                                        Admin User
                                    </label>
                                </div>
                                
                                <div class="form-group checkbox-group">
                                    <label>
                                        <input type="checkbox" name="isActive" ${user.active ? 'checked' : ''}>
                                        Active Account
                                    </label>
                                </div>
                            </div>
                            
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary">
                                    ${empty user ? 'Create User' : 'Update User'}
                                </button>
                                
                                <c:if test="${not empty user}">
                                    <button type="button" class="btn btn-secondary" onclick="resetForm()">Cancel</button>
                                </c:if>
                            </div>
                        </form>
                    </div>
                    
                    <%-- User List --%>
                    <div class="user-list-container">
                        <div class="list-header">
                            <h2>User List</h2>
                            
                            <div class="search-bar">
                                <input type="text" id="searchInput" placeholder="Search users...">
                                <button class="btn btn-search">Search</button>
                            </div>
                        </div>
                        
                        <div class="table-responsive">
                            <table class="user-table">
                                <thead>
                                    <tr>
                                        <th>Username</th>
                                        <th>Name</th>
                                        <th>Email</th>
                                        <th>Admin</th>
                                        <th>Active</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${users}" var="u">
                                        <tr>
                                            <td>${u.userName}</td>
                                            <td>${u.firstName} ${u.lastName}</td>
                                            <td>${u.email}</td>
                                            <td>${u.admin ? 'Yes' : 'No'}</td>
                                            <td>${u.active ? 'Yes' : 'No'}</td>
                                            <td class="actions">
                                                <a href="/admin/users/edit?id=${u.id}" class="btn btn-edit">Edit</a>
                                                <a href="/admin/users/delete?id=${u.id}" 
                                                   class="btn btn-delete" 
                                                   onclick="return confirm('Delete this user?')">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Footer Section -->
        
           <jsp:include page="footer.jsp" />
        
    </div>
    
    <script>
        function resetForm() {
            window.location.href = "/admin/users/list";
        }
        
        // Live search functionality
        $(document).ready(function() {
            $('#searchInput').on('keyup', function() {
                const value = $(this).val().toLowerCase();
                $('.user-table tbody tr').filter(function() {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
            
            // Add smooth fade-in effect when page loads
            $('.admin-content-wrapper').css('opacity', '0').animate({
                opacity: 1
            }, 400);
        });
    </script>
</body>
</html>