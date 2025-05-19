<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adopt.css?v=1.1">
</head>
<body>
<jsp:include page="header.jsp" />
 <br>
 <br>
 
    <div style="text-align: center;">
    <h1 style="font-size: 2.5em; font-weight: bold; margin-bottom: 0.5em;">Adopt a Loving Pet</h1>
    <p style="font-size: 1.2em; margin-top: 0;">"Find your new best friend from our trusted rescues in Nepal"</p>
</div>
<br>
<br>
<br>
<br>

<div>
 <div class="slider-container">
        <a href="#" class="prev-arrow" onclick="changeSlide(-1)">&#10094;</a>
        <a href="#" class="next-arrow" onclick="changeSlide(1)">&#10095;</a>
        
        <div class="slider">
            <div class="slide" id="slide1">
                <div class="slide-text">
                    <h2 class="slide-heading">Bruno</h2>
                    <p class="slide-subheading">Lend a paw.</p>
                    <a href="#" class="btn">Learn More</a>
                </div>
                <div class="slide-image"></div>
            </div>
            
            <div class="slide" id="slide2">
                <div class="slide-text">
                    <h2 class="slide-heading">Shimba</h2>
                    <p class="slide-subheading">Find your new best friend.</p>
                    <a href="#" class="btn">Learn More</a>
                </div>
                <div class="slide-image"></div>
            </div>
            
            <div class="slide" id="slide3">
                <div class="slide-text">
                    <h2 class="slide-heading">Wishkers</h2>
                    <p class="slide-subheading">Support our mission.</p>
                    <a href="#" class="btn">Learn More</a>
                </div>
                <div class="slide-image"></div>
            </div>
            
            <div class="slide" id="slide4">
                <div class="slide-text">
                    <h2 class="slide-heading">Mimi</h2>
                    <p class="slide-subheading">Join our community.</p>
                    <a href="#" class="btn">Learn More</a>
                </div>
                <div class="slide-image"></div>
            </div>
        </div>
        
        <div class="dots-container">
            <div class="dot active" onclick="goToSlide(0)"></div>
            <div class="dot" onclick="goToSlide(1)"></div>
            <div class="dot" onclick="goToSlide(2)"></div>
            <div class="dot" onclick="goToSlide(3)"></div>
        </div>
    </div>

   <script>
        let currentSlide = 0;
        const slides = document.querySelectorAll('.slide');
        const dots = document.querySelectorAll('.dot');
        const slider = document.querySelector('.slider');
        
        // Initialize the slider
        function initSlider() {
            // Set initial positions
            showSlide(currentSlide);
            
            // Add event prevention for arrow clicks (stops page jumps)
            document.querySelector('.prev-arrow').addEventListener('click', function(e) {
                e.preventDefault();
                changeSlide(-1);
            });
            
            document.querySelector('.next-arrow').addEventListener('click', function(e) {
                e.preventDefault();
                changeSlide(1);
            });
            
            // Add click events to dots
            dots.forEach((dot, index) => {
                dot.addEventListener('click', function() {
                    goToSlide(index);
                });
            });
        }
        
        function showSlide(n) {
            slider.style.transform = `translateX(-${n * 100}%)`;
            
            // Update dots
            dots.forEach(dot => dot.classList.remove('active'));
            dots[n].classList.add('active');
        }
        
        function changeSlide(moveBy) {
            currentSlide += moveBy;
            
            // Loop back to beginning/end if needed
            if (currentSlide >= slides.length) {
                currentSlide = 0;
            }
            if (currentSlide < 0) {
                currentSlide = slides.length - 1;
            }
            
            showSlide(currentSlide);
        }
        
        function goToSlide(n) {
            currentSlide = n;
            showSlide(currentSlide);
        }
        
        // Initialize the slider when the page loads
        window.addEventListener('DOMContentLoaded', initSlider);
    </script>
</div>
  
  
  <div class="container">
    <!-- Cards -->
    <div class="card">
      <img src="/FurAlliance/resources/images/system/12adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Rocky</h3>
        <p>Friendly Labrador rescued from the streets of Kathmandu.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
        <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
    <div class="card">
     <img src="/FurAlliance/resources/images/system/1adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Luna</h3>
        <p>Gentle and playful kitten found near a temple in Patan.</p>
        <p class="rescue">Rescue: Animal Nepal</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
    <div class="card">
      <img src="/FurAlliance/resources/images/system/11adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Bruno</h3>
        <p>Energetic and loyal mixed-breed, great with kids.</p>
        <p class="rescue">Rescue: KAT Centre</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
    <div class="card">
      <img src="/FurAlliance/resources/images/system/2adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Mimi</h3>
        <p>Shy but affectionate, rescued from Bhaktapur.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
    <div class="card">
     <img src="/FurAlliance/resources/images/system/10adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Simba</h3>
        <p>Young street dog, loves attention and walks.</p>
        <p class="rescue">Rescue: Animal Nepal</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
    <div class="card">
      <img src="/FurAlliance/resources/images/system/3adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Shadow</h3>
        <p>Elegant black cat, great with other pets.</p>
        <p class="rescue">Rescue: KAT Centre</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
    <div class="card">
     <img src="/FurAlliance/resources/images/system/9adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Lucky</h3>
        <p>Survivor of road accident, now fully recovered and playful.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
    <div class="card">
     <img src="/FurAlliance/resources/images/system/4adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Whiskers</h3>
        <p>Curious and cuddly, enjoys napping in the sun.</p>
        <p class="rescue">Rescue: Animal Nepal</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
    <div class="card">
     <img src="/FurAlliance/resources/images/system/8adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Max</h3>
        <p>Loyal and intelligent, perfect for families.</p>
        <p class="rescue">Rescue: KAT Centre</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
    <div class="card">
      <img src="/FurAlliance/resources/images/system/5adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Tiger</h3>
        <p>Tabby cat rescued from a construction site in Lalitpur.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
          </div>
          </div>
          
         <div class="card">
      <img src="/FurAlliance/resources/images/system/7adopt.jpg" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Tiger</h3>
        <p>Tabby cat rescued from a construction site in Lalitpur.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
          </div>
          </div>
             <div class="card">
      <img src="/FurAlliance/resources/images/system/max.png" alt="Cat Image" style="width: 300px; height: 350px; border-radius: 10px;">
      <div class="card-content">
        <h3>Tiger</h3>
        <p>Tabby cat rescued from a construction site in Lalitpur.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
         <br>
          <a href="testimonials.html"><button class="btn-primary">ADOPT</button></a>
      </div>
    </div>
  </div>
  <jsp:include page="footer.jsp" />
</body>
</html>