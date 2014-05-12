package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
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

import com.haberi.egov.ejb.enums.CaseStatusEnum;
import com.haberi.egov.ejb.enums.ServiceTypeEnum;

public class CaseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8045809367548003058L;
	
	private BigInteger caseId ;
	private PaymentDTO paymentDTO ;
	private AccountDTO accountDTO ;
	private Date creationDate; 
	private Date expectedCloseDate ; 
	private Date actualCloseDate ;
	private ServiceTypeEnum serviceType ; 
	private CaseStatusEnum caseStatus ;
	private CaseAgentDTO currentCaseAgent ;
	private Set<CaseSupportDocumentDTO> supportingDocuments; 
	private NotesDTO userNotes;
	private NotesDTO agentNotes;
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
	public CaseAgentDTO getCurrentCaseAgent() {
		return currentCaseAgent;
	}
	/**
	 * @param currentCaseAgent the currentCaseAgent to set
	 */
	public void setCurrentCaseAgent(CaseAgentDTO currentCaseAgent) {
		this.currentCaseAgent = currentCaseAgent;
	}
	/**
	 * @return the supportingDocuments
	 */
	public Set<CaseSupportDocumentDTO> getSupportingDocuments() {
		if(supportingDocuments== null){
			supportingDocuments = new HashSet<CaseSupportDocumentDTO>();
		}
		return supportingDocuments;
	}
	/**
	 * @param supportingDocuments the supportingDocuments to set
	 */
	public void setSupportingDocuments(
			Set<CaseSupportDocumentDTO> supportingDocuments) {
		this.supportingDocuments = supportingDocuments;
	}
	/**
	 * @return the userNotes
	 */
	public NotesDTO getUserNotes() {
		return userNotes;
	}
	/**
	 * @param userNotes the userNotes to set
	 */
	public void setUserNotes(NotesDTO userNotes) {
		this.userNotes = userNotes;
	}
	/**
	 * @return the agentNotes
	 */
	public NotesDTO getAgentNotes() {
		return agentNotes;
	}
	/**
	 * @param agentNotes the agentNotes to set
	 */
	public void setAgentNotes(NotesDTO agentNotes) {
		this.agentNotes = agentNotes;
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
