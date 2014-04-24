package com.haberi.egov.ejb.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class IdentityPaperPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8737472107757097178L;
	
	private String identityNumber ; 
	private String identityType ;  
	private String issuingCountry ;
	
	public IdentityPaperPK() {
		super();
	}

	
	/**
	 * @return the identityType
	 */
	public String getIdentityType() {
		return identityType;
	}

	/**
	 * @param identityType the identityType to set
	 */
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	/**
	 * @return the issuingCountry
	 */
	public String getIssuingCountry() {
		return issuingCountry;
	}

	/**
	 * @param issuingCountry the issuingCountry to set
	 */
	public void setIssuingCountry(String issuingCountry) {
		this.issuingCountry = issuingCountry;
	} 
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		try{
			IdentityPaperPK identityPaperPK = (IdentityPaperPK)obj ;
			final String oidentityNumber = identityPaperPK.getIdentityNumber();
			final String oidentityType = identityPaperPK.getIdentityType();
			final String oissuingCountry = identityPaperPK.getIssuingCountry();
			
			if(this.getIdentityNumber().equals(oidentityNumber) && this.getIdentityType().equals(oidentityType)&& this.getIssuingCountry().equals(oissuingCountry)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false ; 
		}
	}


	public String getIdentityNumber() {
		return identityNumber;
	}


	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	

}
