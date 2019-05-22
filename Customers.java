import java.sql.*;
import java.util.Scanner;

public class Customers implements Operations{
    SetupConnection connection = new SetupConnection();
    Scanner scan = new Scanner(System.in);


	public void insert(User user){
        //Inserts the created user into mySQL database

        //Log every insetion

        //Exceptions from failure to insert must be handled.
	}

	public void update(int ssn){
        //Updates an existing user in the mySQL database
        ResultSet rs = connection.writeQuery("Select * from Users where ssn = " + ssn);
        printAll(rs);

        System.out.println("Please enter the first name: ");
        String fn = scan.nextLine();

        System.out.println("Please enter the last name: ");
        String ln = scan.nextLine();

        System.out.println("Please enter the age: ");
        int age = scan.nextInt();
        scan.nextLine();

        System.out.println("Please enter the email: ");
        String email = scan.nextLine();

        connection.updateQuery("UPDATE Users SET first_name = '" + fn + "', last_name = '" + ln 
                    + "', age = '" + age + "', ssn = '" +  ssn + "', email = '" + email + "' WHERE ssn = '" + ssn + "'");
        
	}

	public void delete(int ssn){

        SetupConnection connection = new SetupConnection();
        String query = "DELETE from Users where ssn = '"+ssn+"' ";
        connection.writeQuery(query);



        //Deletes an existing user in the mySQL database
        
        //Log every deletion
        
        //Exceptions from failure to delete records must be handled.
	}

	public void printAll(ResultSet rs){
        //Prints all the users in the mySQL database
        try{
            while(rs.next()){
                System.out.println("-------------------------------------------------------------------");
				System.out.println(rs.getString(1) + " " +rs.getString(2) 
					+ " " + rs.getInt(3)  + " " + rs.getInt(4)  + " " + rs.getString(5) );
                System.out.println("-------------------------------------------------------------------");
            }
        }catch(Exception e){
            System.out.println(e);
        }
	}
}