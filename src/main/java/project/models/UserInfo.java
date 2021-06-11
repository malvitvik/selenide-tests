package project.models;

public class UserInfo {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String password;


	public UserInfo(String firstName, String lastName, String phoneNumber, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}


	public String firstName() {return firstName; }


	public String lastName() {return lastName; }


	public String phoneNumber() {return phoneNumber; }


	public String email() {return email; }


	public String password() {return password; }
}
