package com.haberi.egov.ejb.session;

import javax.ejb.Remote;

import com.haberi.egov.ejb.entities.dto.AccountDTO;
import com.haberi.egov.ejb.entities.dto.UserDTO;

@Remote
public interface AuthenticationSessionRemote {
	
	public boolean createUser(UserDTO user);

	public boolean deleteUser(String userName);

	public UserDTO login(String userName, String password);

	public boolean logoff(String userName);

	public UserDTO getUser(String userName);
	
	public boolean createAccount(AccountDTO account); 

}
