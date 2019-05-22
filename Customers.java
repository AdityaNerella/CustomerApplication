public class Customers implements Operations{

	public void insert(User user){
        //Inserts the created user into mySQL database
        
        User myObj = new User(System.in);
        System.out.println("Enter firstName");
        String firstName=myObj.getFirst();
        firstName.nextLine();

        System.out.println("Enter lastName");
        String lastName=myObj.getLast();
        lastName.nextLine();

        System.out.println("Enter Email id");
        String email=myObj.getEmail();
        email.nextLine();

        System.out.println("Enter age");
        String age=myObj.getAge();
        age.nextInt();
        age.nextLine();

        System.out.println("Enter ssn");
        String ssn=myObj.getSsn();
        ssn.nextLine();

        SetupConnection();

       // writeQuery(select * from Users_table);
       // writeQuery(INSERT INTO `Users_table`(`firstName`,`lastName`,`age`,`ssn`,`email`) VALUES (firstName,lastName,age,ssn,email);)
        

        //Exceptions from failure to insert must be handled.
	}

	public void update(int ssn){
        //Updates an existing user in the mySQL database

        //Log every update
        
        //Exceptions from failure to update must be handled.
	}

	public void delete(int ssn){
        //Deletes an existing user in the mySQL database
        
        //Log every deletion
        
        //Exceptions from failure to delete records must be handled.
	}

	public void printAll(){
        //Prints all the users in the mySQL database
	}
}