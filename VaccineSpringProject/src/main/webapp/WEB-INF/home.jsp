<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>home page</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/vaccine.css"></c:url>">
	<style>
		.addmemberbutton{
			background-color: #33BBC5;
		    color: white;
		    padding: 10px 30px;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		    margin-left:10px;
		}
		h3{
			margin-left:850px;
		    margin-right:20px;
		}
		.logoutbutton {
		    background-color: #33BBC5;
		    color: white;
		    padding: 10px 30px;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		}
		.container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .card {
            width: calc(33.33% - 80px);
            margin: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            height:300px;
        }

        .card-body {
            padding: 15px;
        }

        .card-title {
            font-size: 1.5em;
            margin-bottom: 10px;
        }

        .card-text {
            font-size: 1.5em;
            text-align:center;
        }
	</style>
	<script>
	<script>

	        function go() {

	            window.location

	                    .replace(

	                            "logout.jsp",

	                            'window',

	                            'toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');

	            self.close()

	        }

	    </script>
	</script>
</head>
<body>
	<header>
		<form action="gotoHomeToAddMember">
        	<button class="addmemberbutton">addmember</button>
        </form>
		<h3><% String em=(String)session.getAttribute("username");
		       out.println(em);%></h3>
   		<form action="logout">
        	<button class="logoutbutton">Log Out</button>
        </form>
	</header>
	<h2 style="color:green;text-align:center;">${resLogin}</h2>
	<h2 style="color:green;text-align:center;">${addm}</h2>
	<center><h1>Home page</h1></center>
	<div class="container">
    <div class="card" style="background-color:lightgreen;">
        <div class="card-body">
        	<br><br>
        	<center>
        		<img src="<c:url value="resources/images/vaccineregister.png"></c:url>" alt="registerpic" width="100" height="100">
        	</center>
        	<br>
            <p class="card-text">MemberCount : <%
            										int memberc=(int)session.getAttribute("membercount");
		       										out.println(memberc);
            									%>
		    </p>
        </div>
    </div>
    <div class="card" style="background-color:powderblue;">
        <div class="card-body">
            <h5 class="card-title">Card 2</h5>
            <p class="card-text">This is some text for Card 2.</p>
        </div>
    </div>
    <div class="card" style="background-color:orange;">
        <div class="card-body">
            <h5 class="card-title">Card 3</h5>
            <p class="card-text">This is some text for Card 3.</p>
        </div>
    </div>
	</div>
	<footer style="margin-top:75px;"></footer>
</body>
</html>