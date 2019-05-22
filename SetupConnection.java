import java.sql.*;

public class SetupConnection{
    private Connection con;
    private Statement st;
    private ResultSet results;
    private Boolean connected = false;

    SetupConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Setup Successful.");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OLCustomers?serverTimezone=UTC", "root", "1997");
            System.out.println("Database Connection Successful.");
            connected = true;

            st = con.createStatement();
        }
        catch(Exception e){
            connected = false;
            System.out.println(e);
        }
    }

    public ResultSet writeQuery(String query){
        if(connected){
            try{
                    results = st.executeQuery(query);
                    System.out.println("Query Execution Successful.");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        return results;
    }

    public void closeConnection(){
        try{
            if(connected){
                connected = false;
                con.close();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public Boolean checkConnection(){
        return connected;
    }

}