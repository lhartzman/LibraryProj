package com.hartzman.library.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name="library_items")
@DiscriminatorValue(value="DI")
public class DigitalItem extends LibraryItem {

	private int license_id;

	/**
	 * @return the license_id
	 */
	public int getLicense_id() {
		return license_id;
	}

	/**
	 * @param license_id the license_id to set
	 */
	public void setLicense_id(int license_id) {
		this.license_id = license_id;
	}

	
}
