package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9076305383848965514L;
	
	private String streetNumber;
	private String streetName;
	private String appartmentNumber;
	private String zipCode;
	private String cell;
	private String district;
	private String province;
	
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getAppartmentNumber() {
		return appartmentNumber;
	}
	public void setAppartmentNumber(String appartmentNumber) {
		this.appartmentNumber = appartmentNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	
}
