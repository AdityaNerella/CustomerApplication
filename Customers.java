import java.sql.*;
import java.util.Scanner;

public class Customers implements Operations{
    SetupConnection connection;
    Scanner scan;

    Customers(){
        connection = new SetupConnection();
        scan = new Scanner(System.in);
    }

	public void insert(){
        //Inserts the created user into mySQL database

        System.out.println("Enter firstName");
        String firstName=Input.getScanString();

        System.out.println("Enter lastName");
        String lastName=Input.getScanString();

        System.out.println("Enter Email id");
        String email=Input.getScanString();

        System.out.println("Enter age");
        int age=Input.getScanInteger();
        
        System.out.println("Enter ssn");
        int ssn=Input.getScanInteger();

        connection.updateQuery("INSERT INTO `Users` VALUES ('" + firstName + "','" + lastName + 
                "',"+ age + ","+ ssn + ",'" + email + "')");
                        
	}

	public void update(int ssn){
        //Updates an existing user in the mySQL database
        ResultSet rs = connection.writeQuery("Select * from Users where ssn = " + ssn);
        printAll(rs);

        System.out.println("Please enter the first name: ");
        String fn = Input.getScanString();

        System.out.println("Please enter the last name: ");
        String ln = Input.getScanString();

        System.out.println("Please enter the age: ");
        int age = Input.getScanInteger();


        System.out.println("Please enter the email: ");
        String email = Input.getScanString();

        connection.updateQuery("UPDATE Users SET first_name = '" + fn + "', last_name = '" + ln 
                    + "', age = '" + age + "', ssn = '" +  ssn + "', email = '" + email + "' WHERE ssn = '" + ssn + "'");
        
	}

	public void delete(int ssn){
        String query = "DELETE from Users where ssn = '"+ssn+"' ";
        connection.updateQuery(query);
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

    public void printAll(){
        //Prints all the users in the mySQL database
        try{
            ResultSet rs = connection.writeQuery("Select * from Users");
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