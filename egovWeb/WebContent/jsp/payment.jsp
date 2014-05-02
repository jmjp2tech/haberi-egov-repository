<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
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
  		});
  </script>
	
<title>Case payment</title>
</head>
<body>
<form>	
	<label for="creditCardType">Choose Payment Type: </label>
		<input type="radio" name="paymentType" value="credit card" id="credit_card"/><label for="credit_card">Credit Card</label>
		<input type="radio" name="paymentType" value="wire_transfer" id="wire_transfer"/><label for="wire_transfer">Wire transfer</label>
		<input type="radio" name="paymentType" value="mobile_money" id="mobile_money"/><label for="mobile_money">Mobile Money</label>
		<input type="radio" name="paymentType" value="counter" id="counter"/><label for="counter">Counter</label>
	
	
	<div id="creditCard">
		<fieldset>
		<legend>Credit card information</legend>
			
		<label for="creditCardType">Credit Card Type: </label>
		<input type="radio" name="creditCardType" value="visa" id="visa"/><label for="visa">VISA</label>
		<input type="radio" name="creditCardType" value="master" id="master"/><label for="master">MASTER</label>
		<input type="radio" name="creditCardType" value="amex" id="amex"/><label for="amex">AMERICAN EXPRESS</label>
		<input type="radio" name="creditCardType" value="discover" id="discover"/><label for="discover">DISCOVER</label>
		<input type="radio" name="creditCardType" value="maestro" id="maestro"/><label for="maestro">MAESTRO</label>
		
		<label for="creditCardNumber">Credit Card Number: </label>
		<input type="text" name="creditCardNumber" id="creditCardNumber"/><br/>
		
		<label for="creditCardPassword">Password: </label>
		<input type="text" name="creditCardPassword" id="creditCardPassword"/><br/>
		
		<label for="expiryDate">Expiry Date: </label>
		<input type="text" name="expiryDate" id="expiryDate"/><br/>
		
		<label for="expiryDate">Verification code: </label>
		<input type="text" name="verificationCode" id="verificationCode"/><br/>
		
		<br>
		<label for="creditCardIssuingInstitution"> Issuing institution: </label>
		<input type="text" name="creditCardIssuingInstitution" id="creditCardIssuingInstitution"/><br/>
		</fieldset>
	</div>


	<div id="wireTransfer" class="hidden">
		<fieldset>
		<legend>Wire Transfer</legend>
		<label for="bankAccountHolderName">Account Holder Name: </label>
		<input type="text" name="bankAccountHolderName" id="bankAccountHolderName"/><br/>
		
		<label for="bankAccountHolderAddress">Account Holder's Address: </label>
		<input type="text" name="bankAccountHolderAddress" id="bankAccountHolderAddress"/><br/>
		
		<label for="accountNumber">Account Number: </label>
		<input type="text" name="accountNumber" id="accountNumber"/><br/>
		
		<label for="bankAccountPassword">Password: </label>
		<input type="text" name="bankAccountPassword" id="bankAccountPassword"/><br/>
		
		<label for="bankName">Bank Name: </label>
		<input type="text" name="bankName" id="bankName"/><br/>
		
		<label for="branchName">Bank Name: </label>
		<input type="text" name="branchName" id="branchName"/><br/>
		
		</fieldset>
	</div>
	
	
	<div id="mobileMoney" class="hidden">
		<fieldset>
		<legend>Mobile Money</legend>
					
		<label for="mobileAccountHolderName">Account Holder Name: </label>
		<input type="text" name="mobileAccountHolderName" id="mobileAccountHolderName"/><br/>
		
		<label for="mobileAccountHolderAddress">Account Holder's Address: </label>
		<input type="text" name="mobileAccountHolderAddress" id="bankAccountHolderAddress"/><br/>
		
		<label for="mobileNumber">Mobile Number: </label>
		<input type="text" name="mobileNumber" id="mobileNumber"/><br/>
		
		<label for="mobileAccountPassword">Password: </label>
		<input type="text" name="mobileAccountPassword" id="mobileAccountPassword"/><br/>
		
		<label for="serviceProvider">Mobile Service Provider: </label>
		<select name="serviceProvider" id="serviceProvider">
			<option value="mtn">MTN</option>
			<option value="tigo">TIGO</option>
			<option value="airtel">AIRTEL</option>
			<option value="rwandatel">RWANDATEL</option>
		</select>
		<br/>
		</fieldset>
	</div>
	
	<br><label for="paymentAmount">Password: </label>
	<input type="text" name="paymentAmount" id="paymentAmount"/><br/>
	
	<button id="form_submit" value="Make Payment">Make Payment</button>
	
</form>
</body>
</html>