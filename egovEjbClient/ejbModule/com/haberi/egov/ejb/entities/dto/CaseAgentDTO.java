package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import com.haberi.egov.ejb.enums.DepartmentEnum;

public class CaseAgentDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4595131178397730066L;
	
	private BigInteger agentId; 
	private String userName ; 
	private String password; 
	private String email;
	private DepartmentEnum department; 
	private Set<CaseDTO> cases;
	/**
	 * @return the agentId
	 */
	public BigInteger getAgentId() {
		return agentId;
	}
	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(BigInteger agentId) {
		this.agentId = agentId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the department
	 */
	public DepartmentEnum getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(DepartmentEnum department) {
		this.department = department;
	}
	/**
	 * @return the cases
	 */
	public Set<CaseDTO> getCases() {
		if(cases == null){
			cases = new HashSet<CaseDTO>();
		}
		return cases;
	}
	/**
	 * @param cases the cases to set
	 */
	public void setCases(Set<CaseDTO> cases) {
		this.cases = cases;
	}
	
}
