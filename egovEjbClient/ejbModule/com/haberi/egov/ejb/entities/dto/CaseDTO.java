package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class CaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8246261289601076461L;
	
	private BigInteger caseId ;
	private PaymentDTO paymentDTO ; 
	private AccountDTO accountDTO ;
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
	 * @return the paymentDTO
	 */
	public PaymentDTO getPaymentDTO() {
		return paymentDTO;
	}
	/**
	 * @param paymentDTO the paymentDTO to set
	 */
	public void setPaymentDTO(PaymentDTO paymentDTO) {
		this.paymentDTO = paymentDTO;
	}
	/**
	 * @return the accountDTO
	 */
	public AccountDTO getAccountDTO() {
		return accountDTO;
	}
	/**
	 * @param accountDTO the accountDTO to set
	 */
	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	} 

	
}
