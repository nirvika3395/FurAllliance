<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Home - FurAlliance</title>
  <link rel="stylesheet" href="${contextPath}/css/header.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css?v=1.0">
  <link rel="stylesheet" href="${contextPath}/css/footer.css" />
  <link rel="stylesheet" href="${contextPath}/css/validation.css" />
</head>
<body>
  <jsp:include page="header.jsp" />

  <!-- Main Content -->
  <div class="main-container">
    
    <!-- SUCCESS STORIES Section -->
    <div class="content-section">
      <div class="content-left">
        <h2>SUCCESS STORIES</h2>
        <h3>Maria Rodriguez</h3>
        <p>"FurAlliance changed my life when they helped me rescue and rehabilitate
          a litter of abandoned kittens. Now two of those kittens have their
          forever home with me, and the others found loving families too!"
        </p>
        <a href="testimonials.html"><button class="btn-primary">MORE STORIES</button></a>
      </div>
      <div class="content-right">
        <div class="quote-box">“Every life matters.”</div>
      </div>
    </div>

    <!-- OUR MISSION Section -->
    <div class="content-section">
      <div class="content-left">
        <div class="quote-box">Rescue · Rehabilitate · Rehome</div>
      </div>
      <div class="content-right">
        <h2>Our Mission</h2>
        <p>Founded in 2022, FurAlliance is dedicated to rescuing, rehabilitating, and rehoming stray animals in our community. We believe every animal deserves love, care, and a safe place to call home. Through rescue operations, foster networks, and community education, we're creating a world where no animal is left behind.</p>
        <a href="about.html"><button class="btn-primary">LEARN MORE</button></a>
      </div>
    </div>

    <!-- ANIMALS LOOKING FOR HOMES Section -->
    <p class="section-title">ANIMALS LOOKING FOR HOMES</p>
    <div class="feature-grid">
      <div class="feature-item">
        <h4>Max</h4>
        <p>2-year-old Lab mix, playful and loves kids</p>
      </div>
      <div class="feature-item">
        <h4>Luna</h4>
        <p>1-year-old tabby, affectionate and gentle</p>
      </div>
      <div class="feature-item">
        <h4>Buddy</h4>
        <p>4-year-old shepherd mix, loyal companion</p>
      </div>
    </div>

    <!-- HOW YOU CAN HELP Section -->
    <p class="section-title">HOW YOU CAN HELP</p>
    <div class="feature-grid">
      <div class="feature-item">
        <h4>Adopt a Friend</h4>
        <p>Give a forever home to a loving pet.</p>
      </div>
      <div class="feature-item">
        <h4>Become a Foster</h4>
        <p>Provide temporary care for animals in need.</p>
      </div>
      <div class="feature-item">
        <h4>Donate Supplies</h4>
        <p>Support us with food, bedding, and funds.</p>
      </div>
      <div class="feature-item">
        <h4>Volunteer</h4>
        <p>Join our team and make a difference today.</p>
      </div>
    </div>
  </div>

  <jsp:include page="footer.jsp" />
</body>
</html>
