

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css?v=1.0">
<header>
    <div class="logo"> F U R  A L L I A N C E</div>
    <%
        String loginStatus;
        String profile;
        String rescue;
        String adopt;
        HttpSession currentSession = request.getSession(false);

        if (currentSession == null) {
            loginStatus = "Login";
        } else {
            loginStatus = "Logout" ;
        }
        profile = "Profile";
        rescue = "Rescue";
        adopt ="Adopt";
    %>
    <nav>
        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/profile"><%= profile %></a></li>
            <li><a href="${pageContext.request.contextPath}/adopt"><%= adopt %></a></li>
            <li><a href="${pageContext.request.contextPath}/rescue"><%= rescue %></a></li>
            <li><a href="${pageContext.request.contextPath}/logout"><%= loginStatus %></a></li>
        </ul>
    </nav>
</header>
