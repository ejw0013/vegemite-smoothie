package com.veggie.src.java;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;

public class EditController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form editForm;
	
	//Methods
	public EditController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Status");
		editForm = builder.getResult();
	}
	
	public Form editTitle() {
		return null;
	}
	
	public Notification submitForm(Form form) {
		return null;
	}
	
	public void respondToNotification(Notification notif) {
		
	}

}