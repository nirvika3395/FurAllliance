<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rescue.css">
</head>
<body>
<jsp:include page="header.jsp" />
<br>
<br>
    <div class="container">
        <h1>Report an Injured Animal for Rescue</h1>

        <div class="rescue-form">
            <h2>Animal Rescue Request</h2>
            <form id="rescueForm">
                <div class="form-group">
                    <label for="reporterName">Your Name:</label>
                    <input type="text" id="reporterName" name="reporterName" required>
                </div>
                <div class="form-group">
                    <label for="reporterContact">Your Contact Number:</label>
                    <input type="text" id="reporterContact" name="reporterContact" required>
                </div>
                <div class="form-group">
                    <label for="animalType">Type of Animal:</label>
                    <select id="animalType" name="animalType">
                        <option value="dog">Dog</option>
                        <option value="cat">Cat</option>
                        <option value="other">Other</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="location">Exact Location of Injured Animal:</label>
                    <textarea id="location" name="location" rows="3" placeholder="Please be as specific as possible (e.g., near a landmark, address)." required></textarea>
                </div>
                <div class="form-group">
                    <label for="injuryDescription">Description of Injury:</label>
                    <textarea id="injuryDescription" name="injuryDescription" rows="4" placeholder="Describe the visible injuries and the animal's condition." required></textarea>
                </div>
                <div class="form-group">
                    <label for="urgency">Urgency Level:</label>
                    <select id="urgency" name="urgency">
                        <option value="high">High (Immediate attention needed)</option>
                        <option value="medium">Medium (Needs attention within a few hours)</option>
                        <option value="low">Low (Can wait for later today)</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="additionalNotes">Additional Notes (Optional):</label>
                    <textarea id="additionalNotes" name="additionalNotes" rows="2" placeholder="Any other relevant information."></textarea>
                </div>
                <button type="submit">Submit Rescue Request</button>
            </form>
        </div>

        <div class="furalliance-info">
            <h2>How FurAlliance Helps with Rescue Efforts</h2>
            <p>At FurAlliance, our primary mission is to streamline the process of rescuing stray animals in need. We understand that when an animal is injured, time is of the essence. That's why we've built this platform to act as a vital bridge connecting compassionate rescuers like you with the animal shelters equipped to provide the necessary care.</p>
            <p>When you submit a rescue request through the form above, FurAlliance instantly begins the process of identifying suitable shelters in your vicinity that have the capacity and resources to handle the specific needs of the injured animal. Our system efficiently communicates the critical details of the situation to these shelters, enabling them to quickly dispatch a rescue team or provide guidance on how best to assist the animal.</p>
            <p>Furthermore, FurAlliance fosters collaboration between different animal shelters. By creating a connected network, we ensure that no animal is left without help due to a single shelter being at capacity or lacking specific resources. We facilitate the transfer of animals between shelters when necessary, ensuring they receive the most appropriate care as swiftly as possible. Together, with the help of dedicated rescuers and a unified network of shelters, FurAlliance is making a significant difference in the lives of vulnerable stray animals.</p>
        </div>
    </div>
    <br>

<jsp:include page="footer.jsp" />
</body>
</html>