package com.haberi.egov.ejb.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.haberi.egov.ejb.enums.SexEnum;

@Entity
@Table(name="EGOV_ACCOUNTS")
@SequenceGenerator(name="ACCOUNT_SEQ_GEN", initialValue=1)
public class AccountEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8321086302396781459L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ACCOUNT_SEQ_GEN")
	private BigInteger accountId;
	private String firstName;
	private String lastName;
	private String middleName;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String placeOfBirth; 
	private String father ; 
	private String mother; 
	private String citizenship ; 
	@Enumerated(EnumType.STRING)
	private SexEnum sex;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumns({
		@JoinColumn(name="identityNumber", referencedColumnName="identityNumber"),
		@JoinColumn(name="identityType", referencedColumnName="identityType" ),
		@JoinColumn(name="issuingCountry",referencedColumnName="issuingCountry")
	})
	private IdentityPaperEntity identityPaper;
	
	private String occupation;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumns({
		@JoinColumn(name="homeStreetNumber" , referencedColumnName="streetNumber"),
		@JoinColumn(name="homeStreetName" , referencedColumnName="streetName"),
		@JoinColumn(name="homeAppartmentNumber" , referencedColumnName="appartmentNumber"),
		@JoinColumn(name="homeZipCode" , referencedColumnName="zipCode"),
		@JoinColumn(name="homeCell" , referencedColumnName="cell"),
		@JoinColumn(name="homeDistrict" , referencedColumnName="district"),
		@JoinColumn(name="homeProvince" , referencedColumnName="province"),
	})
	private HomeAddressEntity homeAddress;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumns({
		@JoinColumn(name="workStreetNumber" , referencedColumnName="streetNumber"),
		@JoinColumn(name="workStreetName" , referencedColumnName="streetName"),
		@JoinColumn(name="workAppartmentNumber" , referencedColumnName="appartmentNumber"),
		@JoinColumn(name="workZipCode" , referencedColumnName="zipCode"),
		@JoinColumn(name="workCell" , referencedColumnName="cell"),
		@JoinColumn(name="workDistrict" , referencedColumnName="district"),
		@JoinColumn(name="workProvince" , referencedColumnName="province"),
	})
	private WorkAddressEntity workAddress;
	private String userType;
	private String email;
	private String contactMethod;
	private String mobilePhone;
	private String homePhone;
	private String workPhone ;
	private String accountStatus ; 
	
	@OneToOne(mappedBy="account")
	private UserEntity user; 
	
	
	
	
	public AccountEntity() {
		super();
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * @return the placeOfBirth
	 */
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	/**
	 * @param placeOfBirth the placeOfBirth to set
	 */
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
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

	/**
	 * @return the user
	 */
	public UserEntity getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}

	/**
	 * @return the identityPaper
	 */
	public IdentityPaperEntity getIdentityPaper() {
		return identityPaper;
	}
	/**
	 * @param identityPaper the identityPaper to set
	 */
	public void setIdentityPaper(IdentityPaperEntity identityPaper) {
		this.identityPaper = identityPaper;
	}
	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	/**
	 * @return the accountId
	 */
	public BigInteger getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(BigInteger accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the sex
	 */
	public SexEnum getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the contactMethod
	 */
	public String getContactMethod() {
		return contactMethod;
	}
	/**
	 * @param contactMethod the contactMethod to set
	 */
	public void setContactMethod(String contactMethod) {
		this.contactMethod = contactMethod;
	}
	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * @return the homePhone
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * @param homePhone the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	/**
	 * @return the workPhone
	 */
	public String getWorkPhone() {
		return workPhone;
	}
	/**
	 * @param workPhone the workPhone to set
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	/**
	 * @return the homeAddress
	 */
	public HomeAddressEntity getHomeAddress() {
		return homeAddress;
	}
	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(HomeAddressEntity homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * @return the workAddress
	 */
	public WorkAddressEntity getWorkAddress() {
		return workAddress;
	}
	/**
	 * @param workAddress the workAddress to set
	 */
	public void setWorkAddress(WorkAddressEntity workAddress) {
		this.workAddress = workAddress;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	} 
	
	
}
