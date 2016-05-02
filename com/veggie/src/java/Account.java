package com.veggie.src.java;

import java.util.Map;
import java.util.HashMap;

public abstract class Account{
	protected String username;
	protected String contactInformation;
	protected int id;
	protected String password;
	protected Map<String, String> fields;


	public static int UNKNOWN = 0;
	public static int LIBRARIAN = 1;
	public static int ASSISTANT = 2;
	public static int FACULTY = 3;
	public static int GRADUATE_STUDENT = 4;
	public static int UNDERGRADUATE_STUDENT = 5;

	public Account(final String username, final String contactInformation, final int id){
		this.username = username;
		this.contactInformation = contactInformation;
		this.id = id;
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

	public abstract String getType();
}
