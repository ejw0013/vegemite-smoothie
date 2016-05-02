package com.veggie.src.java;

import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;

public class CancelReservationController implements Controller
{
  private AbstractFormBuilder fb;
  private Form f;

  public CancelReservationController()
  {
    fb = AbstractFormBuilderFactory.getInstance().createFormBuilder();
  }

  public Form createForm()
  {
    return f;
  }

}
