package com.veggie.src.java.controllers.transaction;
import java.util.List;

import com.veggie.src.java.controllers.Controller;
import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.TransactionDatabaseManager;

public class CancelReservationController implements Controller
{
  private AbstractFormBuilder formBuilder;
  private Form form;
  Notification notification;

  public CancelReservationController()
  {
    formBuilder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
    formBuilder.addField("User ID");
    formBuilder.addField("Item ID");
    form = formBuilder.getResult();
  }

  public Form activate()
  {
    return form;
  }

  public Notification submitForm()
  {
      List<String> formData = form.getData();
      int itemid;
      int userid;
      try{
      	userid = Integer.parseInt(formData.get(0));
      	itemid = Integer.parseInt(formData.get(1));
      	TransactionDatabaseManager transactionDBManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
      transactionDBManager.finalizeReservation(userid, itemid);
      }catch(Exception e){
      	System.out.println("Error: incorrect form data");
      }

      return notification;   //???????
  }
  
  public void respondToNotification() {
    //TO DO
  }
}
