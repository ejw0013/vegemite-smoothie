package com.veggie.src.java.entities.accounts.patrons;

import com.veggie.src.java.entities.accounts.PatronAccount;

public class GraduateStudentAccount extends PatronAccount {

	public final String type = "GraduateStudentAccount";
	private int studentId;

	public GraduateStudentAccount(final String username, final String contactInformation, final int id, final int studentId, String password){
		super(username, contactInformation, id, password);
		this.studentId = studentId;
	}

	public int getStudentId(){
		return studentId;
	}
	public String getType(){
		return type;
	}
}
