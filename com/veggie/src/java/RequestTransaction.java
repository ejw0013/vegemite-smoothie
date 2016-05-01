package com.veggie.src.java;

import java.time.Instant;

public class RequestTransaction implements Transaction{
  private PatronAccount patron;
  private String description;
  private long time;
  private int status;
  private int id;

  public RequestTransaction(final PatronAccount patron, final String description, final int id){
    this.patron = patron;
    this.description = description;
    this.id = id;
    this.time = Instant.now().getEpochSecond();
    status = 1;
  }

  public void resolve(){
    status = 0;
  }
  public PatronAccount getPatronAccount(){
    return patron;
  }

  public long getTime(){
    return time;
  }

  public String getDescription(){
    return description;
  }
  public int getStatus(){
    return status;
  }
  public int getId(){
    return id;
  }
}
