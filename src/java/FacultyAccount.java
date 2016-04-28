public class FacultyAccount extends PatronAccount{

	public final String type = "FacultytAccount";
	private int facultyId;

	public FacultyAccount(final String userName, final String contactInformation, final int id, final int facultyId){
		super(userName, contactInformation, id);
		this.facultyId = facultyId;
	}

	public int getFacultyId(){
		return facultyId;
	}
	public String getType(){
		return type;
	}
}
