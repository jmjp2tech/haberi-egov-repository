package com.haberi.egov.ejb.enums;

public enum OccupationEnum {
	PUBLIC_SECTOR("public_sector") , 
	PRIVATE_SECTOR("private_sector"), 
	MILITARY("military"),
	ENTREPRENEUR("entrepreneur"), 
	DIPLOMAT("diplomat"),
	OTHER("other");
	
	
	private String code ; 
	
	OccupationEnum(String code) {
		this.code = code ; 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public static OccupationEnum getEnum(String inputStr){
		OccupationEnum occupationEnum = null ; 
		for (OccupationEnum currentEnum : OccupationEnum.values()){
			if(currentEnum.getCode().equalsIgnoreCase(inputStr)){
				occupationEnum = currentEnum;
			}
		}
		return occupationEnum ; 
	}
	

}
