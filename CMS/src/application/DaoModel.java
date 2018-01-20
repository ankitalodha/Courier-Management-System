package application;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

//import records.BankRecords;


public class DaoModel extends Connector{
	
	Connector connect = new Connector();
	private Statement statement;
	public String insertTable(String userID, String ufname, String ulname, String address, String email, String pass,
			String num) throws SQLException {
	try {
		System.out.println("Attempting to connect!");
		statement = connect.getConnection().createStatement();
	    System.out.println("here before insert");
		String sql = "INSERT INTO customer_T(userID,fName,lName,Address,emailID,password,contactNo)" + " VALUES ('"+userID+"','"+ufname+"','"+ulname+"','"+address+"','"+email+"','"+pass+"','"+num+"')";
	    statement.executeUpdate(sql);
	    Alert a = new Alert(AlertType.INFORMATION);
	    a.setContentText("Registered!");
	    a.showAndWait();
	    
     	}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("issue is here");
			e.printStackTrace();
			throw new SQLException();

		}
	
		try {
			statement.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		 return "Data inserted into table !!!";
		
	}
}
