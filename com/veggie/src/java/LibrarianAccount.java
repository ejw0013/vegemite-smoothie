package com.veggie.src.java;

public class LibrarianAccount extends EmployeeAccount{

	public final String type = "LibrarianAccount";

	public LibrarianAccount(final String username, final String contactInformation, final int id, final int employeeId){
		super(username, contactInformation, id, employeeId);
	}

	public String getType(){
		return type;
	}
}
