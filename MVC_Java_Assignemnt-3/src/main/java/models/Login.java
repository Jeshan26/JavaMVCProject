package models;


/*
 * @author - Jeshan Chhabra
 * @date -  Feb 8 , 2025
 * Description - This is model class for student.. has firstname...
 * 
 */

public class Login {

	private String firstname;
	private String password;
	
	
//	Setters for the login class to set the values
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//	Getters for the login class to get the values
	public String getFirstname() {
		return firstname;
	}
	
	public String getPassword() {
		return password;
	}
	
}
