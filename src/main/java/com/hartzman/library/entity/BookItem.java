package com.hartzman.library.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name="library_items")
@DiscriminatorValue(value="BI")
public class BookItem extends LibraryItem {
	
	private String author;
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the copies
	 */

}
