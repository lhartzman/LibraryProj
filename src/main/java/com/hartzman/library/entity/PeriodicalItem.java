package com.hartzman.library.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name="library_items")
@DiscriminatorValue(value="PI")
public class PeriodicalItem extends LibraryItem {

	private int frequency;

	/**
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	
}
