package com.haberi.egov.ejb.utils;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.json.JsonWriterFactory;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.oxm.record.JSONWriterRecord;

import sun.org.mozilla.javascript.internal.annotations.JSConstructor;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonToken;
import com.haberi.egov.ejb.constants.AccountConstants;
import com.haberi.egov.ejb.constants.AddressConstants;
import com.haberi.egov.ejb.constants.CaseAgentConstants;
import com.haberi.egov.ejb.constants.CaseConstants;
import com.haberi.egov.ejb.constants.CaseSupportDocumentConstants;
import com.haberi.egov.ejb.constants.DateConstants;
import com.haberi.egov.ejb.constants.IdentityPaperConstants;
import com.haberi.egov.ejb.constants.NoteConstants;
import com.haberi.egov.ejb.constants.PaymentConstants;
import com.haberi.egov.ejb.entities.dto.AccountDTO;
import com.haberi.egov.ejb.entities.dto.AddressDTO;
import com.haberi.egov.ejb.entities.dto.CaseAgentDTO;
import com.haberi.egov.ejb.entities.dto.CaseDTO;
import com.haberi.egov.ejb.entities.dto.CaseSupportDocumentDTO;
import com.haberi.egov.ejb.entities.dto.IdentityPaperDTO;
import com.haberi.egov.ejb.entities.dto.NoteDTO;
import com.haberi.egov.ejb.entities.dto.NotesDTO;
import com.haberi.egov.ejb.entities.dto.PaymentDTO;
import com.haberi.egov.ejb.enums.CaseStatusEnum;
import com.haberi.egov.ejb.enums.ContactMethodEnum;
import com.haberi.egov.ejb.enums.CountryEnum;
import com.haberi.egov.ejb.enums.CreditCardTypeEnum;
import com.haberi.egov.ejb.enums.DepartmentEnum;
import com.haberi.egov.ejb.enums.DocumentTypeEnum;
import com.haberi.egov.ejb.enums.IdentityTypeEnum;
import com.haberi.egov.ejb.enums.OccupationEnum;
import com.haberi.egov.ejb.enums.PaymentTypeEnum;
import com.haberi.egov.ejb.enums.ServiceTypeEnum;
import com.haberi.egov.ejb.enums.SexEnum;
import com.haberi.egov.ejb.enums.UserTypeEnum;
import com.sun.corba.se.impl.ior.WireObjectKeyTemplate;
import com.sun.org.apache.xml.internal.utils.NodeConsumer;

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
	
	
	public JsonObject toJsonObject(PaymentDTO paymentDTO){
		JsonObject jsonObject = new JsonObject(); 
		
		if(paymentDTO != null){
			jsonObject.addProperty(PaymentConstants.TRANSACTION_NUMBER, paymentDTO.getTransactionId());
			jsonObject.addProperty(PaymentConstants.PAYMENT_TYPE, paymentDTO.getPaymentType().getCode());
			
			jsonObject.addProperty(PaymentConstants.CREDIT_CARD_TYPE, paymentDTO.getCreditCardType().getCode());
			jsonObject.addProperty(PaymentConstants.CREDIT_CARD_HOLDER_NAME, paymentDTO.getCreditCardHolderName());
			jsonObject.addProperty(PaymentConstants.CREDIT_CARD_NUMBER, paymentDTO.getCreditCardNumber());
			jsonObject.addProperty(PaymentConstants.CREDIT_CARD_ISSUING_INSTITUTION, paymentDTO.getCreditCardIssuingInstitution());
			
			jsonObject.addProperty(PaymentConstants.BANK_ACCOUNT_HOLDER_NAME, paymentDTO.getBankAccountHolderName());
			jsonObject.addProperty(PaymentConstants.BANK_ACCOUNT_NUMBER, paymentDTO.getBankAccountNumber());
			jsonObject.addProperty(PaymentConstants.BANK_NAME, paymentDTO.getBankName());
			jsonObject.addProperty(PaymentConstants.BRANCH_NAME, paymentDTO.getBranchName());
		}
		
		return jsonObject;
	}
	
	
	public CaseAgentDTO toCaseAgentDTO(JsonObject jsonObject){
		
		CaseAgentDTO caseAgentDTO = null ; 
		
		if(jsonObject != null){
			caseAgentDTO = new CaseAgentDTO(); 
			caseAgentDTO.setAgentId(jsonObject.get(CaseAgentConstants.AGENT_ID).getAsBigInteger());
			caseAgentDTO.setDepartment(DepartmentEnum.getEnum(jsonObject.get(CaseAgentConstants.DEPARTMENT).getAsString()));
			caseAgentDTO.setEmail(jsonObject.get(CaseAgentConstants.EMAIL).getAsString());
			caseAgentDTO.setPassword(jsonObject.get(CaseAgentConstants.PASSWORD).getAsString());
			caseAgentDTO.setUserName(jsonObject.get(CaseAgentConstants.USER_NAME).getAsString());
//			caseAgentDTO.setCases(cases);
		}
		return caseAgentDTO; 
	}
	
	
	public JsonObject toJsonObject(CaseAgentDTO caseAgentDTO){
		
		JsonObject jsonObject = new JsonObject();
		
		if(jsonObject != null){
			
			jsonObject.addProperty(CaseAgentConstants.AGENT_ID, caseAgentDTO.getAgentId());
			jsonObject.addProperty(CaseAgentConstants.DEPARTMENT, caseAgentDTO.getDepartment().name());
			jsonObject.addProperty(CaseAgentConstants.EMAIL, caseAgentDTO.getEmail());
			jsonObject.addProperty(CaseAgentConstants.PASSWORD, caseAgentDTO.getPassword());
			jsonObject.addProperty(CaseAgentConstants.USER_NAME, caseAgentDTO.getUserName());
			
//			jsonObject.addProperty(cases,cases);
		}
		return jsonObject; 
	}
	
	public NotesDTO toNotesDTO(JsonArray jsonArray){
		
		NotesDTO notesDTO = null ; 
		if(jsonArray != null && jsonArray.size()>0){
			
			notesDTO = new NotesDTO(); 
			for(int i = 0 ;  i < jsonArray.size() ; i++){
				JsonObject note = jsonArray.get(i).getAsJsonObject();
				notesDTO.getNotes().add(toNoteDTO(note));
			}
		}
			
		return notesDTO; 
	}
	
	public JsonArray toJsonArray(NotesDTO notesDTO){
		JsonArray jsonArray = new JsonArray(); 
		
		if(notesDTO != null && CollectionUtils.isNotEmpty(notesDTO.getNotes())){
			for(NoteDTO noteDTO : notesDTO.getNotes()){
				JsonObject jsonNote = toJsonObject(noteDTO); 
				if(jsonNote.has(NoteConstants.USER_NAME) && jsonNote.has(NoteConstants.TIMESTAMP) && jsonNote.has(NoteConstants.CONTENT)){
					jsonArray.add(toJsonObject(noteDTO));
				}
			}
		}
		return jsonArray;
	}

	public JsonObject toJsonObject(NoteDTO noteDTO) {
		
		JsonObject jsonObject = new JsonObject();
		
		if(noteDTO != null){
			jsonObject.addProperty(NoteConstants.CONTENT, noteDTO.getContent());
			jsonObject.addProperty(NoteConstants.TIMESTAMP, noteDTO.getTimeStamp());
			jsonObject.addProperty(NoteConstants.USER_ID, noteDTO.getUserId());
			jsonObject.addProperty(NoteConstants.USER_NAME, noteDTO.getUserName());
		}
		return jsonObject;
	}

	public NoteDTO toNoteDTO(JsonObject jsonNote) {
		NoteDTO noteDTO = null;
		if(jsonNote != null){
			noteDTO = new NoteDTO(); 
			noteDTO.setContent(jsonNote.get(NoteConstants.CONTENT).getAsString());
			noteDTO.setTimeStamp(jsonNote.get(NoteConstants.TIMESTAMP).getAsLong());
			noteDTO.setUserId(jsonNote.get(NoteConstants.USER_ID).getAsString());
			noteDTO.setContent(jsonNote.get(NoteConstants.USER_NAME).getAsString());
		}
		return noteDTO;
	} 
	
	public CaseSupportDocumentDTO toCaseSupportDocumentDTO(JsonObject jsonObject){
		
		CaseSupportDocumentDTO caseSupportDocumentDTO = null;
		
		if(jsonObject != null){
			caseSupportDocumentDTO = new CaseSupportDocumentDTO(); 
			//caseSupportDocumentDTO.setCaseDTO(toCaseDTO(jsonObject.get(CaseSupportDocumentConstants.CASE).getAsJsonObject()));
			caseSupportDocumentDTO.setDocumentType(DocumentTypeEnum.getEnum(jsonObject.get(CaseSupportDocumentConstants.DOCUMENT_TYPE).getAsString()));
			caseSupportDocumentDTO.setFilePath(jsonObject.get(CaseSupportDocumentConstants.FILE_PATH).getAsString());
			caseSupportDocumentDTO.setId(jsonObject.get(CaseSupportDocumentConstants.ID).getAsBigInteger());
			caseSupportDocumentDTO.setName(jsonObject.get(CaseSupportDocumentConstants.NAME).getAsString());
		}
		return caseSupportDocumentDTO;
	}
	
	public JsonObject toJsonObject(CaseSupportDocumentDTO caseSupportDocumentDTO){
		JsonObject jsonObject = new JsonObject(); 
		
		if(caseSupportDocumentDTO != null){
			jsonObject.addProperty(CaseSupportDocumentConstants.DOCUMENT_TYPE, caseSupportDocumentDTO.getDocumentType().name());
			jsonObject.addProperty(CaseSupportDocumentConstants.FILE_PATH, caseSupportDocumentDTO.getFilePath());
			jsonObject.addProperty(CaseSupportDocumentConstants.ID, caseSupportDocumentDTO.getId());
			jsonObject.addProperty(CaseSupportDocumentConstants.NAME, caseSupportDocumentDTO.getName());
			jsonObject.add(CaseSupportDocumentConstants.CASE, getJsonObject(caseSupportDocumentDTO.getCaseDTO()));
		}
		return jsonObject;
	}

	public JsonObject getJsonObject(CaseDTO caseDTO) {

		JsonObject jsonObject = new JsonObject(); 
		if(caseDTO != null){
			if(caseDTO.getCaseId() != null){
				jsonObject.addProperty(CaseConstants.CASE_ID, caseDTO.getCaseId());
			}
			jsonObject.add(CaseConstants.PAYMENT, toJsonObject(caseDTO.getPaymentDTO()));
			jsonObject.add(CaseConstants.ACCOUNT, toJsonObject(caseDTO.getAccountDTO()));
			jsonObject.addProperty(CaseConstants.CREATION_DATE,new SimpleDateFormat(DateConstants.DEFAULT_FORMAT).format(caseDTO.getCreationDate()));
			jsonObject.addProperty(CaseConstants.EXPECTED_CLOSE_DATE,new SimpleDateFormat(DateConstants.DEFAULT_FORMAT).format(caseDTO.getExpectedCloseDate()));
			jsonObject.addProperty(CaseConstants.ACTUAL_CLOSE_DATE,new SimpleDateFormat(DateConstants.DEFAULT_FORMAT).format(caseDTO.getActualCloseDate()));
			jsonObject.addProperty(CaseConstants.SERVICE_TYPE, caseDTO.getServiceType().name());
			jsonObject.addProperty(CaseConstants.CASE_STATUS, caseDTO.getCaseStatus().name());
			jsonObject.add(CaseConstants.AGENT, toJsonObject(caseDTO.getCurrentCaseAgent()));
			if(CollectionUtils.isNotEmpty(caseDTO.getSupportingDocuments())){
				JsonArray supportingDocsArray =  new JsonArray() ; 
				for(CaseSupportDocumentDTO supportingDoc : caseDTO.getSupportingDocuments()){
					supportingDocsArray.add(toJsonObject(supportingDoc));
				}
				
				jsonObject.add(CaseConstants.SUPPORTING_DOCUMENTS,supportingDocsArray);
			}
			
			if((caseDTO.getUserNotes()!= null) && (CollectionUtils.isNotEmpty(caseDTO.getUserNotes().getNotes()))){
				jsonObject.add(CaseConstants.USER_NOTES, toJsonArray(caseDTO.getUserNotes()));
			}
			
			if(caseDTO.getAgentNotes() != null && CollectionUtils.isNotEmpty(caseDTO.getAgentNotes().getNotes())){
				jsonObject.add(CaseConstants.AGENT_NOTES, toJsonArray(caseDTO.getAgentNotes()));
			}
		}
		
		return jsonObject;
	}
	
	public CaseDTO toCaseDTO(JsonObject jsonObject){
		CaseDTO caseDTO = null ; 
		
		if(jsonObject != null){
			caseDTO = new CaseDTO() ; 
			
			if(jsonObject.has(CaseConstants.CASE_ID) && StringUtils.isNotBlank(jsonObject.get(CaseConstants.CASE_ID).getAsString())){
				BigInteger id = jsonObject.get(CaseConstants.CASE_ID).getAsBigInteger(); 
				if(BigInteger.ZERO.compareTo(id) != 0){
					caseDTO.setCaseId(id);
				}
			}
			
			caseDTO.setPaymentDTO(toPaymentDTO(jsonObject.get(CaseConstants.PAYMENT).getAsJsonObject()));
			caseDTO.setAccountDTO(toAccountDTO(jsonObject.get(CaseConstants.ACCOUNT).getAsJsonObject()));
			try {
				caseDTO.setCreationDate(getDate(jsonObject.get(CaseConstants.CREATION_DATE).getAsString(), DateConstants.DEFAULT_FORMAT));
				caseDTO.setExpectedCloseDate(getDate(jsonObject.get(CaseConstants.EXPECTED_CLOSE_DATE).getAsString(), DateConstants.DEFAULT_FORMAT));
				caseDTO.setActualCloseDate(getDate(jsonObject.get(CaseConstants.ACTUAL_CLOSE_DATE).getAsString(), DateConstants.DEFAULT_FORMAT));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			caseDTO.setServiceType(ServiceTypeEnum.getEnum(jsonObject.get(CaseConstants.SERVICE_TYPE).getAsString()));
			caseDTO.setCaseStatus(CaseStatusEnum.getEnum(jsonObject.get(CaseConstants.CASE_STATUS).getAsString()));
			caseDTO.setCurrentCaseAgent(toCaseAgentDTO(jsonObject.get(CaseConstants.AGENT).getAsJsonObject()));
			
			JsonArray supportDocsArray = jsonObject.get(CaseConstants.SUPPORTING_DOCUMENTS).getAsJsonArray();
			
			if(supportDocsArray.size() > 0){
				Set<CaseSupportDocumentDTO> supportingDocuments = new HashSet<CaseSupportDocumentDTO>();
				for(int i = 0 ; i < supportDocsArray.size() ; i ++ ){ 
					JsonObject currentDocJson = (JsonObject) supportDocsArray.get(i);
					CaseSupportDocumentDTO currentDoc = toCaseSupportDocumentDTO(currentDocJson);
					if(currentDoc != null){
						supportingDocuments.add(currentDoc);
					}
				}
				caseDTO.setSupportingDocuments(supportingDocuments);
			}
			
			caseDTO.setUserNotes(toNotesDTO(jsonObject.get(CaseConstants.USER_NOTES).getAsJsonArray()));
			caseDTO.setAgentNotes(toNotesDTO(jsonObject.get(CaseConstants.AGENT_NOTES).getAsJsonArray()));
		}
		return caseDTO; 
	}
}
