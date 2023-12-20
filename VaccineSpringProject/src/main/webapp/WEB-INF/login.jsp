<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>login</title>
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
		    var passwordInput = document.getElementById('loginpassword');
		    var eyeIcon = document.querySelector('.eye-icon img');
		
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
	<% 
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Progma", "no-cache");
		response.setDateHeader("Expires",0);
	%>
	<header>
    </header>
    <div class="registerhead">
		<h3 style="color:red;">${resLoginPage}</h3>
		<h3 style="color:green;">${resetloginPage}</h3>
    	<h1 style="padding-left:55px;">Login Page</h1>
    </div>
	<div class="form1">
	        <form action="login" onsubmit="return validate()" method="POST">
				<label for="loginemail">Email:</label>
	            <input type="text" id="loginemail" name="email" required>
	            <span id="msg" style="color:red"></span><br>
	            <label for="loginpassword">Password:</label>
	            <span class="eye-icon" onclick="togglePasswordVisibility()">
			        <img src="<c:url value="resources/images/eye-off.png"></c:url>" alt="Eye" width="20" height="20">
			    </span>
	            <input type="password" id="loginpassword" name="password" required>
	            <div class="sub">
					<input type="submit" value="submit" color="violet">
				</div>
	        </form>
	        <div class="cancel">
				<form action="gotologinToRegister">
					<input type="submit" value="register" color="violet">
				</form>
			</div><br>
			<a href="openResetPage">forgot Password</a>
		</div>
    <footer style="bottom:0px;">
    </footer>
</body>
</html>