package com.veggie.src.java.controllers.transaction;

import java.util.*;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.database.*;
import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.core.account.PatronAccount;
import com.veggie.src.java.core.transaction.RequestTransaction;
import com.veggie.src.java.core.Transaction;

public class ViewRequestController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form respondForm;
	private TransactionDatabaseManager manager;

	//Methods
	public ViewRequestController() {}

	public Form activate() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		return builder.getResult();
	}

	public Notification submitForm(Form form) {
		StringBuilder sb = new StringBuilder();
		TransactionDatabaseManager transactionDBManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
		List<Transaction> requestList = transactionDBManager.getRequests();
		for(Transaction transaction : requestList){
			RequestTransaction rtransaction = (RequestTransaction) transaction;
			sb.append("Request ID: " + rtransaction.getId() + " Patron Requesting: " + rtransaction.getPatronAccount().getusername());
			sb.append("Request description: " + rtransaction.getDescription() + "\n");
		}
		notification = AbstractNotificationFactory.getInstance().createSuccessNotification(sb.toString());
		return notification;
	}

 	public void respondToNotification(Notification notif) {}

}
