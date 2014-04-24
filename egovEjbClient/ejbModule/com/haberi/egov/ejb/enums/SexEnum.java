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
	
	public static SexEnum getEnum(String inputStr){
		SexEnum sexEnum = null ; 
		for (SexEnum currentEnum : SexEnum.values()){
			if(currentEnum.getCode().equalsIgnoreCase(inputStr)){
				sexEnum = currentEnum;
			}
		}
		return sexEnum ; 
	}
	
	
}
