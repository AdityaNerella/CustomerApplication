import java.sql.*;

public class Main{
    public static void main(String [] args){
        // Establish Database Connection using JDBC
        
        SetupConnection connection = new SetupConnection();
        ResultSet rs = connection.writeQuery("Select * from Users");
        try{
            while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3) 
					+ " " + rs.getInt(4)  + " " + rs.getInt(5)  + " " + rs.getString(6) );
            }
        }catch(Exception e){
            System.out.println(e);
        }
        connection.closeConnection();
        // Write Switch statements to allow user to choose the operation to perform

    }

    void mainInsert(){
        User u=new User(first,last,email,age,ssn);
        Customers c=new Customer();
        c.insert(u);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter firstName");
        String firstName=myObj.nextLine();
        
        
        System.out.println("Enter lastName");
        last=myObj.nextLine();
       
        System.out.println("Enter Email id");
        String email=myObj.nextLine();
        
        System.out.println("Enter age");
        int age=myObj.nextInt();
        myObj.nextLine();
        
        System.out.println("Enter ssn");
        String ssn=myObj.nextLine();
        connection.writeQuery("insert into Users(firstName,lastName,age,ssn,email) values (first,last,age,ssn,email)")
    }
}