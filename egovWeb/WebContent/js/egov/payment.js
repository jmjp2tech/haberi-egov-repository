$(document).ready(function(){
	//show the chosen payment type
	updatePaymentTypeDiv();
	$("input[name='paymentType']").on("change", updatePaymentTypeDiv); 
	
	$("#form_submi").on("click", function(){
		
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
	console.log("paymentType: "+ paymentTypeId);
	$("div#"+paymentTypeId).removeClass("hidden");
}; 

var submitPayment =  function() {
	var paymentType = $("input[name='paymentType']:checked").val(); 
//	var  
//	if()
}; 