package com.haberi.egov.servlets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.haberi.egov.ejb.constants.AccountConstants;
import com.haberi.egov.ejb.constants.AddressConstants;
import com.haberi.egov.ejb.constants.DateConstants;
import com.haberi.egov.ejb.constants.IdentityPaperConstants;
import com.haberi.egov.ejb.entities.dto.AccountDTO;
import com.haberi.egov.ejb.entities.dto.AddressDTO;
import com.haberi.egov.ejb.entities.dto.IdentityPaperDTO;
import com.haberi.egov.ejb.enums.ContactMethodEnum;
import com.haberi.egov.ejb.enums.CountryEnum;
import com.haberi.egov.ejb.enums.IdentityTypeEnum;
import com.haberi.egov.ejb.enums.OccupationEnum;
import com.haberi.egov.ejb.enums.SexEnum;
import com.haberi.egov.ejb.enums.UserTypeEnum;

public class JsonHelper {

	private static JsonHelper instance ; 
	
	private JsonHelper(){
		
	}
	
	public static JsonHelper getInstance(){
		if(instance == null){
			instance = new JsonHelper();
		}
		return instance; 
	}
	
	public JsonObject toJsonObject(String jsonString){
		JsonObject jsonObject = null; 
		if(jsonString != null){
			JsonParser parser = new JsonParser() ; 
			jsonObject = parser.parse(jsonString).getAsJsonObject(); 
		}
		
		return jsonObject; 
	}

	public AccountDTO toAccountDTO(JsonObject jsonAccountInfo) {
		AccountDTO accountDTO = null ; 
		if(jsonAccountInfo != null){
			accountDTO = new AccountDTO(); 
			try{
				accountDTO.setFirstName(jsonAccountInfo.get(AccountConstants.FIRST_NAME).getAsString());
				accountDTO.setLastName(jsonAccountInfo.get(AccountConstants.LAST_NAME).getAsString());
				accountDTO.setMiddleName(jsonAccountInfo.get(AccountConstants.MIDDLE_NAME).getAsString());
				accountDTO.setDateOfBirth(getDate(jsonAccountInfo.get(AccountConstants.DATE_OF_BIRTH).getAsString(),DateConstants.DEFAULT_FORMAT));
				accountDTO.setCitizenship(CountryEnum.getEnum(jsonAccountInfo.get(AccountConstants.CITIZENSHIP).getAsString()));
				accountDTO.setSex(SexEnum.getEnum(jsonAccountInfo.get(AccountConstants.SEX).getAsString()));
				accountDTO.setIdentityPaper(toIdentityPaperDTO(jsonAccountInfo.get(AccountConstants.IDENTITY_PAPER).getAsJsonObject()));
				accountDTO.setOccupation(OccupationEnum.getEnum(jsonAccountInfo.get(AccountConstants.OCCUPATION).getAsString()));
				accountDTO.setHomeAddress(toAddressDTO(jsonAccountInfo.get(AccountConstants.HOME_ADDRESS).getAsJsonObject()));
				accountDTO.setWorkAddress(toAddressDTO(jsonAccountInfo.get(AccountConstants.WORK_ADDRESS).getAsJsonObject()));
				//for the time being we are using only citizen (changes will come after having cleared related business logic)
				accountDTO.setUserType(UserTypeEnum.CITIZEN);
				accountDTO.setEmail(jsonAccountInfo.get(AccountConstants.EMAIL).getAsString());
				accountDTO.setMobilePhone(jsonAccountInfo.get(AccountConstants.MOBILE_PHONE).getAsString());
				accountDTO.setHomePhone(jsonAccountInfo.get(AccountConstants.HOME_PHONE).getAsString());
				accountDTO.setWorkPhone(jsonAccountInfo.get(AccountConstants.WORK_PHONE).getAsString());
				accountDTO.setContactMethod(ContactMethodEnum.getEnum(jsonAccountInfo.get(AccountConstants.CONTACT_METHOD).getAsString()));
			}catch(ParseException e){
				e.printStackTrace();
			}
		}
		return accountDTO;
	}
	
	public AddressDTO toAddressDTO(JsonObject jsonAddressInfo){
		AddressDTO addressDTO = null ; 
		
		if(jsonAddressInfo != null){
			addressDTO = new  AddressDTO(); 
			addressDTO.setStreetNumber(jsonAddressInfo.get(AddressConstants.STREET_NUMBER).getAsString());
			addressDTO.setStreetName(jsonAddressInfo.get(AddressConstants.STREET_NAME).getAsString());
			addressDTO.setAppartmentNumber(jsonAddressInfo.get(AddressConstants.APPARTMENT_NUMBER).getAsString());
			addressDTO.setZipCode(jsonAddressInfo.get(AddressConstants.ZIP_CODE).getAsString());
			addressDTO.setCell(jsonAddressInfo.get(AddressConstants.CELL).getAsString());
			addressDTO.setDistrict(jsonAddressInfo.get(AddressConstants.DISTICT).getAsString());
			addressDTO.setProvince(jsonAddressInfo.get(AddressConstants.PROVINCE).getAsString());			
		}
		return addressDTO ; 
	}
	
	public  IdentityPaperDTO toIdentityPaperDTO(JsonObject jsonIdentityPaperInfo){
		IdentityPaperDTO identityPaperDTO = null ; 
		
		if(jsonIdentityPaperInfo != null){
			identityPaperDTO = new IdentityPaperDTO(); 
			
			try {
				identityPaperDTO.setIdentityNumber(jsonIdentityPaperInfo.get(IdentityPaperConstants.IDENTITY_NUMBER).getAsString());
				identityPaperDTO.setIdentityType(IdentityTypeEnum.getEnum(jsonIdentityPaperInfo.get(IdentityPaperConstants.IDENTITY_TYPE).getAsString()));
				identityPaperDTO.setIssuingCountry(CountryEnum.getEnum(jsonIdentityPaperInfo.get(IdentityPaperConstants.ISSUING_COUNTRY).getAsString()));
				identityPaperDTO.setExpiryDate(getDate(jsonIdentityPaperInfo.get(IdentityPaperConstants.EXPIRY_DATE).getAsString(),DateConstants.DEFAULT_FORMAT));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return identityPaperDTO;
	}
	
	private Date getDate(String dateString , String dateFormat) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat); 
		return formatter.parse(dateString);
	}
}
