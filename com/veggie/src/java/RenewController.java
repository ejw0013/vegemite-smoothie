package com.veggie.src.java;

import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;

public class RenewController implements Controller
{
  private AbstractFormBuilderFactory fbf;
  private AbstractFormBuilder fb;
  private Form f;

  public RenewController()
  {

  }

  public Form createForm()
  {
    return f;
  }

}
