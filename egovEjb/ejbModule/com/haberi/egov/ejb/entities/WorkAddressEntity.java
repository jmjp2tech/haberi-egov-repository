package com.haberi.egov.ejb.entities;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("work")
public class WorkAddressEntity extends AddressEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8575717399669079383L;
	
	@OneToMany(mappedBy="workAddress")
	private Set<AccountEntity> entities ;

	public WorkAddressEntity() {
		super();
		//this.getAddressPK().setAddressType("work");
	}

	/**
	 * @return the entities
	 */
	public Set<AccountEntity> getEntities() {
		return entities;
	}

	/**
	 * @param entities the entities to set
	 */
	public void setEntities(Set<AccountEntity> entities) {
		this.entities = entities;
	}
	
	

}
