package com.haberi.egov.ejb.enums;

public enum UserTypeEnum {
CITIZEN("citizen"), VISITOR("visitor") , RESIDENT("resident") , BUSINESS("business"), INSITUTION("insitution");

private String code ; 

UserTypeEnum(String value) {
	this.code=value;
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

public UserTypeEnum getEnum(String inputStr){
	UserTypeEnum userTypeEnum = null ; 
	for (UserTypeEnum currentEnum : UserTypeEnum.values()){
		if(inputStr.equalsIgnoreCase(currentEnum.getCode())){
			userTypeEnum = currentEnum;
		}
	}
	
	return userTypeEnum ; 
}


}
