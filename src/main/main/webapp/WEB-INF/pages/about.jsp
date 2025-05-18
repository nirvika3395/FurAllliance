<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/about.css" />


<title>about page here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<br>
	<br>
<body>

	<div class="page-container">
		<!-- Sidebar navigation -->
		<div class="sidebar" id="sidebar">
			<div class="sidebar-header">
				<div class="logo">Pet Resources</div>
				<button class="toggle-btn" id="toggleSidebar">&#9776;</button>
			</div>

			<div class="nav-item active">
				<i>📍</i> <span>About FurAlliance</span>
			</div>

			<!-- Veterinary Care Section -->
			<div class="nav-section">
				<div class="section-title">Veterinary Care</div>
				<div class="nav-item">
					<i>☎️</i> <span>Emergency Services</span>
				</div>
				<div class="nav-item">
					<i>💉</i> <span>Vaccinations</span>
				</div>
				<div class="nav-item">
					<i>🩺</i> <span>Prescriptions</span>
				</div>
			</div>

			<!-- Shelters Section -->
			<div class="nav-section">
				<div class="section-title">Shelters</div>
				<div class="nav-item">
					<i>🏠</i> <span>Local Shelters</span>
				</div>
				<div class="nav-item">
					<i>🐕</i> <span>Adoption Events</span>
				</div>
				<div class="nav-item">
					<i>🤎</i> <span>Donations</span>
				</div>
			</div>
		</div>

		<!-- Mobile toggle button - outside the sidebar -->
		<button class="mobile-toggle" id="mobileToggle">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>

		<div class="content" id="content">
			<h1></h1>
			<br> <br>
			<div class="container">
				<!-- Left Panel -->
				<div class="left-panel">
					<h1>FurAlliance</h1>
					<p>At FurAlliance, we believe that every stray animal deserves
						a second chance at life : a life filled with care, dignity, and
						love. FurAlliance is a tech-driven platform designed to bridge the
						gap between compassionate individuals and the organizations
						working tirelessly to rescue and rehabilitate stray animals across
						Nepal. Our mission is to create a transparent, accessible, and
						action-oriented ecosystem that empowers communities to actively
						participate in the rescue, treatment, and rehoming of animals in
						need.</p>
					<p>Manage, rescue, and rehome stray animals with ease.</p>
				</div>
				<br> <br>

				<div class="left-panel"
					style="display: flex; justify-content: center;">
								<img src="/FurAlliance/resources/images/system/aboutimg.jpg"
									alt="Cat Image">
							</div>
							
							



				<div class="left-panel">
					<h1>Why FurAlliance?</h1>
					<p>Nepal faces a growing challenge with the number of stray
						animals left unattended. FurAlliance was created to be more than
						just an information hub ,it’s a community of action, a network of
						care, and a digital ally to both humans and animals. By harnessing
						technology, we aim to make animal rescue faster, more coordinated,
						and deeply impactful. Whether you're an animal lover, a field
						volunteer, a shelter staff member, or simply someone who wants to
						help .FurAlliance is your gateway to saving lives and creating
						hope. Join the alliance. Be the voice. Save a life.</p>
					<div style="display: flex; justify-content: center; gap: 50px;">
						<a href="https://www.facebook.com/snehazcare" target="_blank">
							<img src="/FurAlliance/resources/images/system/about1.png"
							alt="Cat Image 1"
							style="width: 300px; height: auto; border-radius: 10px; transition: transform 0.3s ease;"
							onmouseover="this.style.transform='scale(1.05)'"
							onmouseout="this.style.transform='scale(1)'">
						</a> <a href="https://www.facebook.com/katcentrenepal" target="_blank">
							<img src="/FurAlliance/resources/images/system/about2.png"
							alt="Cat Image 2"
							style="width: 300px; height: auto; border-radius: 10px; transition: transform 0.3s ease;"
							onmouseover="this.style.transform='scale(1.05)'"
							onmouseout="this.style.transform='scale(1)'">
						</a> <a href="https://www.facebook.com/StreetDogCare" target="_blank">
							<img src="/FurAlliance/resources/images/system/about3.png"
							alt="Cat Image 3"
							style="width: 300px; height: auto; border-radius: 10px; transition: transform 0.3s ease;"
							onmouseover="this.style.transform='scale(1.05)'"
							onmouseout="this.style.transform='scale(1)'">
						</a>
					</div>


				</div>


				<div class="left-panel">
					<h1>What We Do</h1>
					<ul>
						<li><strong>Rescue Coordination:</strong> We facilitate
							prompt and effective stray animal rescues by connecting the
							public with nearby shelters and field professionals.</li>
						<br>
						<li><strong>Shelter Information:</strong> Access verified
							details about leading animal welfare organizations like Animal
							Nepal, Sneha’s Care, and KAT Nepal : all in one place.</li>
						<br>
						<li><strong>Veterinary Access:</strong> Instantly connect
							with veterinary services around your location for emergency or
							scheduled treatments.</li>
						<br>
						<li><strong>Transparent Fundraising:</strong> Support
							verified rescue missions, medical treatments, and food drives
							through our secure and transparent donation system.</li>
						<br>
						<li><strong>Adoption Support:</strong> Help stray animals
							find their forever homes by browsing our adoptable animal
							listings and learning how you can make a difference.</li>
					</ul>

				</div>


				<div class="left-panel">
					<h1>Why It Matters</h1>
					<p>In a world where stray animals are often treated as a
						nuisance, FurAlliance fights to give them the voice, care, and
						dignity they deserve. It's a call to action for those who’ve felt
						helpless before — now, you can do something. Whether you're a
						student, a rescuer, an animal lover, or someone who's been through
						the pain of losing a beloved pet without help — FurAlliance is for
						you.</p>

					<p style="text-align: center; font-weight: bold;">"We couldn't
						save one, but now we work to save thousands."</p>




					<div style="display: flex; justify-content: center; gap: 70px;">
						<a href="https://www.facebook.com/katcentrenepal" target="_blank">
							<img src="/FurAlliance/resources/images/system/about4.png"
							alt="Cat Image 1"
							style="width: 300px; height: auto; border-radius: 10px; transition: transform 0.3s ease;"
							onmouseover="this.style.transform='scale(1.05)'"
							onmouseout="this.style.transform='scale(1)'">
						</a> <a href="https://www.facebook.com/katcentrenepal" target="_blank">
							<img src="/FurAlliance/resources/images/system/about5.png"
							alt="Cat Image 2"
							style="width: 300px; height: auto; border-radius: 10px; transition: transform 0.3s ease;"
							onmouseover="this.style.transform='scale(1.05)'"
							onmouseout="this.style.transform='scale(1)'">
						</a>
					</div>



				</div>


				<div class="left-panel">
					<h1>Pet Resources</h1>
					<p>Select a category from the sidebar to explore veterinary
						care options and shelters in your area.</p>
					<p>Our comprehensive directory helps pet owners find the
						resources they need quickly and easily.</p>

					<h1>What we offer</h1>
					<ul>
						<li><strong>🐾 Emergency Rescue Coordination:</strong>
							Connect instantly with professionals and nearby shelters during
							critical situations.</li>
						<br>
						<li><strong>🏥 Verified Veterinary Access:</strong> Find
							real, qualified veterinary care around you: no quacks, no scams.</li>
						<br>
						<li><strong>🤝 Shelter Information & Networking:</strong>
							View and support established shelters like Animal Nepal, Sneha’s
							Care, and KAT Nepal.</li>
						<br>
						<li><strong>💚 Transparent Fundraising:</strong> Donate with
							confidence. Every rupee goes directly to verified causes and
							rescues.</li>
						<br>
						<li><strong>🏡 Adoption Services:</strong> Help animals find
							loving homes through our curated adoption system.</li>
					</ul>
					<br>

					<p style="text-align: center; font-weight: bold;">Join the
						movement. Restore the hope. Be the difference.</p>
				</div>

			</div>




		</div>




	</div>

	<jsp:include page="footer.jsp" />

	<script>
// Toggle sidebar on desktop
const toggleBtn = document.getElementById('toggleSidebar');
const sidebar = document.getElementById('sidebar');
const content = document.getElementById('content');

toggleBtn.addEventListener('click', () => {
  sidebar.classList.toggle('sidebar-collapsed');

  // If sidebar is collapsed, hide text elements
  const textElements = sidebar.querySelectorAll('.section-title, .nav-item span, .logo');
  textElements.forEach(el => {
    el.style.display = sidebar.classList.contains('sidebar-collapsed') ? 'none' : 'block';
  });
});

// Toggle sidebar on mobile
const mobileToggle = document.getElementById('mobileToggle');

mobileToggle.addEventListener('click', () => {
  sidebar.classList.toggle('show');
});

// Highlight active menu item
const menuItems = document.querySelectorAll('.nav-item');

menuItems.forEach(item => {
  item.addEventListener('click', () => {
    // Remove active class from all items
    menuItems.forEach(i => i.classList.remove('active'));

    // Add active class to clicked item
    item.classList.add('active');

    // On mobile, close the sidebar after selection
    if (window.innerWidth <= 768) {
      sidebar.classList.remove('show');
    }
  });
});
</script>
</body>


</html>