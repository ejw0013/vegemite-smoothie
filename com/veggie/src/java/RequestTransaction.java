package com.veggie.src.java;

import java.time.Instant;

public class RequestTransaction extends Transaction {

  private String description;

  public RequestTransaction(final PatronAccount patron, final String description, final int id){
    this.patron = patron;
    this.description = description;
    this.id = id;
    this.time = Instant.now().getEpochSecond();
    status = ACTIVE;
  }

  public String getDescription() {
    return description;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Request description: " + description);
    if(status == ACTIVE){
      sb.append("\t Waiting Librarian Attention");
    }else{
      sb.append("\t resolved");
    }
    return sb.toString();
  }
}
