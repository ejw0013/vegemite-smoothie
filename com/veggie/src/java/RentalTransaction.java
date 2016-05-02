package com.veggie.src.java;

import java.time.Instant;

public class RentalTransaction extends Transaction {

  private MediaItem item;
  private int numRenewals;

  public RentalTransaction(final PatronAccount patron, final MediaItem item, final int id){
    this.item = item;
    this.patron = patron;
    this.id = id;
    this.time = Instant.now().getEpochSecond();
    status = 1;
    numRenewals = 0;
  }

  public MediaItem getItem(){
    return item;
  }

  public int getNumRenewals(){
    return numRenewals;
  }

}
