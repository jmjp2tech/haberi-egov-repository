package com.haberi.egov.ejb.enums;

import org.apache.commons.lang3.StringUtils;

public enum PaymentTypeEnum {
	CREDIT_CARD("credit_card"),WIRE_TRANSFER("wire_transfer"),MOBILE_MONEY("mobile_money"),COUNTER("counter"); 
	
	private String code ; 
	
	PaymentTypeEnum(String code) {
		this.setCode(code) ; 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public static PaymentTypeEnum getEnum(String paymentTypeStr){
		PaymentTypeEnum paymentTypeEnum = null ; 
		
		for(PaymentTypeEnum currentEnum : PaymentTypeEnum.values()){
			if(StringUtils.equalsIgnoreCase(currentEnum.getCode(), paymentTypeStr)){
				paymentTypeEnum = currentEnum ; 
			}
		}
		return paymentTypeEnum;
	}
	

}
