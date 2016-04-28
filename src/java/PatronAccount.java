import java.util.List;
import java.util.ArrayList;

public abstract class PatronAccount extends Account{
	private List<Transaction> transactions;
	
	public PatronAccount(final String userName, final String contactInformation, final int id){
		super(userName, contactInformation, id);
	}
	public abstract String getType();

	public List<Transaction> getTransactions(){
		return transactions;
	}
}