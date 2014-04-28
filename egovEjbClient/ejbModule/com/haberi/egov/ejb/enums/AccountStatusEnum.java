package com.haberi.egov.ejb.enums;


public enum AccountStatusEnum{
	ACTIVE("active"), 
	BLOCKED("blocked"); 
	
	private String code ; 
	
	AccountStatusEnum(String code) {
		this.code = code ; 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public static AccountStatusEnum getEnum(String addressTypeString){
		AccountStatusEnum accountStatusEnum = null ; 
		for(AccountStatusEnum currentAccountStatusEnum : AccountStatusEnum.values()){
			if(currentAccountStatusEnum.getCode().equalsIgnoreCase(addressTypeString)){
				accountStatusEnum = currentAccountStatusEnum ; 
			}
		}
		return accountStatusEnum ; 
	}
	
	
	

}
