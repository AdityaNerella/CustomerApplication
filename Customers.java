import java.util.*;
import java.io.*;


public class Customers implements Operations{

	public void insert(User user){
        //Inserts the created user into mySQL database
        
        /*Scanner myObj = new Scanner(System.in);
        //User u=new User();

        System.out.println("Enter firstName");
        String firstName=myObj.nextLine();
        
       

        System.out.println("Enter lastName");
        String lastName=myObj.nextLine();
       
        System.out.println("Enter Email id");
        String email=myObj.nextLine();
        
        System.out.println("Enter age");
        int age=myObj.nextInt();
        myObj.nextLine();
        

        System.out.println("Enter ssn");
        String ssn=myObj.nextLine();
        */

        firstName=user.getFirst();
        lastName=user.getLast();
        email=user.getEmail();
        age=user.getAge();
        ssn=user.getSsn();

        

        //SetupConnection.SetupConnection();

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