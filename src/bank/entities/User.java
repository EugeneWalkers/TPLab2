package bank.entities;


public class User {

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getType() {
		return type;
	}

	private String name;
	private String password;

	public void setType(String type) {
		this.type = type;
	}

	private String type;

	public User(){

	}

	public User(String username, String password){
		this.name = username;
		this.password = password;
	}
}//end User