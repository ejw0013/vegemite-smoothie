package com.veggie.src.java;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;

public class RequestController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form requestForm;
	
	//Methods
	public RequestController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Title");
		builder.addField("Description");
		requestForm = builder.getResult();
	}
	
	public Form requestItem() {
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