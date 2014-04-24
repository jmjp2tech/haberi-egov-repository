package com.haberi.egov.ejb.populator;

import com.haberi.egov.ejb.entities.IdentityPaperEntity;
import com.haberi.egov.ejb.entities.IdentityPaperPK;
import com.haberi.egov.ejb.entities.dto.IdentityPaperDTO;

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

}
