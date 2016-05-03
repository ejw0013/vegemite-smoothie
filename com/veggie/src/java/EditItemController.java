package com.veggie.src.java;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;

public class EditItemController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form editItemForm;
	
	//Methods
	public EditItemController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Status");
		editItemForm = builder.getResult();
	}
	
	public Form clickEditItemButton() {
		return editItemForm;
	}
	
	public Notification submitForm(Form form) {
		return null;
	}
	
	public void respondToNotification(Notification notif) {
		
	}

}