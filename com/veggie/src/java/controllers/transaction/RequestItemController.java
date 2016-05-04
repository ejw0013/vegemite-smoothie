package com.veggie.src.java.controllers.transaction;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;

public class RequestItemController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form requestItemForm;

	//Methods
	public RequestItemController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Title");
		builder.addField("Description");
		requestItemForm = builder.getResult();
	}

	public Form activate() {
		//TO DO
		return null;
	}

	public Notification submitForm(Form form) {
		//TO DO
		return null;
	}

	public void respondToNotification(Notification notif) {
		//TO DO
	}


}
