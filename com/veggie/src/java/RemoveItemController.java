package com.veggie.src.java;

import com.veggie.src.java.form.*;
import com.veggie.src.java.notification.*;

public class RemoveItemController implements Controller {

	//Instance Variables
	private int itemID;
	private Notification notification;
	
	//Methods
	public RemoveItemController(int id) {
		itemID = id;
	}
	
	public Notification clickRemoveItemButton() {
		//TO DO
		return notification;
	}
	
	public void respondToNotification(Notification notif) {
		//TO DO
	}

}