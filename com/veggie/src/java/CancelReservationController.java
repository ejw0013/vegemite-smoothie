package com.veggie.src.java;
import java.util.List;

import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.prototype.PrototypeAccountDatabaseManager;
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
    formBuilder.addField("Item ISBN");
    form = formBuilder.getResult();
  }

  public Form createForm()
  {
    return form;
  }

  public Notification submitForm()
  {
      List<String> formData = form.getData();
      String ISBN;
      int id;
      try{
      	id = Integer.parseInt(formData.get(0));
      	ISBN = formData.get(1);
      	TransactionDatabaseManager transactionDBManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
      transactionDBManager.finalizeReservation(id, ISBN);
      }catch(Exception e){
      	System.out.println("Error: incorrect form data");
      }
      
      return notification;   //???????
  }
}
