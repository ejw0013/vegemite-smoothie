package com.veggie.src.java.controllers.transaction;
import java.util.List;

import com.veggie.src.java.notification.AbstractNotificationFactory;
import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.core.media.MediaItem;
import com.veggie.src.java.core.media.MediaTitle;
import com.veggie.src.java.core.account.PatronAccount;
import com.veggie.src.java.core.transaction.ReservationTransaction;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.TransactionDatabaseManager;
import com.veggie.src.java.database.AccountDatabaseManager;
import com.veggie.src.java.database.ItemDatabaseManager;

public class AddReservationController implements Controller
{
  private AbstractFormBuilder formBuilder;
  Notification notification;

  public AddReservationController()
  {
  }

  public Form activate()
  {
    formBuilder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
    formBuilder.addField("User ID");
    formBuilder.addField("Item ID");
    return formBuilder.getResult();
  }

  public Notification submitForm(final Form form)
  {
      List<String> formData = form.getData();
      int itemid;
      int userid;
      Notification notification;
      PatronAccount patron;
      MediaItem med;
      try{
      	userid = Integer.parseInt(formData.get(0));
      	itemid = Integer.parseInt(formData.get(1));
        AccountDatabaseManager accountDBManager = AbstractDatabaseManagerFactory.getInstance().createAccountDatabaseManager();
        if(accountDBManager.getUser(userid) != null){
          patron = (PatronAccount) accountDBManager.getUser(userid);
        }else{
          return AbstractNotificationFactory.getInstance().createErrorNotification("User does not exist! ");
        }
        ItemDatabaseManager itemDBManager = AbstractDatabaseManagerFactory.getInstance().createItemDatabaseManager();
        if(itemDBManager.getItem(itemid) != null){
            med = itemDBManager.getItem(itemid);
        }else{
          return AbstractNotificationFactory.getInstance().createErrorNotification("Media does not exist!");
        }
        MediaTitle name = med.getTitle();
        ReservationTransaction res = new ReservationTransaction(patron, name, 0);
      	TransactionDatabaseManager transactionDBManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
        notification = AbstractNotificationFactory.getInstance().createSuccessNotification("Reservation Added!");
      transactionDBManager.addTransaction(res);
      }catch(Exception e){
      	System.out.println("Error: incorrect form data");
        return AbstractNotificationFactory.getInstance().createErrorNotification("Incorrect userID or itemID");
      }
      return notification;   //???????
  }

  public void respondToNotification(Notification notif) {
  }
}
