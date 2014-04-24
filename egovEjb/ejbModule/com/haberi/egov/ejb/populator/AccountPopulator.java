package com.haberi.egov.ejb.populator;

import com.haberi.egov.ejb.constants.AccountConstants;
import com.haberi.egov.ejb.entities.AccountEntity;
import com.haberi.egov.ejb.entities.HomeAddressEntity;
import com.haberi.egov.ejb.entities.WorkAddressEntity;
import com.haberi.egov.ejb.entities.dto.AccountDTO;
import com.haberi.egov.ejb.enums.AddressTypeEnum;

public class AccountPopulator {

private static AccountPopulator instance  ;
	
	private AccountPopulator(){
	}
	
	public static AccountPopulator getInstance() {
		if(instance == null){
			instance = new AccountPopulator();
		}
		
		return instance  ; 
	}
	
	public AccountEntity toEntity(AccountDTO accountDTO){
		AccountEntity accountEntity = null ; 
		if(accountDTO != null){
			accountEntity = new AccountEntity();
			
			accountEntity.setFirstName(accountDTO.getFirstName());
			accountEntity.setLastName(accountDTO.getLastName());
			accountEntity.setMiddleName(accountDTO.getMiddleName());
			accountEntity.setDateOfBirth(accountDTO.getDateOfBirth());
			if(accountDTO.getCitizenship() != null){
				accountEntity.setCitizenship(accountDTO.getCitizenship().getName());
			}
			
			if(accountDTO.getSex() != null){
				accountEntity.setSex(accountDTO.getSex());
			}
			
			if(accountDTO.getIdentityPaper()!= null){
				accountEntity.setIdentityPaper(IdentityPaperPopulator.getInstance().toEntity(accountDTO.getIdentityPaper()));
			}
			accountEntity.setOccupation(accountDTO.getOccupation().getCode());
			if(accountDTO.getAddresses().containsKey(AccountConstants.HOME_ADDRESS)){
				accountEntity.setHomeAddress((HomeAddressEntity)AddressPopulator.getInstance().toEntity(accountDTO.getAddresses().get(AccountConstants.HOME_ADDRESS), AddressTypeEnum.HOME));
			}
			
			if(accountDTO.getAddresses().containsKey(AccountConstants.WORK_ADDRESS)){
				accountEntity.setWorkAddress((WorkAddressEntity)AddressPopulator.getInstance().toEntity(accountDTO.getAddresses().get(AccountConstants.WORK_ADDRESS), AddressTypeEnum.WORK));
			}
			
			accountEntity.setUserType(accountDTO.getUserType().getCode());
			accountEntity.setEmail(accountDTO.getEmail());
			accountEntity.setMobilePhone(accountDTO.getMobilePhone());
			accountEntity.setHomePhone(accountDTO.getHomePhone());
			accountEntity.setWorkPhone(accountDTO.getWorkPhone());
			accountEntity.setContactMethod(accountDTO.getContactMethod().getCode());
			
		}
		return accountEntity ; 
	}
	
	public  AccountDTO toDTO(){
		AccountDTO accountDTO = null ; 
		
		return accountDTO;
	}
	
}
