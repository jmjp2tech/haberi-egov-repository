package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.glassfish.api.admin.AccessRequired.To;

import com.haberi.egov.ejb.enums.CaseStatusEnum;
import com.haberi.egov.ejb.enums.ServiceTypeEnum;

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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(referencedColumnName="accountId")
	private AccountEntity accountEntity ;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate; 
	
	@Temporal(TemporalType.DATE)
	private Date expectedCloseDate ; 
	
	@Temporal(TemporalType.DATE)
	private Date actualCloseDate ;
	
	@Enumerated(EnumType.STRING)
	private ServiceTypeEnum serviceType ; 
	
	@Enumerated(EnumType.STRING)
	private CaseStatusEnum caseStatus ;
	
	@ManyToOne
	@JoinColumn(name="agentId")
	private CaseAgentEntity currentCaseAgent ;
	
	/** TO DO: Many to many for past agents, for historical traceability **/
	
	//supporting documents: uploaded by the user for update , downloaded by the agent for verification
	@OneToMany(fetch=FetchType.LAZY)
	private Set<CaseSupportDocumentEntity> supportingDocuments; 
	
	// saved as an XML string
	@Lob
	private String userNotes;
		
	// saved as an XML string
	@Lob
	private String agentNotes; 
	
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
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the expectedCloseDate
	 */
	public Date getExpectedCloseDate() {
		return expectedCloseDate;
	}
	/**
	 * @param expectedCloseDate the expectedCloseDate to set
	 */
	public void setExpectedCloseDate(Date expectedCloseDate) {
		this.expectedCloseDate = expectedCloseDate;
	}
	/**
	 * @return the actualCloseDate
	 */
	public Date getActualCloseDate() {
		return actualCloseDate;
	}
	/**
	 * @param actualCloseDate the actualCloseDate to set
	 */
	public void setActualCloseDate(Date actualCloseDate) {
		this.actualCloseDate = actualCloseDate;
	}
	/**
	 * @return the serviceType
	 */
	public ServiceTypeEnum getServiceType() {
		return serviceType;
	}
	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(ServiceTypeEnum serviceType) {
		this.serviceType = serviceType;
	}
	/**
	 * @return the caseStatus
	 */
	public CaseStatusEnum getCaseStatus() {
		return caseStatus;
	}
	/**
	 * @param caseStatus the caseStatus to set
	 */
	public void setCaseStatus(CaseStatusEnum caseStatus) {
		this.caseStatus = caseStatus;
	}
	/**
	 * @return the currentCaseAgent
	 */
	public CaseAgentEntity getCurrentCaseAgent() {
		return currentCaseAgent;
	}
	/**
	 * @param currentCaseAgent the currentCaseAgent to set
	 */
	public void setCurrentCaseAgent(CaseAgentEntity currentCaseAgent) {
		this.currentCaseAgent = currentCaseAgent;
	}
	/**
	 * @return the supportingDocuments
	 */
	public Set<CaseSupportDocumentEntity> getSupportingDocuments() {
		return supportingDocuments;
	}
	/**
	 * @param supportingDocuments the supportingDocuments to set
	 */
	public void setSupportingDocuments(
			Set<CaseSupportDocumentEntity> supportingDocuments) {
		this.supportingDocuments = supportingDocuments;
	}
	/**
	 * @return the userNotes
	 */
	public String getUserNotes() {
		return userNotes;
	}
	/**
	 * @param userNotes the userNotes to set
	 */
	public void setUserNotes(String userNotes) {
		this.userNotes = userNotes;
	}
	/**
	 * @return the agentNotes
	 */
	public String getAgentNotes() {
		return agentNotes;
	}
	/**
	 * @param agentNotes the agentNotes to set
	 */
	public void setAgentNotes(String agentNotes) {
		this.agentNotes = agentNotes;
	}
	
	
	
}
