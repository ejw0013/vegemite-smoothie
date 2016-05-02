package com.veggie.src.java;

import java.time.Instant;

public class RequestTransaction extends Transaction {

  private String description;

  public RequestTransaction(final PatronAccount patron, final String description, final int id){
    this.patron = patron;
    this.description = description;
    this.id = id;
    this.time = Instant.now().getEpochSecond();
    status = 1;
  }

  public String getDescription() {
    return description;
  }

}
