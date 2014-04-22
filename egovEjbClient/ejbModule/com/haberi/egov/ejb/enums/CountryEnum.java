package com.haberi.egov.ejb.enums;

public enum CountryEnum {

	RWANDA("Rwanda"), BURUNDI("Burundi"), TANZANIA("Tanzania"),UGANDA("Uganda"),KENYA("Kenya"),DRC("DRC");
	
	private String name;
	
	CountryEnum(String nm){
		this.setName(nm); 
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
