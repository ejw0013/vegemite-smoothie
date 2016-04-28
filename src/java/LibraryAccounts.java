import java.util.List;

public class LibraryAccounts{

  private static LibraryAccounts instance = null;
  private List<PatronAccount> patrons;
  private List<EmployeeAccount> employees;

  protected LibraryAccounts(){}
  public static LibraryAccounts getInstace(){
    if(instance == null){
      instance = new LibraryAccounts();
    }
    return instance;
  }
  public List<PatronAccount> getPatrons(){
    return patrons;
  }
  public List<EmployeeAccount> getEmployees(){
    return employees;
  }
}
