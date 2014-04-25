$(document).ready(function(){	
	$("#submit_login_form").on("click", function(){
		var username = $("#username").val();
		var password = $("#password").val();
		
		var jsonData = {"username" : username, "password": password};

		$.ajax({
				type:"POST",
				url: "/egovWeb/Login",
				data : jsonData,
		        dataType:"json",
				success: function(result){
					if(isNotNull(result) && result.status=="Success"){
						window.location.href = "http://localhost:8080/egovWeb/jsp/user_homepage.jsp";
					}else{
						loginErrorMessage
					}
				},
				error: function(){
					alert("An error has occured !!! ");
				}
			}
		); 
	});
});