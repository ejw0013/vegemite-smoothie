package com.veggie.src.java.controllers.transaction;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.controllers.*;
import com.veggie.src.java.database.*;
import com.veggie.src.java.core.*;
import com.veggie.src.java.core.account.*;
import com.veggie.src.java.core.transaction.*;

import java.util.List;

public class RequestItemController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form requestItemForm;
	private TransactionDatabaseManager transactionManager;
	private AccountDatabaseManager accountManager;

	//Methods
	public RequestItemController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Account ID");
		builder.addField("Description");
		requestItemForm = builder.getResult();
		transactionManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
		accountManager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
	}

	public Form activate() {
		return requestItemForm;
	}

	public Notification submitForm(Form form) {
		requestItemForm = form;
		notification = AbstractNotificationFactory.getInstance().createConfirmNotification("Proceed with item request?");
		return null;
	}

	public void respondToNotification(Notification notif) {
		if (notif.ok()) {
			List<String> formData = requestItemForm.getData();
			PatronAccount user = (PatronAccount) accountManager.getUser(Integer.parseInt(formData.get(0)));
			RequestTransaction newRequest = new RequestTransaction(user, formData.get(1), 0);
			transactionManager.addTransaction(newRequest);
		}
	}


}
