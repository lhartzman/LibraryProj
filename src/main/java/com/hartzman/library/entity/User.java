package com.hartzman.library.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 
@Entity
@Table(name="users", schema="library_schema")
public class User {
     
	public User(String firstname, String lastname, String email)
	{
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setLibraryCard(new LibraryCard());
	}
	
	public User()
	{}
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int user_id;
     
	private String firstname;
     
    private String lastname;
 
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="card_id")
    private LibraryCard libraryCard;
    
	@OneToMany
    private Set<LibraryItem> loanedItems;
    
    public String getFirstname() {
        return firstname;
    }
 
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
 
    public String getLastname() {
        return lastname;
    }
 
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }

	public Set<LibraryItem> getLoanedItems() {
		return loanedItems;
	}

	public void setLoanedItems(Set<LibraryItem> loanedItems) {
		this.loanedItems = loanedItems;
	}

    /**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public LibraryCard getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(LibraryCard libraryCard) {
		this.libraryCard = libraryCard;
	}

	@Override
	public boolean equals(Object obj)
	{
		User u = (User)obj;
		boolean result = false;
		if (u == this)
		{
			result = true;
		}
		else
		{
			if (u.getUser_id() == this.user_id && u.getFirstname().equals(this.getFirstname()) &&
					u.getLastname().equals(this.getLastname()) && u.getEmail().equals(this.getEmail()))
			{
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("User Id = ").append(this.getUser_id()).append(" Firstname = ").append(this.getFirstname()).
			append(" Lastname = ").append(this.getLastname()).append(" Email = ").append(this.getEmail());
		return sb.toString();
	}
   
}
