$(document).ready(function(){
	
	$("#create_case_submit").on("click", function(){
		
		alert("button clicked !!!!!");
		var serviceType = $("select[id='serviceType'] option:selected").val();
		var caseName = $("#caseName").val(); 
		var caseDescription = $("#caseDescription").val(); 
		var userNotes = $("#userNotes").val(); 
		
		var jsonData = {
		"serviceType": serviceType ,
		"caseName": caseName  , 
		"caseDescription": caseDescription,
		"userNotes":userNotes} ; 
		
		alert(JSON.stringify(jsonData));
		
		$.ajax({
				type:"POST",
				url:"/egovWeb/CreateCaseServlet",
				jsonDataType:"json",
				data:jsonData,
				success:function(){
					alert("returned .... ");
				},
				error: function(){
				alert("error occured ")	;
				}
		}); 
		
		
	});
	
	}
);