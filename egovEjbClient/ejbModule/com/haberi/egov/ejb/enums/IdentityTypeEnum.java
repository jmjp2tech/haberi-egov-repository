package com.haberi.egov.ejb.enums;

public enum IdentityTypeEnum {
	IDENTITY_CARD("identity_card") , PASSPORT("passport"), LAISSER_PASSER("laisser_passer"),DRIVING_LICENSE("driving_license"),BIRTH_CERTIFICATE("birth_certificate");
	
	private String code ; 
	
	IdentityTypeEnum(String idCode) {
		this.setCode(idCode);
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
	
	public static IdentityTypeEnum getEnum(String inputStr){
		IdentityTypeEnum identityTypeEnum = null ; 
		for (IdentityTypeEnum currentEnum : IdentityTypeEnum.values()){
			if(currentEnum.getCode().equalsIgnoreCase(inputStr)){
				identityTypeEnum = currentEnum;
			}
		}
		return identityTypeEnum ; 
	}
	
}
