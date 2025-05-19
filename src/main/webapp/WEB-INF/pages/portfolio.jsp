<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile - FurAlliance</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/profile.css?v=1.0">
</head>
<body>
<jsp:include page="header.jsp" />
<main class="container">
        <section class="profile">
            <div class="profile-header">
                <img src="url('/FurAlliance/resources/images/system/loginImg.png')" alt="Cover photo" class="cover-photo">
                <div class="profile-picture-container">
                    <div class="profile-picture">
                        <img src="url('/FurAlliance/resources/images/system/loginImg.png')" alt="Profile picture">
                    </div>
                </div>
                <div class="profile-actions">
                    <a href="#" class="btn btn-secondary">Edit Profile</a>
                    <a href="#" class="btn btn-primary">Log Activity</a>
                </div>
            </div>
            
            <div class="profile-content">
             
                <p class="profile-username">@sarahwilliams</p>
                <p class="profile-bio">Passionate animal rescuer and volunteer. Dedicated to helping stray animals find their forever homes. Specializing in cat rescue and rehabilitation.</p>
                
                <div class="profile-stats">
                    <div class="stat">
                        <span class="stat-value">37</span>
                        <span>Rescues</span>
                    </div>
                    <div class="stat">
                        <span class="stat-value">214</span>
                        <span>Volunteer Hours</span>
                    </div>
                    <div class="stat">
                        <span class="stat-value">8</span>
                        <span>Fostering</span>
                    </div>
                </div>
                
                <div class="profile-details">
                    <div class="profile-info">
                        <h2 class="detail-title">About</h2>
                        <div class="detail-item">
                            <div class="detail-icon">📍</div>
                            <div class="detail-text">Chicago, IL</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-icon">📞</div>
                            <div class="detail-text">(312) 555-1234</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-icon">📧</div>
                            <div class="detail-text">
							    <label for="email">Email Address</label>
							    <p id="email" name="email">${user.email}</p>
							</div>			
							                        </div>
							                        <div class="detail-item">
							                            <div class="detail-icon">🏆</div>
                            <div class="detail-text">Volunteer of the Month (March 2025)</div>
                        </div>
                        
                        <h2 class="detail-title" style="margin-top: 30px;">Volunteer Roles</h2>
                        <div>
                            <span class="badge badge-primary">Animal Rescuer</span>
                            <span class="badge badge-primary">Foster Provider</span>
                            <span class="badge badge-primary">Transport Volunteer</span>
                            <span class="badge badge-secondary">Medical Assistant</span>
                            <span class="badge badge-secondary">Event Coordinator</span>
                        </div>
                    </div>
                    
                    <div class="profile-certifications">
                        <h2 class="detail-title">Certifications & Skills</h2>
                        <div class="detail-item">
                            <div class="detail-icon">✅</div>
                            <div class="detail-text">Animal First Aid Certified</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-icon">✅</div>
                            <div class="detail-text">Feral Cat TNR Training</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-icon">✅</div>
                            <div class="detail-text">Behavioral Assessment Training</div>
                        </div>
                        <div class="detail-item">
                            <div class="detail-icon">✅</div>
                            <div class="detail-text">Emergency Animal Rescue</div>
                        </div>
                        
                        <div class="progress-container">
                            <div class="progress-label">
                                <span class="progress-text">Volunteer Level</span>
                                <span class="progress-text">Silver (214/300 hours)</span>
                            </div>
                            <div class="progress-bar">
                                <div class="progress-value" style="width: 71%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <section class="profile-tabs">
            <div class="tabs-header">
                <div class="tab active">My Animals</div>
                <div class="tab">Recent Activities</div>
                <div class="tab">Volunteering</div>
                <div class="tab">Donations</div>
            </div>
            
            <div class="tab-content">
                <div class="animals-list">
                    <div class="animal-card">
                        <img src="url('/FurAlliance/resources/images/system/loginImg.png')" alt="Animal photo" class="animal-img">
                        <div class="animal-info">
                            <h3 class="animal-name">Luna</h3>
                            <p class="animal-meta">Female Tabby Cat • 2 years old</p>
                            <span class="animal-status status-fostering">Currently Fostering</span>
                            <div class="animal-card-footer">
                                <a href="#" class="card-link">Medical Records</a>
                                <a href="#" class="card-link">Adoption Status</a>
                                <a href="#" class="card-link">Update Info</a>
                            </div>
                        </div>
                    </div>
                    
                    <div class="animal-card">
                        <img src="url('/FurAlliance/resources/images/system/loginImg.png')" alt="Animal photo" class="animal-img">
                        <div class="animal-info">
                            <h3 class="animal-name">Max</h3>
                            <p class="animal-meta">Male Golden Retriever Mix • 4 years old</p>
                            <span class="animal-status status-adopted">Adopted (Apr 12, 2025)</span>
                            <div class="animal-card-footer">
                                <a href="#" class="card-link">Medical Records</a>
                                <a href="#" class="card-link">Adoption Details</a>
                                <a href="#" class="card-link">Success Story</a>
                            </div>
                        </div>
                    </div>
                    
                    <div class="animal-card">
                        <img src="url('/FurAlliance/resources/images/system/loginImg.png')" alt="Animal photo" class="animal-img">
                        <div class="animal-info">
                            <h3 class="animal-name">Oliver</h3>
                            <p class="animal-meta">Male Tuxedo Cat • 1 year old</p>
                            <span class="animal-status status-fostering">Currently Fostering</span>
                            <div class="animal-card-footer">
                                <a href="#" class="card-link">Medical Records</a>
                                <a href="#" class="card-link">Adoption Status</a>
                                <a href="#" class="card-link">Update Info</a>
                            </div>
                        </div>
                    </div>
                    
                    <div class="animal-card">
                        <img src="url('/FurAlliance/resources/images/system/loginImg.png')" alt="Animal photo" class="animal-img">
                        <div class="animal-info">
                            <h3 class="animal-name">Bella</h3>
                            <p class="animal-meta">Female Calico Cat • 3 years old</p>
                            <span class="animal-status status-rescued">Recently Rescued (Apr 22, 2025)</span>
                            <div class="animal-card-footer">
                                <a href="#" class="card-link">Medical Records</a>
                                <a href="#" class="card-link">Assessment</a>
                                <a href="#" class="card-link">Update Info</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <<%-- assuming dob is a String like "2000-01-01" or LocalDate with proper toString() --%>
        </section>
    </main>
    <jsp:include page="footer.jsp" />
</body>
</html>