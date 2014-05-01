package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.haberi.egov.ejb.enums.CreditCardTypeEnum;
import com.haberi.egov.ejb.enums.PaymentTypeEnum;

@Entity
@Table(name="EGOV_PAYMENTS")
public class PaymentEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7376885136022588089L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private BigInteger transactionId ; 
	
	@ManyToOne
	@JoinColumn(referencedColumnName="accountId")
	private AccountEntity accountEntity ; 
	
	@OneToOne
	@JoinColumn(referencedColumnName="caseId")
	private CaseEntity caseEntity ; 

	@Enumerated(EnumType.STRING)
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
	 * @return the caseEntity
	 */
	public CaseEntity getCaseEntity() {
		return caseEntity;
	}
	/**
	 * @param caseEntity the caseEntity to set
	 */
	public void setCaseEntity(CaseEntity caseEntity) {
		this.caseEntity = caseEntity;
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
