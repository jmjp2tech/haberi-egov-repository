<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Register</title>

	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" href="../css/egov/common.css">

	<script type="text/javascript" src="../js/core/jquery.2.1.0.js"></script>
	<script type="text/javascript" src="../js/core/jquery-ui-1.10.4.js"></script>
	<script type="text/javascript" src="../js/core/jquery.json-2.4.min.js"></script>
	<script type="text/javascript" src="../js/egov/common.js"></script>
	<script type="text/javascript" src="../js/egov/user_register.js"></script>
	
  	<script>
  		$(function() {
    		$( "#expiryDate" ).datepicker();
    		$( "#dateOfBirth" ).datepicker();
  		});
  </script>
	
</head>
<body>
	<form id="user_register_form">
	    
	    <div id="register_error" class="error-div hidden"></div>
		
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
			
			<p><label for="dateOfBirth">Date of Birth </label> 
			<input type="text" id="dateOfBirth" name="dateOfBirth"></p>
			
			
			<p><label for="placeOfBirth">Place of Birth </label> 
			<input type="text" id="placeOfBirth" name="placeOfBirth"></p>
			
			<label for="father">Father: </label> 
			<input type="text" id="father" name="father"><br> 
			
			<label for="mother">Mother: </label> 
			<input type="text" id="mother" name="mother"><br> 
			
			
			<label for="sex">Sex: </label> 
				<input type="radio" name="sex" value="male" id="male"><label for="male">male</label>
				<input type="radio" name="sex" value="female" id="female"><label for="female">female</label><br>
			
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
				<input type="radio" name="identityType" value="identity_card" id="identity card"><label for="identity card">Identity card</label>
				<input type="radio" name="identityType" value="passport" id="passport"><label for="passport">Passport</label>
				<input type="radio" name="identityType" value="laisser_passer" id="laisser_passer"><label for="laisser_passer">Paisser Passer</label>
				<input type="radio" name="identityType" value="driving_license" id="driving_license"><label for="driving_license">Driving License</label> 
				<input type="radio" name="identityType" value="birth_certificate" id="birth_certificate"><label for="birth_certificate">Birth Certificate</label><br>
			
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
			
			<p><label for="expiryDate">Expiry Date </label> <input type="text" id="expiryDate" name="expiryDate"></p>	
			
			
			<label for="occupation">Occupation: </label> 
			<select id="occupation" name="occupation">
				<option value=public_sector>public sector</option>
				<option value="private_sector">private sector</option>
				<option value="military">military</option>
				<option value="entrepreneur">entrepreneur</option>
				<option value="diplomat">diplomat</option>
				<option value="other">other</option>
			</select> <br>
			
			
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
				<input type="radio" name="contactMethod" value="email" id="email"><label for="email">Email</label>
				<input type="radio" name="contactMethod" value="work" id="work"><label for="work">Work Address</label>
				<input type="radio" name="contactMethod" value="home" id="home"><label for="home">Home Address</label>
				<input type="radio" name="contactMethod" value="sms" id="sms"><label for="sms">Mobile SMS</label><br> 
						
		</fieldset>
		
		
		<br> 
		<input type="button" id="submit_register_form" value="Create Account">

	</form>

</html>