

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css?v=1.0">
<header>
   <a href="${pageContext.request.contextPath}/home" class="logo">F U R  A L L I A N C E</a>
   
    <%
        String loginStatus;
        String portfolio;
        String rescue;
        String about;
        String adopt;
        HttpSession currentSession = request.getSession(false);

        if (currentSession == null) {
            loginStatus = "Login";
        } else {
            loginStatus = "Logout" ;
        }
        portfolio = "Portfolio";
        rescue = "Rescue";
        adopt ="Adopt";
        about = "About";
    %>
    <nav>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/portfolio"><%= portfolio %></a></li>
             <li><a href="${pageContext.request.contextPath}/about"><%= about %></a></li>
            <li><a href="${pageContext.request.contextPath}/adopt"><%= adopt%></a></li>
            <li><a href="${pageContext.request.contextPath}/rescue"><%= rescue %></a></li>
            <li><a href="${pageContext.request.contextPath}/logout"><%= loginStatus %></a></li>
            
        </ul>
    </nav>
</header>
