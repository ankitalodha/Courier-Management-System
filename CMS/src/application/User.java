package application;

public class User {

	//private Integer id;
	//private String username;
	private String password;
	//private Boolean admin;
	private String userID;
	
	public User() {
		//Empty Default constructor
	}
	
	public User(String userID, String password) {
		//this.id = id;
		this.userID = userID;
		this.password = password;
		//this.admin = admin;
	}

	//public Integer getId() {
		//return id;
	//}

	//public void setId(Integer id) {
		//this.id = id;
	//}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean isAdmin() {
		return null;
				//admin;
	}

	public void setAdmin(Boolean admin) {
		//this.admin = admin;
	}


}
