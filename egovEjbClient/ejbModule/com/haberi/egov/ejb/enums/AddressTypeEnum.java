package com.haberi.egov.ejb.enums;

public enum AddressTypeEnum {
	HOME("home"), WORK("work");
	
	private String code ; 
	
	AddressTypeEnum(String type) {
		this.setCode(type);
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
	
	

}
