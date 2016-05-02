package com.veggie.src.java;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;

public class AddItemController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form addItemForm;
	
	//Methods
	public AddItemController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Title");
		builder.addField("Author");
		builder.addField("ISBN");
		builder.addField("Description");
		addItemForm = builder.getResult();
	}
	
	public Form clickAddItemButton() {
	  return null;
	}
	
	public Notification submitForm() {
		return null;
	}
	
	public void respondToNotification() {
	
	}

}