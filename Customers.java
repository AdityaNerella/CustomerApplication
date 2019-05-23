import java.sql.*;
import java.util.Scanner;

public class Customers implements Operations{
    SetupConnection connection;
    Scanner scan;

    ArrayList<User> customers = new ArrayList<User>();

    Customers(){
        connection = new SetupConnection();
        scan = new Scanner(System.in);
    }

	public void insert(){
        //Inserts the created user into mySQL database
        
        Scanner myObj = new Scanner(System.in);
        //User u=new User();

        System.out.println("Enter firstName");
        String firstName=myObj.nextLine();

        System.out.println("Enter lastName");
        String lastName=myObj.nextLine();

        System.out.println("Enter Email id");
        String email=myObj.nextLine();

        System.out.println("Enter age");
        int age=myObj.nextInt();
        

        System.out.println("Enter ssn");
        int ssn=myObj.nextInt();

        connection.updateQuery("INSERT INTO `Users` VALUES ('" + firstName + "','" + lastName + 
                "',"+ age + ","+ ssn + ",'" + email + "')");

        updateCustomers();
                        
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

        updateCustomers();
        
	}

	public void delete(int ssn){
        String query = "DELETE from Users where ssn = '"+ssn+"' ";
        connection.updateQuery(query);
        updateCustomers();
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
           updateCustomers();

           if(customers.size() >= 1){
                for(int i=0; i<customers.size(); i++){
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Customers: "+"\n" + customers.get(i).toString());
                }    
                System.out.println("-------------------------------------------------------------------");
            }
            else{
                System.out.println("NO USERS AVAILABLE");
            }
        }
        }catch(Exception e){
            System.out.println(e);
        }
	}
}