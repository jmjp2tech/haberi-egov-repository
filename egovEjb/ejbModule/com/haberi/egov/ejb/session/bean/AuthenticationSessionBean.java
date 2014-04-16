package com.haberi.egov.ejb.session.bean;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.haberi.egov.ejb.entities.UserEntity;
import com.haberi.egov.ejb.entities.dto.UserDTO;
import com.haberi.egov.ejb.enums.UserStatusEnum;
import com.haberi.egov.ejb.session.AuthenticationSessionLocal;
import com.haberi.egov.ejb.session.AuthenticationSessionRemote;

@Stateful(name = "AuthenticationSession")
public class AuthenticationSessionBean implements AuthenticationSessionLocal,
		AuthenticationSessionRemote {

	@PersistenceContext(name = "EgovPersistenceUnit")
	EntityManager em;

	@Override
	public boolean createUser(UserDTO user) {
		UserEntity userEntity = toEntity(user);
		em.persist(userEntity);
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
		if (user != null && user.getPassword().equals(password)) {
			user.setStatus(UserStatusEnum.ONLINE.getValue());
			em.merge(user);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean logoff(String userName) {
		return false;
	}

	/**
	 * @param userName
	 * @return
	 */
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

	private UserDTO toDTO(UserEntity entity) {
		UserDTO userDTO = null;

		if (entity != null) {
			userDTO = new UserDTO();
			userDTO.setUserName(entity.getUserName());
			userDTO.setPassword(entity.getPassword());
			userDTO.setStatus(UserStatusEnum.getEnumByValue(entity.getStatus()));
		}

		return userDTO;
	}

	private UserEntity toEntity(UserDTO userDTO) {
		UserEntity userEntity = null;
		if (userDTO != null) {
			userEntity = new UserEntity();
			userEntity.setUserName(userDTO.getUserName());
			userEntity.setPassword(userDTO.getPassword());
			userEntity.setStatus(userDTO.getStatus().getValue());
		}
		return userEntity;
	}

	@Override
	public UserDTO getUser(String userName) {
		return toDTO(findUser(userName));
	}
}
