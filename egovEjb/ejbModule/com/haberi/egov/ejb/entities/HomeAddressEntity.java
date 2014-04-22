package com.haberi.egov.ejb.entities;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("home")
public class HomeAddressEntity extends AddressEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6576835867357925457L;
	
	@OneToMany(mappedBy="homeAddress")
	private Set<AccountEntity> accountEntities;

	public HomeAddressEntity() {
		super();
		//this.getAddressPK().setAddressType("home");
	}

	/**
	 * @return the accountEntities
	 */
	public Set<AccountEntity> getAccountEntities() {
		return accountEntities;
	}

	/**
	 * @param accountEntities the accountEntities to set
	 */
	public void setAccountEntities(Set<AccountEntity> accountEntities) {
		this.accountEntities = accountEntities;
	} 
	
	
	
	
}
