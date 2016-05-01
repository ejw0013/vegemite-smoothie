package com.veggie.src.java;

import com.veggie.src.java.form.Form;
import com.veggie.src.java.form.AbstractFormBuilder;
import com.veggie.src.java.form.AbstractFormBuilderFactory;

public class ReturnController implements Controller
{
  AbstractFormBuilderFactory fbf;
  AbstractFormBuilder fb;
  Form f;

  public ReturnController()
  {

  }

  public Form createForm()
  {
    return f;
  }

}
