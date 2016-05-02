package com.veggie.src.java;

import java.time.Instant;

public class ReservationTransaction extends Transaction {

  private MediaTitle title;

  public ReservationTransaction(final PatronAccount patron, final MediaTitle title, final int id){
    this.title = title;
    this.patron = patron;
    this.id = id;
    this.time = Instant.now().getEpochSecond();
    status = 1;
  }

  public MediaTitle getTitle() {
    return title;
  }
}
