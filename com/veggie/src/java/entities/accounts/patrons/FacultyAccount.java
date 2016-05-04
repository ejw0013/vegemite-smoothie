package com.veggie.src.java.entities.accounts.patrons;

import com.veggie.src.java.entities.accounts.PatronAccount;

public class FacultyAccount extends PatronAccount {

	public final String type = "FacultyAccount";
	private int facultyId;

	public FacultyAccount(final String username, final String contactInformation, final int id, final int facultyId, final String password){
		super(username, contactInformation, id, password);
		this.facultyId = facultyId;
	}

	public int getFacultyId(){
		return facultyId;
	}
	public String getType(){
		return type;
	}
}
