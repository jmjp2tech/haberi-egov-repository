package com.haberi.egov.ejb.enums;

public enum SexEnum {
	MALE("male"),FEMALE("female");
	
	private String code; 
	 
	SexEnum(String value){
		this.setCode(value); 
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
	
	public SexEnum getEnum(String inputStr){
		SexEnum sexEnum = null ; 
		for (SexEnum currentEnum : SexEnum.values()){
			if(inputStr.equalsIgnoreCase(currentEnum.getCode())){
				sexEnum = currentEnum;
			}
		}
		return sexEnum ; 
	}
	
	
}
