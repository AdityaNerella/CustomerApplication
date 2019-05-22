import java.sql.*;
import java.util.Scanner;

public class Customers implements Operations{
    SetupConnection connection;
    Scanner scan;

    Customers(){
        connection = new SetupConnection();
        scan = new Scanner(System.in);
    }

	public void insert(User user){
        //Inserts the created user into mySQL database
        
        Scanner myObj = new Scanner(System.in);
        //User u=new User();

        System.out.println("Enter firstName");
        String firstName=myObj.nextLine();
        user.getFirst(firstName);
        

        System.out.println("Enter lastName");
        String lastName=myObj.nextLine();
        user.getLast(lastName);

        System.out.println("Enter Email id");
        String email=myObj.nextLine();
        user.getEmail(email);

        System.out.println("Enter age");
        String age=myObj.nextInt();
        myObj.nextLine();
        user.getAge(age);
        

        System.out.println("Enter ssn");
        String ssn=myObj.nextLine();
        user.getSsn(ssn);
        

        //SetupConnection();

       // writeQuery(select * from Users_table);
       // writeQuery(INSERT INTO `Users_table`(`firstName`,`lastName`,`age`,`ssn`,`email`) VALUES (firstName,lastName,age,ssn,email);)
        

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