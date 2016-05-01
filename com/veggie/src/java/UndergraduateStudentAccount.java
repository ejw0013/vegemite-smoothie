package com.veggie.src.java;

public class UndergraduateStudentAccount extends PatronAccount{

	public final String type = "UndergraduateStudentAccount";
	private int studentId;

	public UndergraduateStudentAccount(final String userName, final String contactInformation, final int id, final int studentId){
		super(userName, contactInformation, id);
		this.studentId = studentId;
	}

	public int getStudentId(){
		return studentId;
	}
	public String getType(){
		return type;
	}
}
