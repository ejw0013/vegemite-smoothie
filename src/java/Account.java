
public abstract class Account{
	protected String userName;
	protected String contactInformation;
	protected int id;
	protected String password;

	public Account(final String userName, final String contactInformation, final int id){
		this.userName = userName;
		this.contactInformation = contactInformation;
		this.id = id;
	}
	
	public boolean passwordMatches(final String password){
		return this.password.equals(password);
	}

	public int getId(){
		return this.id;
	}

	public String getContactInformation(){
		return this.contactInformation;
	}

	public String getUserName(){
		return this.userName;
	}

	public abstract String getType();
}