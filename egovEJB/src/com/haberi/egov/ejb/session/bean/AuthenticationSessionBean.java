package com.haberi.egov.ejb.session.bean;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.haberi.egov.ejb.entities.UserEntity;
import com.haberi.egov.ejb.enums.UserStatusEnum;
import com.haberi.egov.ejb.session.AuthenticationSessionLocal;
import com.haberi.egov.ejb.session.AuthenticationSessionRemote;

@Stateful
public class AuthenticationSessionBean implements AuthenticationSessionLocal,
		AuthenticationSessionRemote {

	@PersistenceContext(name = "EgovPersistenceUnit")
	EntityManager em;

	@Override
	public boolean createUser(UserEntity user) {
		em.persist(user);
		return checkUserExists(user.getUserName());

	}

	private boolean checkUserExists(String userName) {
		boolean returnValue = false;
		final List<UserEntity> users = em
				.createNamedQuery("UserEntity.findByUserName", UserEntity.class)
				.setParameter("userName", userName).getResultList();

		if (users.size() > 0) {
			returnValue = true;
		}
		return returnValue;
	}

	@Override
	public boolean deleteUser(String userName) {
		final List<UserEntity> users = em
				.createNamedQuery("UserEntity.deleteByUserName",
						UserEntity.class).setParameter("userName", userName)
				.getResultList();

		if (users.size() > 0) {
			em.remove(userName);
		}

		return !checkUserExists(userName);

	}

	@Override
	public boolean login(String userName, String password) {

		UserEntity user = findUser(userName); 
		if(user != null && user.getPassword().equals(password)){
			user.setStatus(UserStatusEnum.ONLINE.getValue());
			em.merge(user);
			return true ; 
		}else{
			return false;
		}
	}

	@Override
	public boolean logoff(String userName) {


		return false;
	}

	@Override
	public UserEntity findUser(String userName) {
		final List<UserEntity> users = em
				.createNamedQuery("UserEntity.deleteByUserName",
						UserEntity.class).setParameter("userName", userName)
				.getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
