package com.veggie.src.java;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.database.*;
import com.veggie.src.java.MediaItem;
import com.veggie.src.java.MediaTitle;

import java.util.List;

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
		String isbn = formData.get(0);
		titleStatus = manager.checkTitle(isbn, addItemForm.getFieldNames(), formData);
		if (titleStatus == MediaTitle.INVALID_TITLE) {
			//TO DO
		} else {
			//TO DO
		}
		return notification;
	}
	
	public void respondToNotification() {
		//TO DO
	}

}