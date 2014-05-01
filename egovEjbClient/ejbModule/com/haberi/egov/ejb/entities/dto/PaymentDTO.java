package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;

import com.haberi.egov.ejb.enums.CreditCardTypeEnum;
import com.haberi.egov.ejb.enums.PaymentTypeEnum;

public class PaymentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2628058056599226823L;
	
	private BigInteger transactionId ; 
	private AccountDTO accounDTO ; 
	private CaseDTO caseDTO ; 
	private PaymentTypeEnum paymentType; 
	
	
	//payment by bank transfer
	/**
	 * only the last 4 digits of the account number
	 */
	private String accountNumber ;
	private String bankName ;
	
	//payment by credit card
	/**
	 * only the last 4 digits of the credit card number
	 */
	private String creditCardNumber ; 
	private CreditCardTypeEnum creditCardType ; 
	@Column(name="CC_ISSUING_INSTITUTION")
	private String creditCardIssuingInstitution ; 
	
	//payment by mobile money
	private String mobileNumber ; 
	private String mobileProvider; 
	
	//payment in cash , on the counter.
	private String receiverName ; 
	private String counterId;
	/**
	 * @return the transactionId
	 */
	public BigInteger getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(BigInteger transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the paymentType
	 */
	public PaymentTypeEnum getPaymentType() {
		return paymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(PaymentTypeEnum paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	/**
	 * @return the creditCardType
	 */
	public CreditCardTypeEnum getCreditCardType() {
		return creditCardType;
	}
	/**
	 * @param creditCardType the creditCardType to set
	 */
	public void setCreditCardType(CreditCardTypeEnum creditCardType) {
		this.creditCardType = creditCardType;
	}
	/**
	 * @return the creditCardIssuingInstitution
	 */
	public String getCreditCardIssuingInstitution() {
		return creditCardIssuingInstitution;
	}
	/**
	 * @param creditCardIssuingInstitution the creditCardIssuingInstitution to set
	 */
	public void setCreditCardIssuingInstitution(String creditCardIssuingInstitution) {
		this.creditCardIssuingInstitution = creditCardIssuingInstitution;
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return the mobileProvider
	 */
	public String getMobileProvider() {
		return mobileProvider;
	}
	/**
	 * @param mobileProvider the mobileProvider to set
	 */
	public void setMobileProvider(String mobileProvider) {
		this.mobileProvider = mobileProvider;
	}
	/**
	 * @return the receiverName
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * @return the accounDTO
	 */
	public AccountDTO getAccounDTO() {
		return accounDTO;
	}
	/**
	 * @param accounDTO the accounDTO to set
	 */
	public void setAccounDTO(AccountDTO accounDTO) {
		this.accounDTO = accounDTO;
	}
	/**
	 * @return the caseDTO
	 */
	public CaseDTO getCaseDTO() {
		return caseDTO;
	}
	/**
	 * @param caseDTO the caseDTO to set
	 */
	public void setCaseDTO(CaseDTO caseDTO) {
		this.caseDTO = caseDTO;
	}
	/**
	 * @param receiverName the receiverName to set
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	/**
	 * @return the counterId
	 */
	public String getCounterId() {
		return counterId;
	}
	/**
	 * @param counterId the counterId to set
	 */
	public void setCounterId(String counterId) {
		this.counterId = counterId;
	}
	
	

}
