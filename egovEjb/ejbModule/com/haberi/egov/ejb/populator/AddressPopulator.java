package com.haberi.egov.ejb.populator;

import com.haberi.egov.ejb.entities.AddressEntity;
import com.haberi.egov.ejb.entities.AddressPK;
import com.haberi.egov.ejb.entities.HomeAddressEntity;
import com.haberi.egov.ejb.entities.WorkAddressEntity;
import com.haberi.egov.ejb.entities.dto.AddressDTO;
import com.haberi.egov.ejb.enums.AddressTypeEnum;

public class AddressPopulator {
	
	private static AddressPopulator instance ; 
	
	private AddressPopulator(){
		
	}
	
	public static AddressPopulator getInstance(){
		if(instance == null){
			instance = new AddressPopulator(); 
		}
		
		return instance ; 
	}
	
	public AddressEntity toEntity(AddressDTO addressDTO,AddressTypeEnum addressType){
		AddressEntity addressEntity = null ; 
		
		if(addressDTO != null &&  addressType != null){
			if(AddressTypeEnum.HOME.equals(addressType)){
				addressEntity = new HomeAddressEntity(); 
			}
			
			if(AddressTypeEnum.WORK.equals(addressType)){
				addressEntity =  new  WorkAddressEntity(); 
			}
			
			AddressPK addressPK = new AddressPK(); 
			
			addressPK.setStreetNumber(addressDTO.getStreetNumber());
			addressPK.setStreetName(addressDTO.getStreetName());
			addressPK.setAppartmentNumber(addressDTO.getAppartmentNumber());
			addressPK.setZipCode(addressDTO.getZipCode());
			addressPK.setCell(addressDTO.getCell());
			addressPK.setDistrict(addressDTO.getDistrict());
			addressPK.setProvince(addressDTO.getProvince());
			
			addressEntity.setAddressPK(addressPK);
			addressEntity.setAddressType(addressType.getCode());
		}
		
		return addressEntity;
		
		
	}

	public AddressDTO toDTO(AddressEntity addressEntity) {
		AddressDTO addressDTO = null ; 
		if(addressEntity != null && addressEntity.getAddressPK()!= null){
			AddressPK addressPK = addressEntity.getAddressPK(); 
			addressDTO = new AddressDTO() ; 
			addressDTO.setStreetNumber(addressPK.getStreetNumber());
			addressDTO.setStreetName(addressPK.getStreetName());
			addressDTO.setAppartmentNumber(addressPK.getAppartmentNumber());
			addressDTO.setZipCode(addressPK.getZipCode());
			addressDTO.setCell(addressPK.getCell());
			addressDTO.setDistrict(addressPK.getDistrict());
			addressDTO.setProvince(addressPK.getProvince());
		}
		return addressDTO ; 
	}

}
