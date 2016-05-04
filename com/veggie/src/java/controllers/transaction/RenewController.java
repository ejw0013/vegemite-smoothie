package com.veggie.src.java.controllers.transaction;

import java.util.List;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.core.media.MediaItem;
import com.veggie.src.java.core.account.PatronAccount;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.notification.AbstractNotificationFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.TransactionDatabaseManager;
import com.veggie.src.java.database.AccountDatabaseManager;
import com.veggie.src.java.database.ItemDatabaseManager;
import com.veggie.src.java.core.transaction.RentalTransaction;

public class RenewController implements Controller
{
  private AbstractFormBuilder formBuilder;
  private int itemid;
  private int userid;

  public RenewController(){}

  public Form activate()
  {
    formBuilder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
    formBuilder.addField("User ID");
    formBuilder.addField("Item ID");
    return formBuilder.getResult();
  }

  public Notification submitForm(Form form)
  {
    PatronAccount patron;
    Notification notification;
    MediaItem med;
    List<String> formData = form.getData();
    try{
      userid = Integer.parseInt(formData.get(0));
      itemid = Integer.parseInt(formData.get(1));
      ItemDatabaseManager itemDBManager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
      TransactionDatabaseManager transactionDBManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
      if(itemDBManager.getItem(itemid) == null){
        return AbstractNotificationFactory.getInstance().createErrorNotification("Error item does not exist!"); 
      }
      AccountDatabaseManager accountDBManager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
      patron = (PatronAccount)accountDBManager.getUser(userid);
      if(patron == null){
        return AbstractNotificationFactory.getInstance().createErrorNotification("Error patron does not exist! "); 
      }
      transactionDBManager.finalizeTransaction(itemid);
      med = itemDBManager.getItem(itemid);
      RentalTransaction rent = new RentalTransaction(patron, med, 0);
      transactionDBManager.addTransaction(rent);
      notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Checkout Renewed!"); 
    }catch(Exception e){
      notification = AbstractNotificationFactory.getInstance().createErrorNotification("Form data is incorrect!"); 
    }

    return notification;   //???????

  }

  public void respondToNotification(Notification notif) {
    //TO DO
  }


}
