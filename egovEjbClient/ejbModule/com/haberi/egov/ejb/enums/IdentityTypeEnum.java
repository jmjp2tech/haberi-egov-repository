package com.haberi.egov.ejb.enums;

public enum IdentityTypeEnum {
	IDENTITY_CARD("identity_card") , PASSPORT("passport"), LAISSER_PASSER("laisser_passer"),DRIVING_LICENSE("driving_license");
	
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
}
