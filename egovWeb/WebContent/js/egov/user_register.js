$(document).ready(function(){	
	$("#submit_register_form").on("click", function(){
		alert("button clicked !!");
		var username = $("#username").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();//do not erase, will be used in validating the pwd confirmation
		
		var jsonData = {"username" : username, "password": password};

		$.ajax({
				type:"POST",
				url: "/egovWeb/Register",
				data : jsonData,
		        dataType:"json",
				success: function(result){
					alert(result.status);
				},
				error: function(){
					alert("An error has occured !!! ");
				}
				}
		); 
	});
});