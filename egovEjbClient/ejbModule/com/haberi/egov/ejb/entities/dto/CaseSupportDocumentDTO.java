package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.haberi.egov.ejb.enums.DocumentTypeEnum;

@Entity
public class CaseSupportDocumentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7662620712194872022L;
	private BigInteger id; 
	private DocumentTypeEnum documentType ; 
	private CaseDTO caseDTO ; 
	//supposed that the file name is significant, we use the name of the file uploaded
	private String name ; 
	private String filePath;
	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(BigInteger id) {
		this.id = id;
	}
	/**
	 * @return the documentType
	 */
	public DocumentTypeEnum getDocumentType() {
		return documentType;
	}
	/**
	 * @param documentType the documentType to set
	 */
	public void setDocumentType(DocumentTypeEnum documentType) {
		this.documentType = documentType;
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
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	
}
