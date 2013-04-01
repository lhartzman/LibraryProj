package com.hartzman.library.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="library_items")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="discriminator",
    discriminatorType=DiscriminatorType.STRING
)
public abstract class LibraryItem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String location;
    private String category;
    private String title;
    private String publisher;
    private DateTime pub_date;
    private int copies;
    private int catalog_id;
    private String state;

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
	 * @return the copies
	 */
	public int getCopies() {
		return copies;
	}

	/**
	 * @param count the count to set
	 */
	public void setCopies(int copies) {
		this.copies = copies;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the pub_date
	 */
	public DateTime getPub_date() {
		return pub_date;
	}

	/**
	 * @param pub_date the pub_date to set
	 */
	public void setPub_date(DateTime pub_date) {
		this.pub_date = pub_date;
	}

	/**
	 * @return the catalog_id
	 */
	public int getCatalog_id() {
		return catalog_id;
	}

	/**
	 * @param catalog_id the catalog_id to set
	 */
	public void setCatalog_id(int catalog_id) {
		this.catalog_id = catalog_id;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
    
}
