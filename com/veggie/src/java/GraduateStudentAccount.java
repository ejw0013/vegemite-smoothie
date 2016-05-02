package com.veggie.src.java;

public class GraduateStudentAccount extends PatronAccount{

	public final String type = "GraduateStudentAccount";
	private int studentId;

	public GraduateStudentAccount(final String username, final String contactInformation, final int id, final int studentId){
		super(username, contactInformation, id);
		this.studentId = studentId;
	}

	public int getStudentId(){
		return studentId;
	}
	public String getType(){
		return type;
	}
}
