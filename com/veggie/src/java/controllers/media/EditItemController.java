package com.veggie.src.java.controllers.media;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.database.*;
import com.veggie.src.java.core.media.MediaItem;

import java.util.List;

public class EditItemController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form editItemForm;
	private ItemDatabaseManager manager;

	//Methods
	public EditItemController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("Item ID");
		builder.addField("Status");
		editItemForm = builder.getResult();
		manager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
	}

	public Form activate() {
		return editItemForm;
	}

	public Notification submitForm(Form form) {
		editItemForm = form;
		notification = AbstractNotificationFactory.getInstance().createConfirmNotification("Proceed with edit?");
		return notification;
	}

	public void respondToNotification(Notification notif) {
		if (notif.ok()) {
			List<String> formData = editItemForm.getData();
			switch (Integer.parseInt(formData.get(1))) {
				case MediaItem.AVAILABLE:
					manager.markAvailable(Integer.parseInt(formData.get(0)));
					break;
				case MediaItem.UNAVAILABLE:
					manager.markUnavailable(Integer.parseInt(formData.get(0)));
					break;
				case MediaItem.RESERVED:
					manager.markReserved(Integer.parseInt(formData.get(0)));
					break;
			}
		}
	}

}
