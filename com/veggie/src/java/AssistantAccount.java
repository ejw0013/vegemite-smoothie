package com.veggie.src.java;

public class AssistantAccount extends EmployeeAccount{
	public final String type = "AssistantAccount";

	public LibrarianAccount supervisor;

	public AssistantAccount(final String userName, final String contactInformation, final int id,
													final int employeeId, final LibrarianAccount supervisor){
		super(userName, contactInformation, id, employeeId);
		this.supervisor = supervisor;
	}


	public String getSupervisorName(){
		return supervisor.getUserName();
	}

	public String getType(){
		return type;
	}
}
