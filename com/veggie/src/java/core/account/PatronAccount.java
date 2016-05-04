package com.veggie.src.java.core.account;

import com.veggie.src.java.core.Account;
import com.veggie.src.java.core.Transaction;

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
