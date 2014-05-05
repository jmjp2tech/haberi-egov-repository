$(document).ready(function(){
	//show the chosen payment type
	updatePaymentTypeDiv();
	$("input[name='paymentType']").on("change", updatePaymentTypeDiv); 
	
	$("#form_submit").on("click", function(){
		var paymentData = getPaymentData();
		var jsonData={"paymentInfo":JSON.stringify(paymentData)};
		console.log(JSON.stringify(jsonData));
		$.ajax({
			type:"POST",
			url:"/egovWeb/PaymentServlet",
			dataType:"json",
			data:jsonData,
			success:function(result){
				alert(result.status);
			},
			error:function(result){
				alert("An error has occured !!! ");
			}
		});
		return false; 
	}); 	
});

var clearPaymentType = function(){
	$("div#credit_card").addClass("hidden");
	$("div#wire_transfer").addClass("hidden");
	$("div#mobile_money").addClass("hidden");
	$("div#counter").addClass("hidden"); 
};

var  updatePaymentTypeDiv = function(){
	clearPaymentType(); 
	var paymentTypeId = $("input[name='paymentType']:checked").val(); 
	$("div#"+paymentTypeId).removeClass("hidden");
}; 

var getPaymentData =  function() {
	var paymentType = $("input[name='paymentType']:checked").val(); 
	var data = {};
	if(paymentType =="credit_card"){
		data.paymentType ="credit_card";
		data.creditCardType = $("input[name='creditCardType']:checked").val(); 
		data.creditCardHolderName = $("#creditCardHolderName").val();
		data.creditCardNumber = $("#creditCardNumber").val();
		data.creditCardPassword = $("#creditCardPassword").val();
		data.expiryDate = $("#expiryDate").val(); 
		data. verificationCode = $("#verificationCode").val(); 
		data.creditCardIssuingInstitution= $("#creditCardIssuingInstitution").val();
	}else if(paymentType =="wire_transfer"){
		data.paymentType="wire_transfer";
		data.bankAccountHolderName=$("#bankAccountHolderName").val();
		data.bankAccountNumber=$("#bankAccountNumber").val();
		data.bankAccountPassword=$("#bankAccountPassword").val();
		data.bankName=$("#bankName").val();
		data.branchName=$("#branchName").val();
	}else if(paymentType =="mobile_money"){
		data.paymentType = "mobile_money";
		data.mobileAccountHolderName =$("#mobileAccountHolderName").val();
		data.mobileNumber=$("#mobileNumber").val();
		data.mobileAccountPassword=$("#mobileAccountPassword").val();
		data.mobileServiceProvider=$("select[id='mobileServiceProvider'] option:selected").val();
	}else if(paymentType =="counter"){
		data.paymentType ="counter";
		data.transactionNumber = $("#transactionNumber").val();
	}
	
	if(isNotNull(data.paymentType)){
		data.paymentAmount = $("#paymentAmount").val();
	}
//	return {"paymentInfo":data}; 
	return data;
}; 