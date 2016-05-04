package com.veggie.src.java.controllers.media;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.database.*;

import java.util.List;

public class RemoveItemController implements Controller {

	//Instance Variables
	private int itemID;
	private Notification notification;
	private Form removeItemForm;
	private ItemDatabaseManager manager;

	//Methods
	public RemoveItemController(int id) {
		itemID = id;
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Status");
		removeItemForm = builder.getResult();
		manager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
	}

	public Form activate() {
		return removeItemForm;
	}

	public Notification submitForm(Form form) {
		List<String> formData = removeItemForm.getData();
		//TO DO
		return notification;
	}

	public void respondToNotification(Notification notif) {
		//TO DO
	}

}
