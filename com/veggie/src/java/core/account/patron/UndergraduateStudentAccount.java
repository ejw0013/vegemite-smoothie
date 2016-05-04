package com.veggie.src.java.core.account.patron;

import com.veggie.src.java.core.account.PatronAccount;

public class UndergraduateStudentAccount extends PatronAccount {

	public final String type = "UndergraduateStudentAccount";
	private int studentId;

	public UndergraduateStudentAccount(final String username, final String contactInformation, final int id, final int studentId, final String password){
		super(username, contactInformation, id, password);
		this.studentId = studentId;
		this.permissions = UNDERGRADUATE_STUDENT;
	}

	public int getStudentId(){
		return studentId;
	}
	public String getType(){
		return type;
	}
		public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Username: " + username + " ");
		sb.append("Account type: " + type + " ");
		sb.append("Library ID: " + studentId);
		return sb.toString();
	}
}
