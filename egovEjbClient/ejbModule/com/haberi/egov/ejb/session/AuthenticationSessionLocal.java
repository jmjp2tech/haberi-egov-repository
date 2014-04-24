package com.haberi.egov.ejb.session;

import javax.ejb.Local;

import com.haberi.egov.ejb.entities.dto.AccountDTO;
import com.haberi.egov.ejb.entities.dto.UserDTO;

@Local
public interface AuthenticationSessionLocal {

	public boolean createUser(UserDTO user);

	public boolean deleteUser(String userName);

	public boolean login(String userName, String password);

	public boolean logoff(String userName);

	public UserDTO getUser(String userName);
	
	public boolean createAccount(AccountDTO account); 

}
