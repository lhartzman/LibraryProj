package com.hartzman.library.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="license")
public class License {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private DateTime expiration;
	private int copies;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the expiration
	 */
	public DateTime getExpiration() {
		return expiration;
	}
	/**
	 * @param expiration the expiration to set
	 */
	public void setExpiration(DateTime expiration) {
		this.expiration = expiration;
	}
	/**
	 * @return the copies
	 */
	public int getCopies() {
		return copies;
	}
	/**
	 * @param copies the copies to set
	 */
	public void setCopies(int copies) {
		this.copies = copies;
	}
}
