package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	@JoinColumn(referencedColumnName="accountId", nullable=true)
	private AccountEntity accountEntity ; 
	
	@OneToOne
	@JoinColumn(referencedColumnName="caseId", nullable=true)
	private CaseEntity caseEntity ; 

	@Enumerated(EnumType.STRING)
	private PaymentTypeEnum paymentType; 
	@Temporal(TemporalType.DATE)
	private Date paymentDate ; 
	
	//payment by wire transfer
	private String bankAccountHolderName; 
	/**
	 * only the last 4 digits of the account number
	 */
	private String bankAccountNumber ;
	private String bankName ;
	private String branchName;
	@Transient
	private String bankAccountPassword; 
	
	//payment by credit card
	private String creditCardHolderName;
	/**
	 * only the last 4 digits of the credit card number
	 */
	private String creditCardNumber ; 
	@Enumerated(EnumType.STRING)
	private CreditCardTypeEnum creditCardType ; 
	@Column(name="CC_ISSUING_INSTITUTION")
	private String creditCardIssuingInstitution ; 
	@Transient
	private String creditCardPassword;
	@Transient
	private Date expiryDate ; 
	@Transient
	private String  verificationCode; 
	
	//payment by mobile money
	private String mobileAccountHolderName;
	private String mobileNumber ; 
	private String mobileProvider;
	private String mobileServiceProvider;
	@Transient
	private String mobileAccountPassword; 
	
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
	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * @return the bankAccountHolderName
	 */
	public String getBankAccountHolderName() {
		return bankAccountHolderName;
	}
	/**
	 * @param bankAccountHolderName the bankAccountHolderName to set
	 */
	public void setBankAccountHolderName(String bankAccountHolderName) {
		this.bankAccountHolderName = bankAccountHolderName;
	}
	/**
	 * @return the bankAccountNumber
	 */
	public String getBankAccountNumber() {
		return bankAccountNumber;
	}
	/**
	 * @param bankAccountNumber the bankAccountNumber to set
	 */
	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}
	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * @return the bankAccountPassword
	 */
	public String getBankAccountPassword() {
		return bankAccountPassword;
	}
	/**
	 * @param bankAccountPassword the bankAccountPassword to set
	 */
	public void setBankAccountPassword(String bankAccountPassword) {
		this.bankAccountPassword = bankAccountPassword;
	}
	/**
	 * @return the creditCardHolderName
	 */
	public String getCreditCardHolderName() {
		return creditCardHolderName;
	}
	/**
	 * @param creditCardHolderName the creditCardHolderName to set
	 */
	public void setCreditCardHolderName(String creditCardHolderName) {
		this.creditCardHolderName = creditCardHolderName;
	}
	/**
	 * @return the creditCardPassword
	 */
	public String getCreditCardPassword() {
		return creditCardPassword;
	}
	/**
	 * @param creditCardPassword the creditCardPassword to set
	 */
	public void setCreditCardPassword(String creditCardPassword) {
		this.creditCardPassword = creditCardPassword;
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
	/**
	 * @return the verificationCode
	 */
	public String getVerificationCode() {
		return verificationCode;
	}
	/**
	 * @param verificationCode the verificationCode to set
	 */
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	/**
	 * @return the mobileAccountHolderName
	 */
	public String getMobileAccountHolderName() {
		return mobileAccountHolderName;
	}
	/**
	 * @param mobileAccountHolderName the mobileAccountHolderName to set
	 */
	public void setMobileAccountHolderName(String mobileAccountHolderName) {
		this.mobileAccountHolderName = mobileAccountHolderName;
	}
	/**
	 * @return the mobileServiceProvider
	 */
	public String getMobileServiceProvider() {
		return mobileServiceProvider;
	}
	/**
	 * @param mobileServiceProvider the mobileServiceProvider to set
	 */
	public void setMobileServiceProvider(String mobileServiceProvider) {
		this.mobileServiceProvider = mobileServiceProvider;
	}
	/**
	 * @return the mobileAccountPassword
	 */
	public String getMobileAccountPassword() {
		return mobileAccountPassword;
	}
	/**
	 * @param mobileAccountPassword the mobileAccountPassword to set
	 */
	public void setMobileAccountPassword(String mobileAccountPassword) {
		this.mobileAccountPassword = mobileAccountPassword;
	} 
	
	
}
