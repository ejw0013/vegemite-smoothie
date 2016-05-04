package com.veggie.src.java.entities.accounts;

import com.veggie.src.java.entities.Account;
import com.veggie.src.java.entities.Transaction;

import java.util.List;

public abstract class PatronAccount extends Account {
	private List<Transaction> transactions;

	public PatronAccount(final String username, final String contactInformation, final int id, final String password){
		super(username, contactInformation, id, password);
	}
	public abstract String getType();

	public List<Transaction> getTransactions(){
		return transactions;
	}
}
