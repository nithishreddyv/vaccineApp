<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Vaccine</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/vaccine.css"></c:url>">
	<style>
		h1{
			margin-left:300px;
		}
		.siginbutton {
		    background-color: #33BBC5;
		    color: white;
		    padding: 10px 30px;
		    margin-left:550px;
		    margin-right: 15px;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		}
		.loginbutton
		{
			background-color: #33BBC5;
		    color: white;
		    padding: 10px 30px;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		}
	</style>
</head>
<body>
	<header>
   		<h1>Vaccine Application</h1>
   		<form action="openRegisterPage">
        	<button class="siginbutton">Sign Up</button>
        </form>
        <form action="openLoginPage">
        	<button class="loginbutton">Login</button>
        </form>
    </header>
		<img src="https://www.gavi.org/sites/default/files/vaccineswork/2021/Thumb/shutterstock_1793844784_h2.jpg" width="100%" height="530px">
    <footer style="bottom:0px;">
    </footer>
</body>
</html>