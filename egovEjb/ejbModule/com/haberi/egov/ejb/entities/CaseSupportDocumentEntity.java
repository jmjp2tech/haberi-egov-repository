package com.haberi.egov.ejb.entities;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.haberi.egov.ejb.enums.DocumentTypeEnum;

@Entity
@Table(name="EGOV_CASE_SUPPORT_DOCUMENTS")
public class CaseSupportDocumentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private BigInteger id; 
	
	private DocumentTypeEnum documentType ; 
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="caseId",referencedColumnName="caseId"),
		@JoinColumn(name="version" , referencedColumnName="version")
	})
	private CaseEntity caseEntity ; 
	
	//supposed that the file name is significant, we use the name of the file uploaded
	private String name ; 
	
	private String filePath;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public DocumentTypeEnum getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentTypeEnum documentType) {
		this.documentType = documentType;
	}

	public CaseEntity getCaseEntity() {
		return caseEntity;
	}

	public void setCaseEntity(CaseEntity caseEntity) {
		this.caseEntity = caseEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	} 
	
	
	
}
