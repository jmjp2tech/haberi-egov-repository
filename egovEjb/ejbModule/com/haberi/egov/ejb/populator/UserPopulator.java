package com.haberi.egov.ejb.populator;

import com.haberi.egov.ejb.entities.UserEntity;
import com.haberi.egov.ejb.entities.dto.UserDTO;
import com.haberi.egov.ejb.enums.UserStatusEnum;


public class UserPopulator {
	
	private static UserPopulator instance  ;
	
	private UserPopulator(){
	}
	
	public static UserPopulator getInstance() {
		if(instance == null){
			instance = new UserPopulator();
		}
		
		return instance  ; 
	}
	
	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO userDTO = null;

		if (userEntity != null) {
			userDTO = new UserDTO();
			userDTO.setUserName(userEntity.getUserName());
			userDTO.setPassword(userEntity.getPassword());
			userDTO.setStatus(UserStatusEnum.getEnumByValue(userEntity.getStatus()));
			if(userEntity.getAccount() != null){
				userDTO.setAccountDTO(AccountPopulator.getInstance().toDTO(userEntity.getAccount()));
			}
		}

		return userDTO;
	}

	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity userEntity = null;
		if (userDTO != null) {
			userEntity = new UserEntity();
			userEntity.setUserName(userDTO.getUserName());
			userEntity.setPassword(userDTO.getPassword());
			userEntity.setStatus(userDTO.getStatus().getValue());
			if(userDTO.getAccountDTO() != null){
				userEntity.setAccount(AccountPopulator.getInstance().toEntity(userDTO.getAccountDTO()));
			}
		}
		return userEntity;
	}


}
