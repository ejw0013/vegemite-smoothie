package com.veggie.src.java.core;

import java.util.Map;
import java.util.HashMap;

public abstract class Account{
	protected String username;
	protected String contactInformation;
	protected int id;
	protected String password;
	protected Map<String, String> fields;
	protected int status;
	protected double fees;

	public static int ACTIVE = 1;
	public static int SUSPENDED = 0;
	public static int UNKNOWN = 0;
	public static int LIBRARIAN = 1;
	public static int ASSISTANT = 2;
	public static int FACULTY = 3;
	public static int GRADUATE_STUDENT = 4;
	public static int UNDERGRADUATE_STUDENT = 5;

	public Account(final String username, final String contactInformation, final int id, final String password){
		status = ACTIVE;
		this.username = username;
		this.contactInformation = contactInformation;
		this.id = id;
		this.password = password;
		fields = new HashMap<>();
		fields.put("username", username);
		fields.put("contactInformation", contactInformation);
		fields.put("id", id+"");
	}

	public boolean passwordMatches(final String password){
		return this.password.equals(password);
	}

	public int getId(){
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
		fields.put("id", id + "");
	}

	public String getContactInformation(){
		return this.contactInformation;
	}

	public String getusername(){
		return this.username;
	}

	public boolean fieldExists(String field) {
		return fields.containsKey(field);
	}

	public String getData(String field) {
		return fields.get(field);
	}

	public void setData(String field, String data) {
		fields.put(field, data);
	}

	public void suspend(){
		this.status = SUSPENDED;
	}

	public void reinstate(){
		this.status = ACTIVE;
	}

	public double getFees(){
		return this.fees;
	}

	public double payFees(double amountPaid){
		return this.fees -= amountPaid;
	}

	public double addFees(double feesAdded){
		return this.fees += feesAdded;
	}

	public boolean isActive(){
		return this.status == ACTIVE;
	}

	public boolean isSuspended(){
		return this.status == SUSPENDED;
	}
	public abstract String getType();
	public abstract String toString();
}
