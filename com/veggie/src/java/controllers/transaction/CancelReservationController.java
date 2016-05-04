package com.veggie.src.java.controllers.transaction;
import java.util.List;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.notification.AbstractNotificationFactory;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.TransactionDatabaseManager;
import com.veggie.src.java.database.AccountDatabaseManager;
import com.veggie.src.java.database.ItemDatabaseManager;
public class CancelReservationController implements Controller
{
  private AbstractFormBuilder formBuilder;
  private int itemid;
  private int userid;

  public CancelReservationController()
  {
  }

  public Form activate()
  {
    formBuilder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
    formBuilder.addField("User ID");
    formBuilder.addField("Item ID");
    return formBuilder.getResult();
  }

  public Notification submitForm(Form form)
  {
      List<String> formData = form.getData();
      Notification notification;
      try{
      	userid = Integer.parseInt(formData.get(0));
      	itemid = Integer.parseInt(formData.get(1));
        AccountDatabaseManager accountDBManager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
        ItemDatabaseManager itemDBManager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
        if(accountDBManager.getUser(userid) == null){
          return AbstractNotificationFactory.getInstance().createErrorNotification("User does not exist! ");
        }
        if(itemDBManager.getItem(itemid) == null){
          return AbstractNotificationFactory.getInstance().createErrorNotification("Item does not exist! ");
        }
        notification = AbstractNotificationFactory.getInstance().createConfirmNotification("Are you sure you want to cancel this reservation>");
      }catch(Exception e){
      	return AbstractNotificationFactory.getInstance().createErrorNotification("Error form data is incorrect!");
      }
      return notification;
  }
  
  public void respondToNotification(Notification notif) {
    if(notif.ok()){
      TransactionDatabaseManager transactionDBManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
      transactionDBManager.finalizeReservation(userid, itemid);
    }
  }
}
