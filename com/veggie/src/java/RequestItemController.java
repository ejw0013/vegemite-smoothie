package com.veggie.src.java;

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
	
	public Form clickRequestItemButton() {
		return null;
	}
	
	public Notification submitForm(Form form) {
		return null;
	}
	
	public void respondToNotification(Notification notif) {
	
	}
	
	public void notifyUser() {
	
	}

}