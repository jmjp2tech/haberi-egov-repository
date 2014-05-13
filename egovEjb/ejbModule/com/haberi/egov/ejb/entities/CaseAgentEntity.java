package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.haberi.egov.ejb.enums.DepartmentEnum;

@Entity
@Table(name="EGOV_AGENTS")
public class CaseAgentEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4595131178397730066L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private BigInteger agentId; 
	
	private String userName ; 
	private String password; 
	private String email;
	
	@Enumerated(EnumType.STRING)
	private DepartmentEnum department; 
	
	@OneToMany(mappedBy="currentCaseAgent")
	private Set<CaseEntity> currentCases;
	
	@ManyToMany(mappedBy="caseAgents")
	private Set<CaseEntity> allCases; 

	public BigInteger getAgentId() {
		return agentId;
	}

	public void setAgentId(BigInteger agentId) {
		this.agentId = agentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DepartmentEnum getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEnum department) {
		this.department = department;
	}	
	
	
}
