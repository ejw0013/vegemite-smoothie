public abstract class EmployeeAccount extends Account{
	private int employeeId;

	public EmployeeAccount(final String userName, final String contactInformation, final int id, final int employeeId){
		super(userName, contactInformation, id);
		this.employeeId = employeeId;
	}

	public int getEmployeeId(){
		return employeeId;
	}

	public abstract String getType();

}