package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EGOV_NOTES")
public class AgentNoteEntity implements Serializable {

	@Id
	private BigInteger noteId;
	
	@ManyToOne
	@JoinColumn(name="agentId")
	private CaseAgentEntity  caseAgent; 

	//date of the note (format: YYYY-MM-DD, HH:mm:ss)
	@Temporal(TemporalType.DATE)
	private Date noteTimeStamp ; 
	
	@Lob
	private String noteContent;
}

