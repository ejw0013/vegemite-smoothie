public class Main{
	public static void main(String[] args){
		EmployeeAccount ea = new LibrarianAccount("FooBarMan", "FooBarMan@library.com",1,1 );
		System.out.println(ea.getType());
	}
}