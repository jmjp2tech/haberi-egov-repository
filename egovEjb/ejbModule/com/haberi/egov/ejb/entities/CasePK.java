package com.haberi.egov.ejb.entities;

import java.math.BigInteger;

public class CasePK {
	private BigInteger caseId ;
	private int version ;
	/**
	 * @return the caseId
	 */
	public BigInteger getCaseId() {
		return caseId;
	}
	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(BigInteger caseId) {
		this.caseId = caseId;
	}
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	} 
	
	
}
