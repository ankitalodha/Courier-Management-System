package application;

//import application.Main;
import application.User;
//import application.Main;
import application.RegistrationFormApplication;
import application.LoginDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Login {

	private static User user;

	@FXML
	private TextField custIdField;
	
	@FXML
	private TextField passField;
	
	@FXML
	private TextField error;
	
	public void login() {
		User u;
		String username = this.custIdField.getText();
		String password = this.passField.getText();
		//Validations
		if(username == null || username.trim().equals("")) {
			error.setText("Username Cannot be empty or spaces");
			return;
		}
		if(password == null || password.trim().equals("")) {
			error.setText("Password Cannot be empty or spaces");
			return;
		}
		//Get user
		LoginDao l = new LoginDao();
		u = l.findByUsername(username,password);
		//l.close();
		//If user not found
		if(u == null) {
			error.setText("Username cannot be found");
			return;
		}
		//If passwords dont match
		if(!(u.getPassword().equals(password.trim()))) {
			error.setText("Username and Password dont match");
			return;
		}
		//Set user as Logged in user
		user = u;
		try {
			AnchorPane root;
			//if(user.isAdmin()) {
				//If user is admin, inflate admin view
				//root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/Admin.fxml"));
			//}// else {
				//If user is customer, inflate customer view
				root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/Customer.fxml"));
			
			Scene scene = new Scene(root);
			RegistrationFormApplication.stage.setScene(scene);
			RegistrationFormApplication.stage.setTitle("Home");
		} catch(Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}

	public static User getUser() {
		return user;
	}
	
	public static void logout() {
		user = null;
	}
}

