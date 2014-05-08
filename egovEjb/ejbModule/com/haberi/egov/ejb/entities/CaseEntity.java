package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EGOV_CASES")
public class CaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8045809367548003058L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private BigInteger caseId ;
	
	@OneToOne
	
	private PaymentEntity paymentEntity ; 
	private AccountEntity accountEntity ;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate; 
	
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
	 * @return the paymentEntity
	 */
	public PaymentEntity getPaymentEntity() {
		return paymentEntity;
	}
	/**
	 * @param paymentEntity the paymentEntity to set
	 */
	public void setPaymentEntity(PaymentEntity paymentEntity) {
		this.paymentEntity = paymentEntity;
	}
	/**
	 * @return the accountEntity
	 */
	public AccountEntity getAccountEntity() {
		return accountEntity;
	}
	/**
	 * @param accountEntity the accountEntity to set
	 */
	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}
	
	
	
}
