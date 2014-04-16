package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;

import com.haberi.egov.ejb.enums.UserStatusEnum;



public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5889630551113324822L;

	private String  userName ; 
	
	private String password ; 
	
	private UserStatusEnum status ; 
	
	
	public UserDTO(){
		
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
	public UserStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(UserStatusEnum status) {
		this.status = status;
	}
}
