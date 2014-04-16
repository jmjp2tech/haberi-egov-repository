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
	
	public static UserStatusEnum getEnumByValue(String stringVal){
		UserStatusEnum enumVal = null  ; 
		
		for ( UserStatusEnum currentVal : UserStatusEnum.values()){
			if(currentVal.getValue().equals(stringVal)){
				enumVal = currentVal ; 
			}
		}
		return enumVal; 
	}

}
