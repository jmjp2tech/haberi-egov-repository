package com.haberi.egov.servlets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sun.org.mozilla.javascript.internal.annotations.JSConstructor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.haberi.egov.ejb.constants.AccountConstants;
import com.haberi.egov.ejb.constants.AddressConstants;
import com.haberi.egov.ejb.constants.DateConstants;
import com.haberi.egov.ejb.constants.IdentityPaperConstants;
import com.haberi.egov.ejb.constants.PaymentConstants;
import com.haberi.egov.ejb.entities.dto.AccountDTO;
import com.haberi.egov.ejb.entities.dto.AddressDTO;
import com.haberi.egov.ejb.entities.dto.IdentityPaperDTO;
import com.haberi.egov.ejb.entities.dto.PaymentDTO;
import com.haberi.egov.ejb.enums.ContactMethodEnum;
import com.haberi.egov.ejb.enums.CountryEnum;
import com.haberi.egov.ejb.enums.CreditCardTypeEnum;
import com.haberi.egov.ejb.enums.IdentityTypeEnum;
import com.haberi.egov.ejb.enums.OccupationEnum;
import com.haberi.egov.ejb.enums.PaymentTypeEnum;
import com.haberi.egov.ejb.enums.SexEnum;
import com.haberi.egov.ejb.enums.UserTypeEnum;
import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;

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
			addressDTO.setDistrict(jsonAddressInfo.get(AddressConstants.DISTRICT).getAsString());
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
	
	public Date getDate(String dateString , String dateFormat) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat); 
		return formatter.parse(dateString);
	}
	
	public JsonObject toJsonObject(AccountDTO accountDTO){
		JsonObject jsonObject = new JsonObject(); 
		
		if(accountDTO != null){
			jsonObject.addProperty(AccountConstants.FIRST_NAME, accountDTO.getFirstName());
			jsonObject.addProperty(AccountConstants.LAST_NAME, accountDTO.getLastName());
			jsonObject.addProperty(AccountConstants.MIDDLE_NAME, accountDTO.getMiddleName());
			jsonObject.addProperty(AccountConstants.DATE_OF_BIRTH, new SimpleDateFormat(DateConstants.DEFAULT_FORMAT).format(accountDTO.getDateOfBirth()));
			jsonObject.addProperty(AccountConstants.PLACE_OF_BIRTH, accountDTO.getPlaceOfBith());
			jsonObject.addProperty(AccountConstants.FATHER, accountDTO.getFather());
			jsonObject.addProperty(AccountConstants.MOTHER, accountDTO.getMother());
			jsonObject.addProperty(AccountConstants.CITIZENSHIP, accountDTO.getCitizenship().getName());
			jsonObject.addProperty(AccountConstants.SEX, accountDTO.getSex().getCode());
			jsonObject.addProperty(AccountConstants.OCCUPATION, accountDTO.getOccupation().getCode());
			jsonObject.addProperty(AccountConstants.EMAIL, accountDTO.getEmail());
			jsonObject.addProperty(AccountConstants.HOME_PHONE, accountDTO.getHomePhone());
			jsonObject.addProperty(AccountConstants.WORK_PHONE, accountDTO.getWorkPhone());
			jsonObject.addProperty(AccountConstants.MOBILE_PHONE, accountDTO.getMobilePhone());
			jsonObject.addProperty(AccountConstants.CONTACT_METHOD, accountDTO.getContactMethod().getCode());
			jsonObject.add(AccountConstants.IDENTITY_PAPER, this.toJsonObject(accountDTO.getIdentityPaper()));
			jsonObject.add(AccountConstants.HOME_ADDRESS, toJsonObject(accountDTO.getAddresses().get(AccountConstants.HOME_ADDRESS)));
			jsonObject.add(AccountConstants.WORK_ADDRESS, toJsonObject(accountDTO.getAddresses().get(AccountConstants.WORK_ADDRESS)));
			
		}
		
		return jsonObject;
	}

	private JsonObject toJsonObject(AddressDTO addressDTO) {
		JsonObject jsonObject = new JsonObject(); 
		
		if(addressDTO != null){
			jsonObject.addProperty(AddressConstants.STREET_NUMBER, addressDTO.getStreetNumber());
			jsonObject.addProperty(AddressConstants.STREET_NAME, addressDTO.getStreetName());
			jsonObject.addProperty(AddressConstants.APPARTMENT_NUMBER,addressDTO.getAppartmentNumber());
			jsonObject.addProperty(AddressConstants.ZIP_CODE, addressDTO.getZipCode());
			jsonObject.addProperty(AddressConstants.CELL, addressDTO.getCell());
			jsonObject.addProperty(AddressConstants.DISTRICT, addressDTO.getDistrict());
			jsonObject.addProperty(AddressConstants.PROVINCE, addressDTO.getProvince());
		}
		return jsonObject;
	}

	public JsonObject toJsonObject(IdentityPaperDTO identityPaperDTO) {
		
		JsonObject jsonObject = new JsonObject(); 
		if(identityPaperDTO != null){
			jsonObject.addProperty(IdentityPaperConstants.IDENTITY_NUMBER, identityPaperDTO.getIdentityNumber());
			jsonObject.addProperty(IdentityPaperConstants.IDENTITY_TYPE, identityPaperDTO.getIdentityType().getCode());
			jsonObject.addProperty(IdentityPaperConstants.ISSUING_COUNTRY, identityPaperDTO.getIssuingCountry().getName());
			jsonObject.addProperty(IdentityPaperConstants.EXPIRY_DATE, new SimpleDateFormat(DateConstants.DEFAULT_FORMAT).format(identityPaperDTO.getExpiryDate()));
		}
		return jsonObject;
	}
	
	public PaymentDTO toPaymentDTO(JsonObject jsonObject){
		PaymentDTO paymentDTO = null ; 
		if(jsonObject != null){
			paymentDTO = new PaymentDTO(); 
			final String paymentType  =  jsonObject.get(PaymentConstants.PAYMENT_TYPE).getAsString();
			System.out.println(paymentType);
			paymentDTO.setPaymentType(PaymentTypeEnum.getEnum(paymentType));
			
			switch (paymentDTO.getPaymentType()) {
			case CREDIT_CARD:{
				paymentDTO.setCreditCardType(CreditCardTypeEnum.getEnum(jsonObject.get(PaymentConstants.CREDIT_CARD_TYPE).getAsString()));
				paymentDTO.setCreditCardHolderName(jsonObject.get(PaymentConstants.CREDIT_CARD_HOLDER_NAME).getAsString());
				paymentDTO.setCreditCardNumber(jsonObject.get(PaymentConstants.CREDIT_CARD_NUMBER).getAsString());
				paymentDTO.setCreditCardPassword(jsonObject.get(PaymentConstants.CREDIT_CARD_PASSWORD).getAsString());
				try {
					paymentDTO.setExpiryDate(getDate(jsonObject.get(PaymentConstants.EXPPIRY_DATE).getAsString(), DateConstants.DEFAULT_FORMAT));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				paymentDTO.setVerificationCode(jsonObject.get(PaymentConstants.VERIFICATION_CODE).getAsString());
				paymentDTO.setCreditCardIssuingInstitution(jsonObject.get(PaymentConstants.CREDIT_CARD_ISSUING_INSTITUTION).getAsString());
				
				break;
			}
			
			case WIRE_TRANSFER: {
				paymentDTO.setBankAccountHolderName(jsonObject.get(PaymentConstants.BANK_ACCOUNT_HOLDER_NAME).getAsString());
				paymentDTO.setBankAccountNumber(jsonObject.get(PaymentConstants.BANK_ACCOUNT_NUMBER).getAsString());
				paymentDTO.setBankAccountPassword(jsonObject.get(PaymentConstants.BANK_ACCOUNT_PASSWORD).getAsString());
				paymentDTO.setBankName(jsonObject.get(PaymentConstants.BANK_NAME).getAsString());
				paymentDTO.setBranchName(jsonObject.get(PaymentConstants.BRANCH_NAME).getAsString());
				break; 
			}

			default:
				break;
			}
		}
		
		return paymentDTO;
	}
}
