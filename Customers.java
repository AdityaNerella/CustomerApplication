public class Customers implements Operations{


	public void insert(User user){
        //Inserts the created user into mySQL database

        //Log every insetion

        //Exceptions from failure to insert must be handled.
	}

	public void update(int ssn){
        //Updates an existing user in the mySQL database

        //Log every update
        
        //Exceptions from failure to update must be handled.
	}

	public void delete(int ssn){

        String query = "DELETE from Users where ssn = '"+ssn+"' ";
        connection.updateQery(query);
        System.out.println("User deleted successfully");

	}

	public void printAll(){
        //Prints all the users in the mySQL database
	}
}