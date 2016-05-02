package com.veggie.src.java;

import java.util.List;
import java.util.ArrayList;

public abstract class PatronAccount extends Account{
	private List<Transaction> transactions;

	public PatronAccount(final String username, final String contactInformation, final int id){
		super(username, contactInformation, id);
	}
	public abstract String getType();

	public List<Transaction> getTransactions(){
		return transactions;
	}
}
