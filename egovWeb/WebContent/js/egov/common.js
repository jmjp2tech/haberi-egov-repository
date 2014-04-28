function isNull(data){
	if(data==null || data == undefined){
		return true;
	}
	
	if(typeof data == "string"){
		var trimmedData = data.trim();
		if(trimmedData == ""){
			return true; 
		}else{
			return false; 
		}
	}
	
	return false ; 
}

function isNotNull(data){
	return !isNull(data);
}

function showError(errorMessage){
	console.log("error: " + errorMessage);
	$(".error-div").text(errorMessage);
	$(".error-div").removeClass("hidden");
}

function showSpecificError(errorDivId, errorMessage){
	$("#"+errorDivId).text(errorMessage);
}