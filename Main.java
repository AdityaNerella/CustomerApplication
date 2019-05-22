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

        Customers customer = new Customers();

        boolean isExit = true;          
        while(isExit){

            System.out.println("Please enter your choice: \n 1) CREATE USER\n 2)UPDATE USER\n 3)DELETE USER\n4)SHOW USER\n5)EXIT");
            Scanner read = new Scanner(System.in);
            int choice = read.nextInt();

                switch (choice) {
                    // Create User
                    case 1: 
                        customer.insert();  
                        break;
                    // Update User
                    case 2:
                        customer.update();
                        break;
                    case 3:
                        customer.delete();
                        break;
                    case 4: 
                        System.out.println("User Information: ");
                        customer.printAll();
                        break;
                    case 5:
                        isExit = !isExit;
                        break;
                    default: 
                        System.out.println("Please Enter Valid input");
                    break;      
                }
            }

    }
}