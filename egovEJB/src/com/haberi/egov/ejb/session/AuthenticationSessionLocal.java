package com.haberi.egov.ejb.session;

import javax.ejb.Local;

import com.haberi.egov.ejb.entities.UserEntity;

@Local
public interface AuthenticationSessionLocal {

	public boolean createUser(UserEntity user);

	public boolean deleteUser(String userName);

	public boolean login(String userName, String password);

	public boolean logoff(String userName);

	public UserEntity findUser(String userName);

}
