package com.veggie.src.java.controllers.transaction;
import java.util.List;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.notification.AbstractNotificationFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.TransactionDatabaseManager;
import com.veggie.src.java.database.ItemDatabaseManager;

public class ReturnController implements Controller
{
  private AbstractFormBuilder formBuilder;
  private int itemid;

  public ReturnController(){}

  public Form activate()
  {
    formBuilder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
    formBuilder.addField("Item ID");
    return formBuilder.getResult();
  }

  public Notification submitForm(Form form)
  {
    Notification notification;
    List<String> formData = form.getData();
    try{
    	itemid = Integer.parseInt(formData.get(0));
    	TransactionDatabaseManager transactionDBManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
      ItemDatabaseManager itemDBManager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
      if(itemDBManager.getItem(itemid) == null){
        return AbstractNotificationFactory.getInstance().createErrorNotification("Error item does not exist!");
      }
      transactionDBManager.finalizeTransaction(itemid);
      notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Item sucessfully returned!");
    }catch(Exception e){
    	notification = AbstractNotificationFactory.getInstance().createErrorNotification("Error form data failure");
    }

    return notification;   //???????
  }

  public void respondToNotification(Notification notif) {
    //TO DO
  }

}
