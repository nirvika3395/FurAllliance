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
  <header>
    <h1>Adopt a Loving Pet</h1>
    <p>Find your new best friend from our trusted rescues in Nepal</p>
  </header>
  <div class="container">
    <!-- Cards -->
    <div class="card">
      <img src="https://place-puppy.com/300x200" alt="Dog 1">
      <div class="card-content">
        <h3>Rocky</h3>
        <p>Friendly Labrador rescued from the streets of Kathmandu.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
      </div>
    </div>
    <div class="card">
      <img src="https://placekitten.com/300/200" alt="Cat 1">
      <div class="card-content">
        <h3>Luna</h3>
        <p>Gentle and playful kitten found near a temple in Patan.</p>
        <p class="rescue">Rescue: Animal Nepal</p>
      </div>
    </div>
    <div class="card">
      <img src="https://place-puppy.com/300x201" alt="Dog 2">
      <div class="card-content">
        <h3>Bruno</h3>
        <p>Energetic and loyal mixed-breed, great with kids.</p>
        <p class="rescue">Rescue: KAT Centre</p>
      </div>
    </div>
    <div class="card">
      <img src="https://placekitten.com/301/200" alt="Cat 2">
      <div class="card-content">
        <h3>Mimi</h3>
        <p>Shy but affectionate, rescued from Bhaktapur.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
      </div>
    </div>
    <div class="card">
      <img src="https://place-puppy.com/302x200" alt="Dog 3">
      <div class="card-content">
        <h3>Simba</h3>
        <p>Young street dog, loves attention and walks.</p>
        <p class="rescue">Rescue: Animal Nepal</p>
      </div>
    </div>
    <div class="card">
      <img src="https://placekitten.com/302/200" alt="Cat 3">
      <div class="card-content">
        <h3>Shadow</h3>
        <p>Elegant black cat, great with other pets.</p>
        <p class="rescue">Rescue: KAT Centre</p>
      </div>
    </div>
    <div class="card">
      <img src="https://place-puppy.com/303x200" alt="Dog 4">
      <div class="card-content">
        <h3>Lucky</h3>
        <p>Survivor of road accident, now fully recovered and playful.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
      </div>
    </div>
    <div class="card">
      <img src="https://placekitten.com/303/200" alt="Cat 4">
      <div class="card-content">
        <h3>Whiskers</h3>
        <p>Curious and cuddly, enjoys napping in the sun.</p>
        <p class="rescue">Rescue: Animal Nepal</p>
      </div>
    </div>
    <div class="card">
      <img src="https://place-puppy.com/304x200" alt="Dog 5">
      <div class="card-content">
        <h3>Max</h3>
        <p>Loyal and intelligent, perfect for families.</p>
        <p class="rescue">Rescue: KAT Centre</p>
      </div>
    </div>
    <div class="card">
      <img src="https://placekitten.com/304/200" alt="Cat 5">
      <div class="card-content">
        <h3>Tiger</h3>
        <p>Tabby cat rescued from a construction site in Lalitpur.</p>
        <p class="rescue">Rescue: Sneha's Care</p>
      </div>
    </div>
  </div>
  <jsp:include page="footer.jsp" />
</body>
</html>