package com.haberi.egov.ejb.populator;


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
	
//	public UserEntity toEntity(UserDTO input){
//		return null;
//	}
	

}
