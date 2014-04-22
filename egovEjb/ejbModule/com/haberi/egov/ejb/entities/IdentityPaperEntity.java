package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EGOV_IDENTITY_PAPERS")
public class IdentityPaperEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5572629905213880405L;
	@EmbeddedId
	private IdentityPaperPK identityPaperPK; 
	@Temporal(TemporalType.DATE)
	private Date expiryDate ;
	
	@OneToOne(mappedBy="identityPaper")
	private AccountEntity accountEntity; 
	
	
	public IdentityPaperEntity() {
		super();
	}
	
	
	
	/**
	 * @return the identityPaperPK
	 */
	public IdentityPaperPK getIdentityPaperPK() {
		return identityPaperPK;
	}



	/**
	 * @param identityPaperPK the identityPaperPK to set
	 */
	public void setIdentityPaperPK(IdentityPaperPK identityPaperPK) {
		this.identityPaperPK = identityPaperPK;
	}



	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	} 
	
	
}
