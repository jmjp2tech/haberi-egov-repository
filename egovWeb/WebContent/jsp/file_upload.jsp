<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>File Uploading Form</title>
</head>
<body>
	<h3>File Upload:</h3>
	
	<img src="../img/Rwanda_240-animated-flag-gifs.gif"/><br/>
	
	Select a file to upload:
	<br />
	<form action="/egovWeb/FileUploadServlet" method="post" enctype="multipart/form-data">
		<input type="file" name="file" size="50" /> <br /> 
		<input type="submit" value="Upload File" />
	</form>
</body>
</html>