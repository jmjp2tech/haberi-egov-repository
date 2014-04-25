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