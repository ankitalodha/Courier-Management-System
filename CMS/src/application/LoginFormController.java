package application;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
//import java.util.Optional;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
//import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;


public class LoginFormController extends LoginDao implements Initializable{
	
	
	@FXML
	private TextField custIdField;

    @FXML
    private PasswordField passField;

    //@FXML
    //private TextField contactNoField;
    @FXML
    private Button submitButton1;
    //public int i=0;
    
    
    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) throws SQLException {
        Window owner = submitButton1.getScene().getWindow();
        
        if(custIdField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your User ID");
            
            return;
        }
  
        if(passField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            
            return;
        }
        
       
        String userID=custIdField.getText();
        String password=passField.getText();
        System.out.println(custIdField.getText());
        
			User s;
			s = findByUsername(userID,password);
			System.out.println(s);
			if(s==null) {
				AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                    "Something went wrong ! Please try again later.");
			}
			else {
				Alert a = new Alert(AlertType.INFORMATION);
			    a.setContentText("Login Successful!");
			    a.showAndWait();
			    Parent root = null;
				try {
					root = FXMLLoader.load(getClass().getResource("/application/Customer.fxml"));
					new CustomerController().setText(userID, password);
				Stage stage = new Stage();
				stage.setScene(new Scene(root, 620, 500));
				stage.show();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}   	
    }
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
    
}