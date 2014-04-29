$(document).ready(function(){
	var accountInfo = sessionStorage.getItem("accountData");
	console.log("account info :"+ accountInfo);
	showJson(JSON.parse(accountInfo), "account_info"); 
});