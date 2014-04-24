$(document).ready(function(){	
	$("#submit_register_form").on("click", function(){
		alert("button clicked !!");
		var username = $("#userName").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();//do not erase, will be used in validating the pwd confirmation
		
		var firstName = $("#firstName").val();
		var lastName = $("#lastName").val();
		var middleName = $("#middleName").val();
		var dateOfBirth = $("#dateOfBirth").val();
		var sex = $("input[name='sex']:checked").val();
		var citizenship =  $("select[id='citizenship'] option:selected").val();
		var identityNumber =  $("#identityNumber").val();
		var identityType =  $("input[name='identityType']:checked").val();
		var issuingCountry = $("select[id='issuingCountry'] option:selected").val();
		var expiryDate = $("#expiryDate").val();
		
		var homeStreetNumber = $("#homeStreetNumber").val();
		var homeStreetName = $("#homeStreetName").val();
		var homeAppartmentNumber = $("#homeAppartmentNumber").val();
		var homeCell = $("#homeCell").val();
		var homeDistrict = $("#homeDistrict").val();
		var homeProvince = $("#homeProvince").val();
				
		var workStreetNumber = $("#workStreetNumber").val();
		var workStreetName = $("#workStreetName").val();
		var workAppartmentNumber = $("#workAppartmentNumber").val();
		var workCell = $("#workCell").val();
		var workDistrict = $("#workDistrict").val();
		var workProvince = $("#workProvince").val();
			
		var email = $("#email").val();
		var mobilePhone = $("#mobilePhone").val();
		var homePhone = $("#homePhone").val();
		var workPhone = $("#workPhone").val();
		
		var contactMethod = $("input[name='contactMethod']:checked").val();
		
		var accountData={
				"firstName":firstName,
				"lastName":lastName,
				"middleName":middleName,
				"dateOfBirth":dateOfBirth,
				"citizenship":citizenship,
				"sex":sex,
				"identityPaper":{
					"identityNumber":identityNumber,
					"identityType":identityType,
					"issuingCountry":issuingCountry,
					"expiryDate":expiryDate
				},
				"homeAddress":{
					"homeStreetNumber":homeStreetNumber,
					"homeStreetName":homeStreetName,
					"homeAppartmentNumber":homeAppartmentNumber,
					"homeCell":homeCell,
					"homeDistrict":homeDistrict,
					"homeProvince":homeProvince
				},
				"workAddress":{
					"workStreetNumber":workStreetNumber,
					"workStreetName":workStreetName,
					"workAppartmentNumber":workAppartmentNumber,
					"workCell":workCell,
					"workDistrict":workDistrict,
					"workProvince":workProvince
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
	});
});

