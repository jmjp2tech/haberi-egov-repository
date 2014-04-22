package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity

@NamedQueries({
	@NamedQuery(name = "UserEntity.findAll",query="select u from UserEntity u"),
	@NamedQuery(name = "UserEntity.findByUserName",query = "select u from UserEntity u where u.userName = :userName")	
})

@Table(name="EGOV_USERS")

public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8610622398965227262L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private BigInteger id ; 
	
	@Column(unique=true)
	private String  userName ; 
	
	private String password ; 
	
	private String status ; 
	
	public UserEntity(){
		
	}

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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
