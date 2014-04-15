package com.haberi.egov.ejb.session;

import javax.ejb.Remote;

import com.haberi.egov.ejb.entities.UserEntity;

@Remote
public interface AuthenticationSessionRemote {
	
	public boolean createUser(UserEntity user);

	public boolean deleteUser(String userName);

	public boolean login(String userName, String password);

	public boolean logoff(String userName);

	public UserEntity findUser(String userName);

}
