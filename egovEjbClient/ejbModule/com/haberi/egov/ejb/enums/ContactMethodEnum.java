package com.haberi.egov.ejb.enums;


public enum ContactMethodEnum {
	EMAIL("email"), WORK("work"), HOME("home"), SMS("sms");
	
	private String code ;

	ContactMethodEnum(String code) {
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
	
	public ContactMethodEnum getEnum(String inputStr){
		ContactMethodEnum contactMethodEnum = null ; 
		for (ContactMethodEnum currentEnum : ContactMethodEnum.values()){
			if(inputStr.equalsIgnoreCase(currentEnum.getCode())){
				contactMethodEnum = currentEnum;
			}
		}
		
		return contactMethodEnum ; 
	}

}
