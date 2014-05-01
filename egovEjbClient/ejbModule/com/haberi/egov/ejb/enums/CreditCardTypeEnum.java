package com.haberi.egov.ejb.enums;

import org.apache.commons.lang3.StringUtils;

public enum CreditCardTypeEnum{
	VISA("visa") , MASTER("master") , AMEX("amex"), DISCOVER("discover"), MAESTRO("maestro");
	
	private String code ; 
	
	private CreditCardTypeEnum(String code) {
		this.setCode(code);
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	public static CreditCardTypeEnum getEnum(String ccTypeStr){
		CreditCardTypeEnum enumValue = null ; 
		for(CreditCardTypeEnum currentEnumValue : CreditCardTypeEnum.values()){
			if(StringUtils.endsWithIgnoreCase(ccTypeStr, currentEnumValue.getCode())){
				enumValue = currentEnumValue; 
			}
		}
		
		return enumValue; 
	}
	
	

}
