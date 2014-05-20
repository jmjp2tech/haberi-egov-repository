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
	<script type="text/javascript" src="../js/egov/create_case.js"></script>

<title>Create a case</title>
</head>
<body>
	<form>
	
		<label for="serviceType">Service type</label>
		<select id="serviceType" name="serviceType">
			<option value="DOCUMENT_REQUEST">Document request</option>
			<option value="COMPLAINT">File a complaint</option>
			<option value="PAYMENT">Make a payment</option>
			<option value="REGISTERING">Registering service</option>
		</select><br/>
	
		<label for="caseName">Case name: </label>
		<input type="text" id="caseName" name="caseName"/><br/>
	
		<label for="caseDescription">Case description: </label>
		<textarea rows="3" cols="50" id="caseDescription" name="caseDescription" ></textarea><br/>
	
		<label for="userNotes">Notes: </label>
		<textarea rows="10" cols="50" id="userNotes" name="userNotes"></textarea><br/>
	
		<%-- private Set-CaseSupportDocumentEntity- supportingDocuments; --%>
	
		<button id="create_case_submit">Create Case</button>
	</form>
</body>
</html>