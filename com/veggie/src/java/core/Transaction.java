package com.veggie.src.java.core;

import com.veggie.src.java.core.account.PatronAccount;

public abstract class Transaction{

	public static final int INACTIVE = 0;
	public static final int ACTIVE = 1;

	protected PatronAccount patron;
	protected long time;
	protected int status;
	protected int id;

	public PatronAccount getPatronAccount() {
		return patron;
	}

	public final long getTime() {
		return time;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final int getStatus() {
		return status;
	}

	public final void resolve() {
		status = INACTIVE;
	}

	public abstract String toString();
}
