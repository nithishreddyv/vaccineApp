<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>addmember</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/vaccine.css"></c:url>">
	<script src="<c:url value="resources/js/vaccine.js"></c:url>"></script>
	<style>
	    .viewmembers
	    {
	    	margin-left:10px;
	    }
	    
	    h3
	    {
	    	margin-left:970px;
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
		<div class="viewmembers">
			<form action="openViewMembers">
				<input type="submit" value="ViewMembers" color="violet">
			</form>
		</div>
		<h3>
			<% String em=(String)session.getAttribute("username");
		       out.println(em);%>
		</h3>
    </header>
    <div class="registerhead">
		<h2 style="color:red;">${addm}</h2>
		<h2 style="color:green;">${addmm}</h2>
		<h2 style="color:green;">${addmmm}</h2>
		<h2 style="color:green;">${responseMessage}</h2>
    	<h1 style="padding-left:45px;">AddMember</h1>
    </div>
	<div class="form1">
	        <form action="addmember" onsubmit="return validate()" method="POST">
				<label for="memberName">MemberName:</label>
	            <input type="text" id="memberName" name="memberName" required>
	            <label for="mgender">Gender:</label><br>
	            <input type="radio" id="male" name="gender" value="Male" required>
	            <label for="male">Male</label>
	            <input type="radio" id="female" name="gender" value="Female" required>
	            <label for="female">FeMale</label><br><br>
	            <label for="mdob">DateOfBirth:</label>
	            <input type="date" id="mdob" name="dob" required><br>
	            <label for="idproof">IDProof</label>
	            <select id="idproof" name="idProof">
	            	<option>DrivingLicence</option>
	            	<option>AadharID</option>
	            	<option>PanCardID</option>
	            </select><br>
	            <label for="idproofnumber">IDProofNumber</label>
	            <input type="text" id="idproofnumber" name="idProofNumber"><br>
	            <label for="vaccineType">VaccineType</label>
	            <select id="vaccineType" name="vaccineType">
	            	<option>covishield</option>
	            	<option>covaxine</option>
	            </select><br>
	            <label for="dose">Dose</label>
	            <select id="dose" name="dose">
	            	<option>1</option>
	            	<option>2</option>
	            	<option>3</option>
	            </select><br>
	            <div class="sub">
					<input type="submit" value="submit" color="violet">
				</div>
	        </form>
	        <div class="cancel">
				<form action="gotoAddmemberToHome">
					<input type="submit" value="cancel" color="violet">
				</form>
			</div><br>
		</div>
		<center>
			<table width="80%">
			<tr height="60px" style="font-size:15px;background-color:#6499E9;">
				<th>${m1}</th>
				<th>${m2}</th>
				<th>${m3}</th>
				<th>${m4}</th>
				<th>${m5}</th>
				<th>${m6}</th>
				<th>${m7}</th>
				<th>${m8}</th>
				<th>${m9}</th>
				<th>${m10}</th>
			</tr>
			<tbody style="background-color:#9EDDFF;">
				<c:forEach var="member" items="${members}">
			    	<tr height="40px">
			    		<td>${member.memberID}</td>
			    		<td>${member.memberName}</td>
			    		<td>${member.gender}</td>
			    		<td>${member.dob}</td>
			    		<td>${member.idProof}</td>
			    		<td>${member.idProofNumber}</td>
			    		<td>${member.vaccineType}</td>
			    		<td>${member.dose}</td>
			    		<td style="text-align:center;"><a href="editMember/${member.idProofNumber}"><button type="submit">EDIT</button></a></td>
			    		<td style="text-align:center;"><a href="deleteMember/${member.idProofNumber}"><button type="submit">delete</button></a></td>
			    	</tr>
			    </c:forEach>
		    </tbody>
	    </table>
    </center>
    <footer style="margin-top:60px;">
    </footer>
</body>
</html>