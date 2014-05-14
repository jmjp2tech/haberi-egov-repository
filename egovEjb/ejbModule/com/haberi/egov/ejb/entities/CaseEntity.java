package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.haberi.egov.ejb.enums.CaseStatusEnum;
import com.haberi.egov.ejb.enums.ServiceTypeEnum;

@Entity
@Table(name="EGOV_CASES")
public class CaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8045809367548003058L;
	
	@EmbeddedId
	private CasePK casePK ; 
	
	@OneToOne
	@JoinColumn(name="transactionId",referencedColumnName="transactionId", nullable=true)
	private PaymentEntity paymentEntity ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="accountId", referencedColumnName="accountId")
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
	
	@ManyToMany
	@JoinTable(name="EGOV_CASE_AGENT", 
		joinColumns={@JoinColumn(name="caseId" , referencedColumnName="caseId"), @JoinColumn(name="version" , referencedColumnName="version")},
		inverseJoinColumns={@JoinColumn(name="agentId" , referencedColumnName="agentId")})
	private Set<CaseAgentEntity> caseAgents; 
	
	//supporting documents: uploaded by the user for update , downloaded by the agent for verification
	@OneToMany(mappedBy="caseEntity")
	private Set<CaseSupportDocumentEntity> supportingDocuments; 
	
	//saved as an XML string
	@Lob
	private String userNotes;
		
	//saved as an XML string
	@Lob
	private String agentNotes;
	
	//readable short name to display on the front-end 
	private String name; 
	
	////readable short name to display on the front-end 
	private String description; 
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	
	/**
	 * @return the caseAgents
	 */
	public Set<CaseAgentEntity> getCaseAgents() {
		return caseAgents;
	}
	/**
	 * @param caseAgents the caseAgents to set
	 */
	public void setCaseAgents(Set<CaseAgentEntity> caseAgents) {
		this.caseAgents = caseAgents;
	}
	/**
	 * @return the casePK
	 */
	public CasePK getCasePK() {
		return casePK;
	}
	/**
	 * @param casePK the casePK to set
	 */
	public void setCasePK(CasePK casePK) {
		this.casePK = casePK;
	}
	
	
	
}
