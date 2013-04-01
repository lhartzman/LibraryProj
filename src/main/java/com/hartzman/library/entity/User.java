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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
 
@Entity
@Table(name="users")
public class User {
     
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

   
}
