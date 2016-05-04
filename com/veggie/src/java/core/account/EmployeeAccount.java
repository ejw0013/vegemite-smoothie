package com.veggie.src.java.core.account;

import com.veggie.src.java.core.Account;

public abstract class EmployeeAccount extends Account {
	private int employeeId;

	public EmployeeAccount(final String username, final String contactInformation, final int id, final int employeeId, final String password){
		super(username, contactInformation, id, password);
		this.employeeId = employeeId;
	}

	public int getEmployeeId(){
		return employeeId;
	}

	public abstract String getType();

}
