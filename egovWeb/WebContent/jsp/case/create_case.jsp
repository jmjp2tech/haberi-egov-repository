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
	<script type="text/javascript" src="../js/egov/payment.js"></script>
	
  	<script>
  		$(function() {
    		$( "#expiryDate" ).datepicker();
  		});
  </script>

<title>Create a case</title>
</head>
<body>

	private ServiceTypeEnum serviceType ; 
	private Set-CaseSupportDocumentEntity- supportingDocuments;
	
	//saved as an XML string
	@Lob
	private String userNotes;
	
	//readable short name to display on the front-end 
	private String name; 
	
	////readable short name to display on the front-end 
	private String description; 
</body>
</html>