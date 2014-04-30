package com.haberi.egov.ejb.enums;

import org.apache.commons.lang3.StringUtils;

public enum PaymentTypeEnum {
	CREDIT_CARD("credit card"),MOBILE_MONEY("mobile_money"),TIGO_CASH("tigo_cash"),BANK_TRANSFER("bank_transfer"),COUNTER("counter"); 
	
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
