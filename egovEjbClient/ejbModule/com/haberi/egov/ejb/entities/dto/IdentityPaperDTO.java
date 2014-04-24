package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;
import java.util.Date;

import com.haberi.egov.ejb.enums.CountryEnum;
import com.haberi.egov.ejb.enums.IdentityTypeEnum;

public class IdentityPaperDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9149250156877294626L;
	
	private String identityNumber ; 
	private IdentityTypeEnum identityType ;  
	private CountryEnum issuingCountry ;
	private Date expiryDate ;
	
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public IdentityTypeEnum getIdentityType() {
		return identityType;
	}
	public void setIdentityType(IdentityTypeEnum identityType) {
		this.identityType = identityType;
	}
	public CountryEnum getIssuingCountry() {
		return issuingCountry;
	}
	public void setIssuingCountry(CountryEnum issuingCountry) {
		this.issuingCountry = issuingCountry;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	} 
	
	
	
	
}
