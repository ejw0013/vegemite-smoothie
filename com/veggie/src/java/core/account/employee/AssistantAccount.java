package com.veggie.src.java.core.account.employee;

import com.veggie.src.java.core.account.EmployeeAccount;

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
