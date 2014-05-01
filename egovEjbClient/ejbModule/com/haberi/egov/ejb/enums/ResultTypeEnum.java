package com.haberi.egov.ejb.enums;

public enum ResultTypeEnum {
	SUCCESS("success"), FAILURE("failure");

	private String code ; 
	
	ResultTypeEnum(String code) {
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
	
}
