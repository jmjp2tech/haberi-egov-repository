var egov = {

};

function isNull(data) {
	if (data == null || data == undefined) {
		return true;
	}

	if (typeof data == "string") {
		var trimmedData = data.trim();
		if (trimmedData == "") {
			return true;
		} else {
			return false;
		}
	}

	return false;
}

function isNotNull(data) {
	return !isNull(data);
}

function showError(errorMessage) {
	console.log("error: " + errorMessage);
	$(".error-div").text(errorMessage);
	$(".error-div").removeClass("hidden");
}

function showSpecificError(errorDivId, errorMessage) {
	$("#" + errorDivId).text(errorMessage);
}

function showJson(jsonData, parentElementId) {
	if (isNotNull(jsonData)) {
		var itemNames = new Array();
		for ( var key in jsonData) {
			itemNames.push(key);
		}
		$.each(itemNames, function(idx, itemName) {
			var itemValue = jsonData[itemName];
			console.log(itemValue);
			var itemTag = egov.i18n(itemName);
			if (isNotNull(itemValue)) {
				if (typeof itemValue != "object") {
					$("#" + parentElementId).append("<div/>");
					$("#" + parentElementId + " div").filter(":last").append("<span>" + itemTag + "</span>");
					$("#" + parentElementId + " div").filter(":last").append("<span>" + itemValue + "</span>");
				} else {
					$("#" + parentElementId).append("<br/>");
					var title = $("<span/>");
					$(title).addClass("strong");
					$(title).text(itemTag), $("#" + parentElementId).append("<div/>").append(title);
					showJson(itemValue, parentElementId);
					$("#" + parentElementId).append("<br/>");
				}
			}
		});
	}

}