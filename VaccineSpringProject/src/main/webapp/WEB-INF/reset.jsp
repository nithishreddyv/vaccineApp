<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>reset password</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/vaccine.css"></c:url>">
	<script src="<c:url value="resources/js/vaccine.js"></c:url>"></script>
	<style>
		.eye-icon {
            position: relative;
            left: 98px;
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
		<h3 style="color:red;">${resetPage}</h3>
    	<h1 style="padding-left:20px;">ResetPassword</h1>
    </div>
	<div class="form1">
	        <form action="reset" onsubmit="return validate()" method="POST">
				<label for="resertEmail">Email:</label>
	            <input type="text" id="resetemail" name="email" required>
	            <span id="msg" style="color:red"></span><br>
	            <label for="pwd">New Password:</label>
	            <span class="eye-icon" onclick="togglePasswordVisibility()">
			        <img src="<c:url value="resources/images/eye-off.png"></c:url>" alt="Eye" width="20" height="20">
			    </span>
	            <input type="password" id="pwd" name="password" required>
	            <label for="cpwd">Confirm Password:</label>
	            <span class="eye-icon1" onclick="togglePasswordVisibility1()">
			        <img src="<c:url value="resources/images/eye-off.png"></c:url>" alt="Eye" width="20" height="20">
			    </span>
	            <input type="password" id="cpwd" name="confirmPassword" required>
	            <span id="msgp" style="color:red"></span><br>
	            <div class="sub">
					<input type="submit" value="reset" color="violet">
				</div>
	        </form>
	        <div class="cancel">
				<form action="gotoResetToLogin">
					<input type="submit" value="login" color="violet">
				</form>
			</div>
		</div>
    <footer style="bottom:0px;">
    </footer>
</body>
</html>