package com.veggie.src.java.controllers.media;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.database.*;

import java.util.List;

public class RemoveItemController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form removeItemForm;
	private ItemDatabaseManager manager;

	//Methods
	public RemoveItemController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Item ID");
		removeItemForm = builder.getResult();
		manager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
	}

	public Form activate() {
		return removeItemForm;
	}

	public Notification submitForm(Form form) {
		removeItemForm = form;
		notification = AbstractNotificationFactory.getInstance().createConfirmNotification("Proceed with item removal?");
		return notification;
	}

	public void respondToNotification(Notification notif) {
		if (notif.ok()) {
			List<String> formData = removeItemForm.getData();
			manager.removeItem(Integer.parseInt(formData.get(0)));
		}
	}

}
