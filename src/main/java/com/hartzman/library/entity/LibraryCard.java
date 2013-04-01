package com.hartzman.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.Period;

@Entity
@Table(name="library_card")
public class LibraryCard {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int card_id;
	
	@Column(name="start_date")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime startDate;
	
	@Column(name="expiration_date")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime expirationDate;

	/**
	 * @return the expirationDate
	 */
	public DateTime getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(DateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCard_id() {
		return card_id;
	}

	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}

	/**
	 * @return the startDate
	 */
	public DateTime getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	
}
