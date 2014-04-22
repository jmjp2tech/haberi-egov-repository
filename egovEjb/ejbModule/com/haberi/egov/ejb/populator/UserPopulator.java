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
	
	public UserDTO toDTO(UserEntity entity) {
		UserDTO userDTO = null;

		if (entity != null) {
			userDTO = new UserDTO();
			userDTO.setUserName(entity.getUserName());
			userDTO.setPassword(entity.getPassword());
			userDTO.setStatus(UserStatusEnum.getEnumByValue(entity.getStatus()));
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
		}
		return userEntity;
	}


}
