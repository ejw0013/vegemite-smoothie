package com.veggie.src.java.entities.accounts.employees;

import com.veggie.src.java.entities.accounts.EmployeeAccount;

public class AssistantAccount extends EmployeeAccount {
	public final String type = "AssistantAccount";

	public AssistantAccount(final String username, final String contactInformation, final int id,
													final int employeeId, final String password){
		super(username, contactInformation, id, employeeId, password);
	}


	public String getType(){
		return type;
	}
}
