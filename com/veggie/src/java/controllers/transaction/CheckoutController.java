package com.veggie.src.java.controllers.transaction;

import java.util.List;

import com.veggie.src.java.core.media.MediaItem;
import com.veggie.src.java.core.account.PatronAccount;
import com.veggie.src.java.core.transaction.RentalTransaction;
import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.TransactionDatabaseManager;
import com.veggie.src.java.database.AccountDatabaseManager;
import com.veggie.src.java.database.ItemDatabaseManager;
import com.veggie.src.java.notification.AbstractNotificationFactory;

public class CheckoutController implements Controller
{
  private AbstractFormBuilder formBuilder;
  private int itemid;
  private int userid;
  public CheckoutController(){}

  public Form activate()
  {
    formBuilder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
    formBuilder.addField("User ID");
    formBuilder.addField("Item ID");
    return formBuilder.getResult();
  }

  public Notification submitForm(Form form)
  {
    Notification notification;
    List<String> formData = form.getData();
    PatronAccount patron;
    MediaItem med;
    try{
      userid = Integer.parseInt(formData.get(0));
      itemid = Integer.parseInt(formData.get(1));
      AccountDatabaseManager accountDBManager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
      if(accountDBManager.getUser(userid) != null){
        patron = (PatronAccount)accountDBManager.getUser(userid);
      }else{
          return AbstractNotificationFactory.getInstance().createErrorNotification("User does not exist! ");
      }
      ItemDatabaseManager itemDBManager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
      if(itemDBManager.getItem(itemid) != null){
          med = itemDBManager.getItem(itemid);
      }else{
        return AbstractNotificationFactory.getInstance().createErrorNotification("Media does not exist!");
      }
      RentalTransaction rent = new RentalTransaction(patron, med, 0);
      TransactionDatabaseManager transactionDBManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
      transactionDBManager.addTransaction(rent);
      notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Media checked out!");
    }catch(Exception e){
      notification = AbstractNotificationFactory.getInstance().createErrorNotification("Form data error!");
    }

      return notification;   //???????
  }

  public void respondToNotification(Notification notif) {
    //TO DO
  }

}
