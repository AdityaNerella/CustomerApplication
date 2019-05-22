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

        SetupConnection connection = new SetupConnection();
        String query = "DELETE from Users where ssn = '"+ssn+"' ";
        connection.writeQuery(query);



        //Deletes an existing user in the mySQL database
        
        //Log every deletion
        
        //Exceptions from failure to delete records must be handled.
	}

	public void printAll(){
        //Prints all the users in the mySQL database
	}
}