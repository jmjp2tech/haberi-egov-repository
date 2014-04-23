<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Register</title>

	<script type="text/javascript" src="../js/core/jquery.2.1.0.js"></script>
	<script type="text/javascript" src="../js/core/jquery.json-2.4.min.js"></script>
	<script type="text/javascript" src="../js/egov/user_register.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  	<script>
  		$(function() {
    		$( "#expiryDate" ).datepicker();
    		$( "#dateOfBirth" ).datepicker();
  		});
  </script>
	
</head>
<body>
	<form id="user_register_form">
	
		<fieldset style="width: 40%">
			<legend>User Login Info</legend>
		
			<label for="userName">Username: </label> 
			<input type="text" id="userName" name="userName"><br> 
		
			<label for="password">Password:</label>
			<input type="text" id="password" name="password"><br> 
		
			<label for="password2">Confirm password: </label>
			<input type="text" id="password2" name="password2"><br> 
		</fieldset>
		<br>
		
		<fieldset>
			<legend>User Account Info</legend>
			
			<label for="firstName">First name: </label> 
			<input type="text" id="firstName" name="firstName"><br> 
			
			<label for="lastName">Last name: </label> 
			<input type="text" id="lastName" name="lastName"><br> 
			
			<label for="middleName">Middle name: </label> 
			<input type="text" id="middleName" name="middleName"><br> 
			
			<p><label for="dateOfBirth">Date of Birth </label> <input type="text" id="dateOfBirth" name="dateOfBirth" class="hasDatepicker"></p>
			
			<label for="sex">Sex: </label> 
				<input type="radio" name="sex" value="male">male
				<input type="radio" name="sex" value="female">female<br>
			
			<label for="citizenship">Citizenship: </label> 			
			<select id="citizenship" name="citizenship">
				<option value="Rwanda">Rwanda</option>
				<option value="Burundi">Burundi</option>
				<option value="Tanzania">Tanzania</option>
				<option value="Uganda">Uganda</option>
				<option value="Kenya">Kenya</option>
				<option value="DR Congo">DR Congo</option>
				<option value="Congo">Congo</option>
			</select><br> 
			
			
			<label for="identityNumber">Id Number: </label> 
			<input type="text" id="identityNumber" name="identityNumber"><br> 
			
			<label for="identityType">Id Type: </label> 
				<input type="radio" name="identityType" value="identity card">identity card
				<input type="radio" name="identityType" value="passport">passport
				<input type="radio" name="identityType" value="laisser passer">laisser passer
				<input type="radio" name="identityType" value="driving license">driving license<br> 
			
			<label for="issuingCountry">Country of Issuance: </label> 
			<select id="issuingCountry" name="issuingCountry">
				<option value="Rwanda">Rwanda</option>
				<option value="Burundi">Burundi</option>
				<option value="Tanzania">Tanzania</option>
				<option value="Uganda">Uganda</option>
				<option value="Kenya">Kenya</option>
				<option value="DR Congo">DR Congo</option>
				<option value="Congo">Congo</option>
			</select> <br>
			
			<p><label for="expiryDate">Expiry Date </label> <input type="text" id="expiryDate" name="expiryDate" class="hasDatepicker"></p>	
			
			<span><strong>Home Address: </strong></span><br> 
			<label for="homeStreetNumber">Street Number: </label> <input type="text" id="homeStreetNumber" name="homeStreetNumber"><br>
			<label for="homeStreetName">Street Name: </label> <input type="text" id="homeStreetName" name="homeStreetName"><br>
			<label for="homeAppartmentNumber">Appartment Number: </label> <input type="text" id="homeAppartmentNumber" name="homeAppartmentNumber"><br>
			<label for="homeZipCode">Zip Code: </label> <input type="text" id="homeZipCode" name="homeZipCode"><br>
			<label for="homeCell">Cell: </label> <input type="text" id="homeCell" name="homeCell"><br>
			<label for="homeDistrict">District: </label> <input type="text" id="homeDistrict" name="homeDistrict"><br>
			<label for="homeProvince">Province: </label> <input type="text" id="homeProvince" name="homeProvince"><br> 
			
			<br> 
			<span><strong>Work Address:</strong></span><br> 
			<label for="workStreetNumber">Street Number: </label> <input type="text" id="workStreetNumber" name="workStreetNumber"><br> 
			<label for="workStreetName">Street Name: </label> <input type="text" id="workStreetName" name="workStreetName"><br> 
			<label for="workAppartmentNumber">Appartment Number: </label> <input type="text" id="workAppartmentNumber" name="workAppartmentNumber"><br> 
			<label for="workZipCode">Zip Code: </label> <input type="text" id="workZipCode" name="workZipCode"><br> 
			<label for="workCell">Cell: </label> <input type="text" id="workCell" name="workCell"><br> 
			<label for="workDistrict">District: </label> <input type="text" id="workDistrict" name="workDistrict"><br> 
			<label for="workProvince">Province: </label> <input type="text" id="workProvince" name="workProvince"><br> 
			
			<label for="email">Email: </label> <input type="text" id="email" name="email"><br> 
			<label for="mobilePhone">Mobile Number: </label> <input type="text" id="mobilePhone" name="mobilePhone"><br> 
			<label for="homePhone">Home Phone: </label> <input type="text" id="homePhone" name="homePhone"><br> 
			<label for="workPhone">Work Number: </label> <input type="text" id="workPhone" name="workPhone"><br> 
			
			<label for="contactMethod">Preferred contact method: </label> 
				<input type="radio" name="contactMethod" value="email">Email
				<input type="radio" name="contactMethod" value="work">Work Address
				<input type="radio" name="contactMethod" value="home">Home Address
				<input type="radio" name="contactMethod" value="sms">Mobile SMS<br> 
						
		</fieldset>
		
		
		<br> 
		<input type="button" id="submit_register_form" value="Create Account">

	</form>

</html>