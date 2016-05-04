package com.veggie.src.java;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.database.*;
import com.veggie.src.java.core.*;
import com.veggie.src.java.core.media.MediaItem;
import com.veggie.src.java.core.media.MediaTitle;

import java.util.List;
import java.util.Set;

public class AddItemController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form addItemForm;
	private TitleDatabaseManager manager;
	private int titleStatus;

	//Methods
	public AddItemController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("ISBN");
		builder.addField("Title");
		builder.addField("Author");
		builder.addField("Description");
		addItemForm = builder.getResult();
		manager = AbstractDatabaseManagerFactory.getInstance().createTitleDatabaseManager();
	}

	public Form clickAddItemButton() {
	  return addItemForm;
	}

	public Notification submitForm() {
		List<String> formData = addItemForm.getData();
		titleStatus = manager.checkTitle(formData.get(0), addItemForm.getFieldNames(), formData);
		if (titleStatus == MediaTitle.INVALID_TITLE) {
			notification = AbstractNotificationFactory.getInstance().createErrorNotification("Invalid Title: Media title exists, but fields do not match");
		} else {
			notification = AbstractNotificationFactory.getInstance().createConfirmNotification("Confirm item addition?");
		}
		return notification;
	}

	public void respondToNotification() {
		if (notification instanceof AbstractErrorNotification) {
			if (notification.ok()) {
				List<String> formData = addItemForm.getData();
				MediaTitle title = new MediaTitle(0, "", "", "", "");
				if (titleStatus == MediaTitle.NEW_TITLE) {
					title = new MediaTitle(0, formData.get(0), formData.get(1), formData.get(2), formData.get(3));
					manager.addTitle(formData.get(0), title);
				} else if (titleStatus == MediaTitle.EXISTING_TITLE) {
					Set<MediaTitle> titleResults = manager.getMatches(addItemForm.getFieldNames(), formData);
					for (MediaTitle t : titleResults) {
						title = t;
					}
				}
				MediaItem newItem = new MediaItem(0, title);
			}
		}
	}

}
