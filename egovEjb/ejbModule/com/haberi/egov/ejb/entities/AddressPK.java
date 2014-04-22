package com.haberi.egov.ejb.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AddressPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6684332014938718543L;
	private String streetNumber;
	private String streetName;
	private String appartmentNumber;
	private String zipCode;
	private String cell;
	private String district;
	private String province;

	public AddressPK() {
		super();
	}

	/**
	 * @return the streetNumber
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @param streetNumber
	 *            the streetNumber to set
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @return the streetName
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName
	 *            the streetName to set
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the appartmentNumber
	 */
	public String getAppartmentNumber() {
		return appartmentNumber;
	}

	/**
	 * @param appartmentNumber
	 *            the appartmentNumber to set
	 */
	public void setAppartmentNumber(String appartmentNumber) {
		this.appartmentNumber = appartmentNumber;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the cell
	 */
	public String getCell() {
		return cell;
	}

	/**
	 * @param cell
	 *            the cell to set
	 */
	public void setCell(String cell) {
		this.cell = cell;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	

	/**
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		try {

			AddressPK oAddressPk = (AddressPK) obj;

			final String oStreetNumber = oAddressPk.getStreetNumber();
			final String oStreetName = oAddressPk.getStreetName();
			final String oAppartmentNumber = oAddressPk.getAppartmentNumber();
			final String oZipCode = oAddressPk.getZipCode();
			final String oCell = oAddressPk.getCell();
			final String oDistrict = oAddressPk.getDistrict();
			final String oProvince = oAddressPk.getProvince();

			if (this.getStreetNumber().equals(oStreetNumber)
					&& this.getStreetName().equals(oStreetName)
					&& this.getAppartmentNumber().equals(oAppartmentNumber)
					&& this.getZipCode().equals(oZipCode)
					&& this.getCell().equals(oCell)
					&& this.getDistrict().equals(oDistrict)
					&& this.getProvince().equals(oProvince)) {
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
}
