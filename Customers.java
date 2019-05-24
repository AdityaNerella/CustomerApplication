import java.sql.*;
import java.util.*;

public class Customers implements Operations{
    ArrayList <User> customers = new ArrayList<User> ();

    SetupConnection connection;
    Scanner scan;
    Input input;

    Customers(){
        connection = SetupConnection.getConnection();
        scan = new Scanner(System.in);

        input = Input.getInput();
        System.out.println("input 1: " + input);
        Input input2 = Input.getInput();
        System.out.println("input 2: " + input2);
        Input input3 = Input.getInput();
        System.out.println("input 3: " + input3);

        System.out.println("\ncon 1: " + connection);
        SetupConnection con2 = SetupConnection.getConnection();
        System.out.println("con 2: " + con2);
        SetupConnection con3 = SetupConnection.getConnection();
        System.out.println("con 3: " + con3);
    }

	public void insert(){

        //Inserts the created user into mySQL database
        System.out.println("Enter firstName");
        String firstName=input.getScanString();

        System.out.println("Enter lastName");
        String lastName=input.getScanString();

        System.out.println("Enter Email id");
        String email=input.getScanString();

        System.out.println("Enter age");
        int age=input.getScanInteger();
        
        System.out.println("Enter ssn");
        int ssn=input.getScanInteger();


        //Inserts the created user into mySQL database
        connection.updateQuery("INSERT INTO `Users` VALUES ('" + firstName + "','" + lastName + 
                "',"+ age + ","+ ssn + ",'" + email + "')");
                        
	}

	public void update(int ssn){
        //Updates an existing user in the mySQL database
        ResultSet rs = connection.writeQuery("Select * from Users where ssn = " + ssn);
        printAll(rs);

        System.out.println("Please enter the first name: ");
        String fn = input.getScanString();

        System.out.println("Please enter the last name: ");
        String ln = input.getScanString();

        System.out.println("Please enter the age: ");
        int age = input.getScanInteger();


        System.out.println("Please enter the email: ");
        String email = input.getScanString();

        connection.updateQuery("UPDATE Users SET first_name = '" + fn + "', last_name = '" + ln 
                    + "', age = '" + age + "', ssn = '" +  ssn + "', email = '" + email + "' WHERE ssn = '" + ssn + "'");       
	}

	public void delete(int ssn){
        ResultSet rs = connection.writeQuery("Select * from Users where ssn = " + ssn);
        try{
            if(rs.next()){
             String query = "DELETE from Users where ssn = '"+ssn+"' ";
             connection.updateQuery(query);
           
            }else {
                System.out.println("No records available");
        	}
        }catch(Exception e){
                System.out.println(e);
        }
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
        
        }catch(Exception e){
            System.out.println(e);
        }
	}

    public void updateCustomers(){
        //Get ResultSet from DB
        try{
            ResultSet rs = connection.writeQuery("Select * from Users");
            customers.clear();
            while(rs.next()){
                 //Construct User from the ResultSet
				User u = new User(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5) );
                
                //Update Customers Array after each iteration. 
                customers.add(u);
            }
        }catch(Exception e){
            System.out.println(e);
        }
       
    }
}