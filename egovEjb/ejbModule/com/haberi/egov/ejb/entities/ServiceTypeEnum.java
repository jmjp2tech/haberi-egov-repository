package com.haberi.egov.ejb.entities;

import org.apache.commons.lang3.StringUtils;

public enum ServiceTypeEnum {

		DOCUMENT_REQUEST,COMPLAINT, PAYMENT, REGISTERING ; 
		
		public static ServiceTypeEnum getEnum(String serviceTypeEnumStr){
			
			ServiceTypeEnum enumValue = null ; 
			for(ServiceTypeEnum currentValue : ServiceTypeEnum.values()){
				if(StringUtils.equalsIgnoreCase(currentValue.name(), serviceTypeEnumStr)){
					enumValue = currentValue ; 
					break ; 
				}
			}
			return enumValue; 
		}
}
