$(document).ready(function(){	
	
	clearErrors();
	
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
					if(isNotNull(result)){
						if(result.status=="Success"){
							alert(JSON.stringify(result.accountData));
							window.location.href = "http://localhost:8080/egovWeb/jsp/user_homepage.jsp";
						}else{
							var loginErrorMessage = result.loginError;
							$("#login_error").text(loginErrorMessage);
							$("#login_error").removeClass("hidden");							
						}
					}else{
						alert("An unknown error has occured !!! ");
					}
				},
				error: function(){
					alert("An error has occured on the server !!! ");
				}
			}
		); 
	});
});

function clearErrors(){
	$("#login_error").text("");
	$("#login_error").addClass("hidden");
}