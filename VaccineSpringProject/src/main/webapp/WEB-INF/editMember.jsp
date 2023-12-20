<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>editMember</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/vaccine.css"></c:url>">
	<script src="<c:url value="resources/js/vaccine.js"></c:url>"></script>
	<style>
	    body{
    margin: 0;
    padding: 0;
    position: relative;
    min-height: 100vh;
		}
		
		header{
		    background-color: #614BC3;
		    color: white;
		    text-align: center;
		    display:flex;
		    align-items: center;
		    height:60px;
		    width:100%; 
		}
		
		.registerhead {
		    margin: 20px 400px 0px 510px;
		    padding: 30px 40px 40px 40px;
		}
		
		.form1 {
		    border: 1px solid #3498db;
		    background-color: #f2f2f2;
		    padding: 30px 40px 40px 40px;
		    margin: -42px 400px 110px 510px;
		    width: 250px;
		    display: relative;
		}
		
		.sub {
		    margin: 10px 0px 0px 15px;
		}
		
		.cancel{
			margin-top: -35px;
			margin-left:140px;
		}
		
		label {
		    color: rgb(0, 0, 0);
		    font-size: 20px;
		}
		
		input[type="text"],
		input[type="email"],
		input[type="number"],
		input[type="date"],
		input[type="password"]{
		    width: 95%;
		    padding: 7px;
		    margin-bottom: 10px;
		    border: 1px solid #ccc;
		    border-radius: 5px;
		}
		
		input[type="submit"] {
		    background-color: #3498db;
		    color: #fff;
		    padding: 10px;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		    width: 100px;
		}
		
		input[type="submit"]:hover {
		    background-color: #2980b9;
		}
		
		footer{
		    background-color: #614BC3;
		    color: white;
		    text-align: center;
		    display:flex;
		    width:100%;
		    height: 60px;
		}
	    h3
	    {
	    	margin-left:1050px;
	    }
	    
		#select{
	 		width: 100%;
		    padding: 7px;
		    margin-bottom: 10px;
		    border: 1px solid #ccc;
		    border-radius: 5px;
	 	}
	 	
	 	#idproof,#vaccineType,#dose{
	 		width: 100%;
		    padding: 7px;
		    margin-bottom: 10px;
		    border: 1px solid #ccc;
		    border-radius: 5px;  
		}
	</style>
</head>
<body>
	<header>
		<h3>
			<% String em=(String)session.getAttribute("username");
		       out.println(em);%>
		</h3>
    </header>
    <div class="registerhead">
		<h2 style="color:red;">${addm}</h2>
    	<h1 style="padding-left:45px;">EditMember</h1>
    </div>
	<div class="form1">
	        <form action="${pageContext.request.contextPath}/editMember" onsubmit="return validate()" method="POST">
				<label for="memberID">MemberID:</label>
	            <input type="text" id="memberID" name="memberID" value="${MEMBER_ID}" required readonly>
				<label for="memberName">MemberName:</label>
	            <input type="text" id="memberName" name="memberName" value="${MEMBER_NAME}" required>
	            <label for="mgender">Gender:</label><br>
	            <input type="radio" id="male" name="gender" value="Male" required>
	            <label for="male">Male</label>
	            <input type="radio" id="female" name="gender" value="Female" required>
	            <label for="female">FeMale</label><br><br>
	            <label for="mdob">DateOfBirth:</label>
	            <input type="date" id="mdob" name="dob" value="${MEMBER_DOB}" required><br>
	            <label for="idproof">IDProof</label>
	            <select id="idproof" name="idProof" >
	            	<option>${MEMBER_ID_PROOF}</option>
	            	<option>DrivingLicence</option>
	            	<option>AadharID</option>
	            	<option>PanCardID</option>
	            </select><br>
	            <label for="idproofnumber">IDProofNumber</label>
	            <input type="text" id="idproofnumber" name="idProofNumber" value="${MEMBER_ID_PROOF_NUMBER}"><br>
	            <label for="vaccineType">VaccineType</label>
	            <select id="vaccineType" name="vaccineType">
	            	<option>${MEMBER_VACCINE_TYPE}</option>
	            	<option>covishield</option>
	            	<option>covaxine</option>
					<option>sputnik</option>
	            </select><br>
	            <label for="dose">Dose</label>
	            <select id="dose" name="dose" >
	            	<option>${MEMBER_DOSE}</option>
	            	<option>1</option>
	            	<option>2</option>
	            	<option>3</option>
	            </select><br>
	            <div class="sub">
					<input type="submit" value="submit" color="violet">
				</div>
	        </form>
	        <div class="cancel">
				<form action="gotoEditMemberToAddMember">
					<input type="submit" value="cancel" color="violet">
				</form>
			</div><br>
		</div>
    <footer style="margin-top:60px;">
    </footer>
</body>
</html>