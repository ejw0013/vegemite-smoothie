package com.veggie.src.java.core.transactions;

import com.veggie.src.java.core.Transaction;
import com.veggie.src.java.core.account.PatronAccount;
import com.veggie.src.java.core.media.MediaTitle;

import java.time.Instant;

public class ReservationTransaction extends Transaction {

  private MediaTitle title;

  public ReservationTransaction(final PatronAccount patron, final MediaTitle title, final int id){
    this.title = title;
    this.patron = patron;
    this.id = id;
    this.time = Instant.now().getEpochSecond();
    status = ACTIVE;
  }

  public MediaTitle getTitle() {
    return title;
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Reservation for: ");
    sb.append(title.getTitle() + "\t");
    sb.append("Time submitted: " + time + "\t");
    if(status == ACTIVE){
      sb.append("Active");
    }else{
      sb.append("Inactive");
    }
    return sb.toString();
  }
}
