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
	private String type;

	public User(){

	}

	public User(String username, String password, String type){
		this.name = username;
		this.password = password;
		this.type = type;
	}
}//end User