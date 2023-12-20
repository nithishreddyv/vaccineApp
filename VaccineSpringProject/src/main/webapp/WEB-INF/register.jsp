<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>register vaccine</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/vaccine.css"></c:url>">
	<script src="<c:url value="resources/js/vaccine.js"></c:url>"></script>
	<style>
		.eye-icon {
            position: relative;
            left: 140px;
            top: 30px;
            cursor: pointer;
        }
        .eye-icon1 {
            position: relative;
            left: 67px;
            top: 30px;
            cursor: pointer;
        }
	</style>
	<script>
		function togglePasswordVisibility() {
		    var passwordInput = document.getElementById('pwd');
		    var eyeIcon = document.querySelector('.eye-icon img');
		
		    if (passwordInput.type === 'password') {
		        passwordInput.type = 'text';
		        eyeIcon.src = '<c:url value="resources/images/eye.png"></c:url>';
		    } else {
		        passwordInput.type = 'password';
		        eyeIcon.src = '<c:url value="resources/images/eye-off.png"></c:url>';
		    }
		}
				
		function togglePasswordVisibility1() {
		    var passwordInput = document.getElementById('cpwd');
		    var eyeIcon = document.querySelector('.eye-icon1 img');
		
		    if (passwordInput.type === 'password') {
		        passwordInput.type = 'text';
		        eyeIcon.src = '<c:url value="resources/images/eye.png"></c:url>';
		    } else {
		        passwordInput.type = 'password';
		        eyeIcon.src = '<c:url value="resources/images/eye-off.png"></c:url>';
		    }
		}
	</script>
</head>
<body>
	<header>
    </header>
    
    <div class="registerhead">
	    <h3 style="color:green;">${responseMessage}</h3>
		<h3 style="color:red;">${response}</h3>
		<h3 style="color:red;">${Message}</h3>
    	<h1>Registration Form</h1>
    </div>
	<div class="form1">
	        <form action="register" onsubmit="return validate()" method="POST">
				<label for="uname">UserName:</label>
	            <input type="text" id="username" name="username" required>
	            <span id="msg" style="color:red"></span><br>
	            <label for="email">Email:</label>
	            <input type="email" id="email" name="email" required><br>
	            <label for="pwd">Password:</label>
	            <span class="eye-icon" onclick="togglePasswordVisibility()">
			        <img src="<c:url value="resources/images/eye-off.png"></c:url>" alt="Eye" width="20" height="20">
			    </span>
	            <input type="password" id="pwd" name="password" required>
	            <label for="cpwd">Confirm Password:</label>
	            <span class="eye-icon1" onclick="togglePasswordVisibility1()">
			        <img src="<c:url value="resources/images/eye-off.png"></c:url>" alt="Eye" width="20" height="20">
			    </span>
	            <input type="password" id="cpwd" name="cpwd" required>
	            <span id="msgp" style="color:red"></span><br>
	            <label for="mobile">Mobile Number:</label>
	            <input type="number" id="mobileNo" name="mobileNo" pattern="[789]{1}[0-9]{9}" required>
	            <span id="msg1" style="color:red"></span>
	            <br>
	            <label for="gender">Gender:</label><br>
	            <input type="radio" id="male" name="gender" value="Male" required>
	            <label for="male">Male</label>
	            <input type="radio" id="female" name="gender" value="Female" required>
	            <label for="female">FeMale</label><br><br>
	            <label for="dob">DateOfBirth:</label>
	            <input type="date" id="dob" name="dob" required><br>
	            <div class="sub">
					<input type="submit" value="submit" color="violet">
				</div>
	        </form>
	        <div class="cancel">
				<form action="gotoRegisterToIndex">
					<input type="submit" value="cancel" color="violet">
				</form>
			</div>
		</div>
    <footer>
    </footer>
</body>
</html>