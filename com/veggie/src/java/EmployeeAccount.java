package com.veggie.src.java;

public abstract class EmployeeAccount extends Account{
	private int employeeId;

	public EmployeeAccount(final String username, final String contactInformation, final int id, final int employeeId){
		super(username, contactInformation, id);
		this.employeeId = employeeId;
	}

	public int getEmployeeId(){
		return employeeId;
	}

	public abstract String getType();

}
