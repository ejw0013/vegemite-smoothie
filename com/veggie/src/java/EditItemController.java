package com.veggie.src.java;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.database.*;

import java.util.List;

public class EditItemController implements Controller {

	//Instance Variables
	private int itemID;
	private Notification notification;
	private Form editItemForm;
	private ItemDatabaseManager manager;
	
	//Methods
	public EditItemController(int id) {
		itemID = id;
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Status");
		editItemForm = builder.getResult();
		manager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
	}
	
	public Form clickEditItemButton() {
		return editItemForm;
	}
	
	public Notification submitForm(Form form) {
		List<String> formData = editItemForm.getData();
		//TO DO
		return notification;
	}
	
	public void respondToNotification(Notification notif) {
		//TO DO
	}

}