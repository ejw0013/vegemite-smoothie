package com.veggie.src.java;
import java.util.List;

import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.notification.Notification;
import com.veggie.src.java.database.AbstractDatabaseManagerFactory;
import com.veggie.src.java.database.prototype.PrototypeAccountDatabaseManager;
import com.veggie.src.java.database.TransactionDatabaseManager;

public class ReturnController implements Controller
{
  private AbstractFormBuilder formBuilder;
  private Form form;
  Notification notification;

  public ReturnController()
  {
    formBuilder = AbstractFormBuilderFactory.getInstance().createFormBuilder();
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
      try{
      	itemid = Integer.parseInt(formData.get(0));
      	TransactionDatabaseManager transactionDBManager = AbstractDatabaseManagerFactory.getInstance().createTransactionDatabaseManager();
      transactionDBManager.finalizeTransaction(itemid);
      }catch(Exception e){
      	System.out.println("Error: incorrect form data");
      }

      return notification;   //???????
  }

}
