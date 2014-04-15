package com.haberi.egov.ejb.enums;

public enum UserStatusEnum {
	ONLINE("online") , OFFLINE("offline");
	
	private String value ; 
	
	UserStatusEnum(String code){
		this.setValue(code); 
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
