package com.veggie.src.java;

import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;
import com.veggie.src.java.form.Form;


public class AddReservationController implements Controller
{
  AbstractFormBuilderFactory fbf;
  AbstractFormBuilder fb;
  Form f;

  public AddReservationController()
  {

  }

  public Form createForm()
  {
    return f;
  }

}
