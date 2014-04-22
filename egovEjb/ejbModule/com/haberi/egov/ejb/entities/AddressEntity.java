package com.haberi.egov.ejb.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="EGOV_ADDRESSES")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="addressType")

public abstract class AddressEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -433501066249079761L;
	
	@EmbeddedId
	private AddressPK addressPK ;
	private String addressType; 
	
	public AddressEntity() {
		super();
	}

	/**
	 * @return the addressPK
	 */
	public AddressPK getAddressPK() {
		return addressPK;
	}

	/**
	 * @param addressPK the addressPK to set
	 */
	public void setAddressPK(AddressPK addressPK) {
		this.addressPK = addressPK;
	}

	/**
	 * @return the addressType
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 * @param addressType the addressType to set
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

}
