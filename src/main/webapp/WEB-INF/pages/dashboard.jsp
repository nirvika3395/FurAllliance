<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FurAlliance Admin Dashboard</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dashboard.css"/>
    
</head>
<body>
     <jsp:include page="header.jsp" />
    <div class="container">
        <header>
            <h1>FurAlliance Admin Dashboard</h1>
        </header>
        <section class="metrics">
            <div class="card">
                <h2>Total Animals</h2>
                <p>320</p>
            </div>
            <div class="card">
                <h2>Adopted</h2>
                <p>150</p>
            </div>
            <div class="card">
                <h2>In Shelter</h2>
                <p>170</p>
            </div>
        </section>

        <section class="distribution">
            <h2>Animal Intake Distribution</h2>
            <div class="chart-placeholder">
                <p>Chart Placeholder</p>
            </div>
        </section>

        <section class="recent-intakes">
            <h2>Recent Animal Intakes</h2>
            <table>
                <thead>
                    <tr>
                        <th>Intake Date</th>
                        <th>Species</th>
                        <th>Age</th>
                        <th>Shelter</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>2025-04-20</td>
                        <td>Dog</td>
                        <td>3 months</td>
                        <td>Fur Haven</td>
                    </tr>
                    <tr>
                        <td>2025-04-19</td>
                        <td>Cat</td>
                        <td>1 year</td>
                        <td>Happy Paws</td>
                    </tr>
                    <!-- Add more rows as necessary -->
                </tbody>
            </table>
        </section>
    </div>
     <jsp:include page="footer.jsp" />
    
</body>
</html>