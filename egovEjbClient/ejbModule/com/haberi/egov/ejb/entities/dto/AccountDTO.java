package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import com.haberi.egov.ejb.constants.AccountConstants;
import com.haberi.egov.ejb.enums.ContactMethodEnum;
import com.haberi.egov.ejb.enums.CountryEnum;
import com.haberi.egov.ejb.enums.OccupationEnum;
import com.haberi.egov.ejb.enums.SexEnum;
import com.haberi.egov.ejb.enums.UserTypeEnum;

public class AccountDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -810006617859327854L;
	
	private String firstName;
	private String lastName;
	private String middleName;
	private Date dateOfBirth;
	private String placeOfBith; 
	private String father;
	private String mother; 
	private CountryEnum citizenship ; 
	private SexEnum sex;
	private IdentityPaperDTO identityPaper;
	private OccupationEnum occupation;
	private Map<String , AddressDTO> addresses ; 
	private UserTypeEnum userType;
	private String email;
	private ContactMethodEnum contactMethod;
	private String mobilePhone;
	private String homePhone;
	private String workPhone ;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the placeOfBith
	 */
	public String getPlaceOfBith() {
		return placeOfBith;
	}
	/**
	 * @param placeOfBith the placeOfBith to set
	 */
	public void setPlaceOfBith(String placeOfBith) {
		this.placeOfBith = placeOfBith;
	}
	/**
	 * @return the father
	 */
	public String getFather() {
		return father;
	}
	/**
	 * @param father the father to set
	 */
	public void setFather(String father) {
		this.father = father;
	}
	/**
	 * @return the mother
	 */
	public String getMother() {
		return mother;
	}
	/**
	 * @param mother the mother to set
	 */
	public void setMother(String mother) {
		this.mother = mother;
	}
	public SexEnum getSex() {
		return sex;
	}
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
	public IdentityPaperDTO getIdentityPaper() {
		return identityPaper;
	}
	public void setIdentityPaper(IdentityPaperDTO identityPaper) {
		this.identityPaper = identityPaper;
	}
	public OccupationEnum getOccupation() {
		return occupation;
	}
	public void setOccupation(OccupationEnum occupation) {
		this.occupation = occupation;
	}
	public UserTypeEnum getUserType() {
		return userType;
	}
	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ContactMethodEnum getContactMethod() {
		return contactMethod;
	}
	public void setContactMethod(ContactMethodEnum contactMethod) {
		this.contactMethod = contactMethod;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public Map<String , AddressDTO> getAddresses() {
		if(addresses == null){
			addresses = new Hashtable<String, AddressDTO>();
		}
		return addresses;
	}
	public void setAddresses(Map<String , AddressDTO> addresses) {
		this.addresses = addresses;
	}
	public CountryEnum getCitizenship() {
		return citizenship;
	}
	public void setCitizenship(CountryEnum citizenship) {
		this.citizenship = citizenship;
	}
	public void setHomeAddress(AddressDTO homeAddress){
		getAddresses().put(AccountConstants.HOME_ADDRESS, homeAddress);
	}
	public void setWorkAddress(AddressDTO workAddress){
		getAddresses().put(AccountConstants.WORK_ADDRESS, workAddress);
	}
}
