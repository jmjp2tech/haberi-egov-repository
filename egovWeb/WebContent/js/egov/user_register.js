$(document).ready(function(){	
	
	$(".error-div").addClass("hidden");
	
	$("#submit_register_form").on("click", function(){
		var username = $("#userName").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();
		var firstName = $("#firstName").val();
		var lastName = $("#lastName").val();
		var middleName = $("#middleName").val();
		var dateOfBirth = $("#dateOfBirth").val();
		var placeOfBirth = $("#placeOfBirth").val(); 
		var father = $("#father").val();
		var mother =$("#mother").val();		
		var sex = $("input[name='sex']:checked").val();
		var citizenship =  $("select[id='citizenship'] option:selected").val();
		var identityNumber =  $("#identityNumber").val();
		var identityType =  $("input[name='identityType']:checked").val();
		var issuingCountry = $("select[id='issuingCountry'] option:selected").val();
		var expiryDate = $("#expiryDate").val();
		var occupation=$("select[id='occupation'] option:selected").val();
		var homeStreetNumber = $("#homeStreetNumber").val();
		var homeStreetName = $("#homeStreetName").val();
		var homeAppartmentNumber = $("#homeAppartmentNumber").val();
		var homeZipCode = $("#homeZipCode").val();		
		var homeCell = $("#homeCell").val();
		var homeDistrict = $("#homeDistrict").val();
		var homeProvince = $("#homeProvince").val();		
		var workStreetNumber = $("#workStreetNumber").val();
		var workStreetName = $("#workStreetName").val();
		var workAppartmentNumber = $("#workAppartmentNumber").val();
		var workZipCode = $("#workZipCode").val();
		var workCell = $("#workCell").val();
		var workDistrict = $("#workDistrict").val();
		var workProvince = $("#workProvince").val();
		var email = $("#email").val();
		var mobilePhone = $("#mobilePhone").val();
		var homePhone = $("#homePhone").val();
		var workPhone = $("#workPhone").val();
		var contactMethod = $("input[name='contactMethod']:checked").val();
		if(password == password2){
			var accountData={
					"firstName":firstName,
					"lastName":lastName,
					"middleName":middleName,
					"dateOfBirth":dateOfBirth,
					"placeOfBirth":placeOfBirth,
					"father":father,
					"mother":mother,
					"citizenship":citizenship,
					"sex":sex,
					"identityPaper":{
						"identityNumber":identityNumber,
						"identityType":identityType,
						"issuingCountry":issuingCountry,
						"expiryDate":expiryDate
					},
					"occupation":occupation,
					"homeAddress":{
						"streetNumber":homeStreetNumber,
						"streetName":homeStreetName,
						"appartmentNumber":homeAppartmentNumber,
						"zipCode":homeZipCode,
						"cell":homeCell,
						"district":homeDistrict,
						"province":homeProvince
					},
					"workAddress":{
						"streetNumber":workStreetNumber,
						"streetName":workStreetName,
						"appartmentNumber":workAppartmentNumber,
						"zipCode":workZipCode,
						"cell":workCell,
						"district":workDistrict,
						"province":workProvince
					},
					"email":email,
					"mobilePhone":mobilePhone,
					"homePhone":homePhone,
					"workPhone":workPhone,
					"contactMethod":contactMethod		
			};
					
			var jsonData = {
					"username" : username, 
					"password": password,
					"accountData":JSON.stringify(accountData)};

			alert("JSON Data: " + JSON.stringify(jsonData));
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
		}else{
			showError("Password must be the same  as password confirmation");
		}
	});
});

