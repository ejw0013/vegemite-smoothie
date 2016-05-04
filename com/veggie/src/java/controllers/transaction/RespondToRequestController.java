package com.veggie.src.java.controllers.transaction;

import java.util.*;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.database.*;
import com.veggie.src.java.controllers.Controller;

public class RespondToRequestController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form respondForm;
	private TransactionDatabaseManager manager;

	//Methods
	public RespondToRequestController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Request ID");
		builder.addField("Response");
		respondForm = builder.getResult();
		manager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
	}

	public Form activate() {
		return respondForm;
	}

	public Notification submitForm(Form form) {
		respondForm = form;
		List<String> formData = respondForm.getData();
		if (!(manager.requestExists(Integer.parseInt(formData.get(0))))) {
			notification = AbstractNotificationFactory.getInstance().createErrorNotification("Request does not exist");
		} else {
			notification = AbstractNotificationFactory.getInstance().createConfirmNotification("Proceed with request response?");
		}
		return notification;
	}

 	public void respondToNotification(Notification notif) {
    if (notif.ok()) {
			List<String> formData = respondForm.getData();
			manager.finalizeTransaction(Integer.parseInt(formData.get(0)));
		}
  }

}
