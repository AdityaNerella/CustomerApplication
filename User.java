public class User{
	private String first_name, last_name, email;
	private int age, ssn;
	
	User(String first, String last, int age, int ssn, String email){
		this.first_name = first;
		this.last_name = last;
		this.email = email;
		this.age = age;
		this.ssn = ssn;
	}

	public void setFirst(String fname){
		this.first_name = fname;
	}
	
	public String getFirst(){
		return first_name;
	}

	public void setLast(String lname){
		this.last_name = lname;
	}
	
	String getLast(){
		return last_name;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public void setSsn(int ssn){
		this.ssn = ssn;
	}

	public int getSsn(){
		return ssn;
	}

	public String toString(){
		return "Name: " + first_name + " " + last_name + " Email: " + email + " Age: "
			+ age + " ssn: " + ssn;
 	}
}