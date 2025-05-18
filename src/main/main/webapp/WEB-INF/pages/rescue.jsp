<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animal Rescue Request | FurAlliance</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/rescue.css">
</head>
<body>
<jsp:include page="header.jsp" />
<br>
<br>
    <div class="container">
        <!-- Status Messages -->
        <c:if test="${not empty success}">
            <div class="alert success">
                ${success}
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert error">
                ${error}
            </div>
        </c:if>

        <h1>Report an Injured Animal for Rescue</h1>

        <div class="rescue-form">
            <h2>Animal Rescue Request</h2>
            <form id="rescueForm" method="POST" action="${pageContext.request.contextPath}/rescue">
                <div class="form-group">
                    <label for="reporterName">Your Name:</label>
                    <input type="text" id="reporterName" name="reporterName" value="${param.reporterName}" required>
                </div>
                <div class="form-group">
                    <label for="reporterContact">Your Contact Number:</label>
                    <input type="tel" id="reporterContact" name="reporterContact" value="${param.reporterContact}" required>
                </div>
                <div class="form-group">
                    <label for="animalType">Type of Animal:</label>
                    <select id="animalType" name="animalType" required>
                        <option value="">-- Select --</option>
                        <option value="dog" ${param.animalType == 'dog' ? 'selected' : ''}>Dog</option>
                        <option value="cat" ${param.animalType == 'cat' ? 'selected' : ''}>Cat</option>
                        <option value="other" ${param.animalType == 'other' ? 'selected' : ''}>Other</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="location">Exact Location of Injured Animal:</label>
                    <textarea id="location" name="location" rows="3" required>${param.location}</textarea>
                </div>
                <div class="form-group">
                    <label for="injuryDescription">Description of Injury:</label>
                    <textarea id="injuryDescription" name="injuryDescription" rows="4" required>${param.injuryDescription}</textarea>
                </div>
                <div class="form-group">
                    <label for="urgency">Urgency Level:</label>
                    <select id="urgency" name="urgency" required>
                        <option value="">-- Select --</option>
                        <option value="high" ${param.urgency == 'high' ? 'selected' : ''}>High (Immediate attention needed)</option>
                        <option value="medium" ${param.urgency == 'medium' ? 'selected' : ''}>Medium (Needs attention within a few hours)</option>
                        <option value="low" ${param.urgency == 'low' ? 'selected' : ''}>Low (Can wait for later today)</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="additionalNotes">Additional Notes (Optional):</label>
                    <textarea id="additionalNotes" name="additionalNotes" rows="2">${param.additionalNotes}</textarea>
                </div>
                <button type="submit" class="submit-btn">Submit Rescue Request</button>
            </form>
        </div>

        <div class="furalliance-info">
            <h2>How FurAlliance Helps with Rescue Efforts</h2>
            <p>At FurAlliance, our primary mission is to streamline the process of rescuing stray animals in need. We understand that when an animal is injured, time is of the essence. That's why we've built this platform to act as a vital bridge connecting compassionate rescuers like you with the animal shelters equipped to provide the necessary care.</p>
            <p>When you submit a rescue request through the form above, FurAlliance instantly begins the process of identifying suitable shelters in your vicinity that have the capacity and resources to handle the specific needs of the injured animal. Our system efficiently communicates the critical details of the situation to these shelters, enabling them to quickly dispatch a rescue team or provide guidance on how best to assist the animal.</p>
        </div>
    </div>
    <br>

<jsp:include page="footer.jsp" />

<script>
// Client-side validation
document.getElementById('rescueForm').addEventListener('submit', function(e) {
    let isValid = true;
    const requiredFields = [
        'reporterName', 'reporterContact', 'animalType', 
        'location', 'injuryDescription', 'urgency'
    ];
    
    requiredFields.forEach(fieldId => {
        const field = document.getElementById(fieldId);
        if (!field.value.trim()) {
            field.style.border = '1px solid red';
            isValid = false;
        } else {
            field.style.border = '';
        }
    });
    
    if (!isValid) {
        e.preventDefault();
        alert('Please fill all required fields marked in red');
    }
    
    document.getElementById('rescueForm').addEventListener('submit', function(e) {
        const phone = document.getElementById('reporterContact').value;
        if (!validatePhoneNumber(phone)) {
            e.preventDefault();
            alert('Please enter a valid 10-15 digit phone number');
            return;
        }
});
</script>
</body>
</html>