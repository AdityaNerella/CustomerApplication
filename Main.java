import java.sql.*;

public class Main{
    public static void main(String [] args){
        // Establish Database Connection using JDBC
        
        SetupConnection connection = new SetupConnection();
        ResultSet rs = connection.writeQuery("Select * from Users");
        /* try{
            while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3) 
					+ " " + rs.getInt(4)  + " " + rs.getInt(5)  + " " + rs.getString(6) );
            }
        }catch(Exception e){
            System.out.println(e);
        } */
        connection.closeConnection();
        // Write Switch statements to allow user to choose the operation to perform

    }
}