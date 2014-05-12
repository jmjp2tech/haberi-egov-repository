package com.haberi.egov.ejb.enums;

import org.apache.commons.lang3.StringUtils;

public enum DepartmentEnum {
	CONSTRUCTION , PAPERS, COMPLAINTS,EVENTS, BUSINESS, EDUCATION;
	
	public static DepartmentEnum getEnum(String enumString){
		DepartmentEnum enumValue = null ; 
		
		for(DepartmentEnum currentValue : DepartmentEnum.values()){
			if(StringUtils.equalsIgnoreCase(currentValue.name(), enumString)){
				enumValue = currentValue; 
				break ; 
			}
		}
		return enumValue;
	}
}
