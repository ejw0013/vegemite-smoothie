package com.veggie.src.java.form;

public abstract class AbstractFormBuilderFactory {

    protected static AbstractFormBuilderFactory instance = null;

    public static AbstractFormBuilderFactory getInstance() {
        return instance;
    }

    public AbstractFormBuilder createFormBuilder() {
        return null;
    }
}
