package com.veggie.src.java;

import java.time.Instant;

public class ReservationTransaction implements Transaction{
  private PatronAccount patron;
  private MediaTitle title;
  private long time;
  private int status;
  private int id;

  public ReservationTransaction(final PatronAccount patron, final MediaTitle title, final int id){
    this.title = title;
    this.patron = patron;
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

  public MediaTitle getTitle(){
    return title;
  }
  public int getStatus(){
    return status;
  }

  public int getId(){
    return id;
  }
}
