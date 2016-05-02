package com.veggie.src.java;

public class AssistantAccount extends EmployeeAccount{
	public final String type = "AssistantAccount";

	public LibrarianAccount supervisor;

	public AssistantAccount(final String username, final String contactInformation, final int id,
													final int employeeId, final LibrarianAccount supervisor){
		super(username, contactInformation, id, employeeId);
		this.supervisor = supervisor;
	}


	public String getSupervisorName(){
		return supervisor.getusername();
	}

	public String getType(){
		return type;
	}
}
