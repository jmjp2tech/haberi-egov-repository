package com.haberi.egov.ejb.populator;

import com.haberi.egov.ejb.entities.AccountEntity;
import com.haberi.egov.ejb.entities.IdentityPaperEntity;
import com.haberi.egov.ejb.entities.IdentityPaperPK;
import com.haberi.egov.ejb.entities.dto.IdentityPaperDTO;
import com.haberi.egov.ejb.enums.CountryEnum;
import com.haberi.egov.ejb.enums.IdentityTypeEnum;

public class IdentityPaperPopulator {
	
	private static IdentityPaperPopulator instance ; 
	
	private IdentityPaperPopulator(){
		
	}
	
	public static IdentityPaperPopulator getInstance(){
		if(instance == null){
			instance = new IdentityPaperPopulator();
		}
		
		return instance;
	}
	
	public  IdentityPaperEntity toEntity(IdentityPaperDTO identityPaperDTO){
		IdentityPaperEntity identityPaperEntity = null;
		
		if(identityPaperDTO != null){
			identityPaperEntity = new IdentityPaperEntity();
			final IdentityPaperPK identityPaperPK = new IdentityPaperPK(); 
			identityPaperPK.setIdentityNumber(identityPaperDTO.getIdentityNumber());
			identityPaperPK.setIdentityType(identityPaperDTO.getIdentityType().getCode());
			identityPaperPK.setIssuingCountry(identityPaperDTO.getIssuingCountry().getName());
			identityPaperEntity.setIdentityPaperPK(identityPaperPK);
			identityPaperEntity.setExpiryDate(identityPaperDTO.getExpiryDate());
		}
		return  identityPaperEntity;
	}
	
	public  IdentityPaperDTO toDTO(IdentityPaperEntity identityPaperEntity){
		IdentityPaperDTO identityPaperDTO = null; 
		
		if(identityPaperEntity != null){
			identityPaperDTO = new IdentityPaperDTO() ;
			final IdentityPaperPK identityPaperPK = identityPaperEntity.getIdentityPaperPK(); 
			if(identityPaperPK != null){
				identityPaperDTO.setIdentityNumber(identityPaperPK.getIdentityNumber());
				identityPaperDTO.setIdentityType(IdentityTypeEnum.getEnum(identityPaperPK.getIdentityType()));
				identityPaperDTO.setIssuingCountry(CountryEnum.getEnum(identityPaperPK.getIssuingCountry()));
			}
			identityPaperDTO.setExpiryDate(identityPaperEntity.getExpiryDate());
		}
		return identityPaperDTO;
	}

}
