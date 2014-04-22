package com.haberi.egov.ejb.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class IdentityPaperPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8737472107757097178L;
	
	private String identityId ; 
	private String identityType ;  
	private String issuingCountry ;
	
	public IdentityPaperPK() {
		super();
	}

	/**
	 * @return the identityId
	 */
	public String getIdentityId() {
		return identityId;
	}

	/**
	 * @param identityId the identityId to set
	 */
	public void setIdentityId(String identityId) {
		this.identityId = identityId;
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
			final String identityId = identityPaperPK.getIdentityId();
			final String identityType = identityPaperPK.getIdentityType();
			final String issuingCountry = identityPaperPK.getIssuingCountry();
			
			if(this.getIdentityId().equals(identityId) && this.getIdentityType().equals(identityType)&& this.getIssuingCountry().equals(issuingCountry)){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false ; 
		}
	}
	

}
