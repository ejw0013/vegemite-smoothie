package com.veggie.src.java.core.account.patron;

import com.veggie.src.java.core.account.PatronAccount;

public class GraduateStudentAccount extends PatronAccount {

	public final String type = "GraduateStudentAccount";
	private int studentId;

	public GraduateStudentAccount(final String username, final String contactInformation, final int id, final int studentId, String password){
		super(username, contactInformation, id, password);
		this.studentId = studentId;
		this.permissions = GRADUATE_STUDENT;
	}

	public int getStudentId(){
		return studentId;
	}
	public String getType(){
		return type;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Username: " + getusername() + " ");
		sb.append("Account type: " + getType() + " ");
		sb.append("Library ID: " + getStudentId());
		return sb.toString();
	}

}
