package com.veggie.src.java;

import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.PrototypeAccountDatabaseManager;

public class CancelReservationController implements Controller
{
  private AbstractFormBuilder formBuilder;
  private Form form;

  public CancelReservationController()
  {
    formBuilder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
    builder.addField("User ID");
    builder.addField("Item ISBN");
    form = formBuilder.getResult();
  }

  public Form createForm()
  {
    return form;
  }

  public void submitForm()
  {
  	  addAccountForm = form;
      List<String> formData = form.getData();
      String ISBN;
      int id;
      try{
      	id = Integer.parseInt(formData.get(0));
      	ISBN = formData.get(1);
      }catch(Exception e){
      	System.out.println("Error: incorrect form data");
      }
      TransactionDatabaseManager transactionDBManager = AbstractFormBuilderFactory.getInstace().createTransactionDatabaseManager();
      transactionDBManager.finalizeReservation(id, ISBN);
      return notification;   //???????
  }
}
