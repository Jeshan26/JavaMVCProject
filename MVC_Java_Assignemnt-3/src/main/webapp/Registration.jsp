<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Registration</title>
    <link rel="stylesheet" href="./css/styles.css">
  
</head>
<body>
   <body>
    <div class="container">
        <h2>Please Fill the Below Details</h2>
        
    
        <form action="<%=request.getContextPath()%>/RegistrationServlet" method="post">
        
            <label for="company">Company</label>
            <input type="text" id="company" name="company" required>

            <label for="payroll">Payroll</label>
            <input type="text" id="payroll" name="payroll" required>

            <label for="fullName">Full Name</label>
            <input type="text" id="fullName" name="fullname" required>

            <label for="jobTitle">Job Title</label>
            <input type="text" id="jobTitle" name="jobtitle" required>

            <label for="roomNumber">Room Number</label>
            <input type="text" id="roomNumber" name="room" required>

            <label for="building">Building</label>
            <input type="text" id="building" name="building" required>

            <label for="location">Location</label>
            <input type="text" id="location" name="location" required>

            <label for="sector">Sector</label>
            <input type="text" id="sector" name="sector" required>

            <label for="requesterTel">Requester Tel Number</label>
            <input type="tel" id="requesterTel" name="requestertel" required pattern="[0-9]+" title="Only numbers are allowed">

            <button type="submit">Register</button>
        </form>
    </div>
    </body>
</html>
