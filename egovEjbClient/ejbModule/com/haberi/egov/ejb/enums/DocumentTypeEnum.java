package com.haberi.egov.ejb.enums;

import org.apache.commons.lang3.StringUtils;

public enum DocumentTypeEnum {
	
	IDENTITY_PAPER, ADMINISTRATIVE, EVIDENCE, OTHER; 

	
	public static DocumentTypeEnum getEnum(String documentEnumStr){
	
		DocumentTypeEnum enumValue = null ; 
		for(DocumentTypeEnum currentValue : DocumentTypeEnum.values()){
			if(StringUtils.equalsIgnoreCase(currentValue.name(), documentEnumStr)){
				enumValue = currentValue ; 
				break ; 
			}
		}
		return enumValue; 
	}
}
