package com.haberi.egov.ejb.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.annotations.HashPartitioning;

@Embeddable
public class CasePK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3976031151272394337L;
	private String caseId ;
	private int version ;
	
	public CasePK() {
		super();
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

	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}

	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean isEqual = false ; 
		if(obj instanceof CasePK){
			CasePK pk = (CasePK) obj; 
			if(StringUtils.endsWithIgnoreCase(pk.getCaseId(), this.getCaseId()) && this.getVersion() == pk.getVersion()){
				isEqual = true;
			}
		}
		return isEqual;
	} 
	
	
	
}
