public class LibrarianAccount extends EmployeeAccount{

	public final String type = "LibrarianAccount";

	public LibrarianAccount(final String userName, final String contactInformation, final int id, final int employeeId){
		super(userName, contactInformation, id, employeeId);
	}

	public String getType(){
		return type;
	}
}