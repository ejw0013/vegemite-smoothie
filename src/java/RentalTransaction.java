import java.time.Instant;

public class RentalTransaction implements Transaction{
  private PatronAccount patron;
  private MediaItem item;
  private long time;
  private int status;
  private int id;
  private int numRenewals;

  public RentalTransaction(final PatronAccount patron, final MediaItem item, final int id){
    this.item = item;
    this.patron = patron;
    this.id = id;
    this.time = Instant.now().getEpochSecond();
    status = 1;
    numRenewals = 0;
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

  public MediaItem getItem(){
    return item;
  }
  public int getStatus(){
    return status;
  }

  public int getId(){
    return id;
  }

  public int getNumRenewals(){
    return numRenewals;
  }

}
