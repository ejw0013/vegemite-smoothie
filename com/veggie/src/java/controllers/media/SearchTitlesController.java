package com.veggie.src.java.controllers.media;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;
import com.veggie.src.java.database.*;
import com.veggie.src.java.core.media.MediaTitle;

import java.util.List;
import java.util.Set;

public class SearchTitlesController implements Controller {

	//Instance Variables
	private Notification notification;
	private Form searchTitlesForm;
	private ItemDatabaseManager manager;
    private TitleDatabaseManager titleManager;

	//Methods
	public SearchTitlesController() {
		AbstractFormBuilder builder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
		builder.addField("title");
        builder.addField("author");
        builder.addField("ISBN");
		searchTitlesForm = builder.getResult();
		manager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
        titleManager = AbstractDatabaseManagerFactory.getInstance().createTitleDatabaseManager();
	}

	public Form activate() {
		return searchTitlesForm;
	}

	public Notification submitForm(Form form) {
		searchTitlesForm = form;
		Set<MediaTitle> matches = titleManager.getMatches(form.getFieldNames(), form.getData());
        String matchString = "";
        for (MediaTitle matchTitle : matches) {
            matchString += matchTitle.toString() + "\n";
        }
        notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Matches: \n" + matchString);
		return notification;
	}

	public void respondToNotification(Notification notif) {

	}

}
