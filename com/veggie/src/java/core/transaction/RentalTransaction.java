package com.veggie.src.java.core.transaction;

import com.veggie.src.java.core.Transaction;
import com.veggie.src.java.core.account.PatronAccount;
import com.veggie.src.java.core.media.MediaItem;

import java.time.Instant;

public class RentalTransaction extends Transaction {

  private MediaItem item;
  private int numRenewals;
  private long timeDue;
  public static long CHECKOUT_TIME = 604800;

  public RentalTransaction(final PatronAccount patron, final MediaItem item, final int id){
    this.item = item;
    this.patron = patron;
    this.id = id;
    this.time = Instant.now().getEpochSecond();
    this.timeDue = time + CHECKOUT_TIME;
    status = 1;
    numRenewals = 0;
  }

  public MediaItem getItem(){
    return item;
  }

  public int getNumRenewals(){
    return numRenewals;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Rental for: ");
    sb.append(item.getTitle() + "\t");
    sb.append("Time rented: " + time + "\t");
    sb.append("Time due: " + timeDue + "\t");
    if(status == ACTIVE){
      sb.append("Active");
    }else{
      sb.append("Inactive");
    }
    return sb.toString();
  }

  public long getDueDate(){
    return timeDue;
  }
}
