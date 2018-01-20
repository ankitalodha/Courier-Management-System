package application;

import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ConfirmOrderDao extends Connector{
	Connector connect = new Connector();
	private Statement statement;
	protected String insertOrderTable(String userID,String pkgName,String fromAddr,String fromCity,String fromState,String fromPin,String toAddr,String toCity,String toState,String toPin,String pkgCost,String pkgType,String deliveryMode) throws SQLException { {
		// TODO Auto-generated method stub
		
		try {
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			System.out.println("Attempting to connect!");
			statement = connect.getConnection().createStatement();
		    System.out.println("here before insert");
			String sql = "INSERT INTO order_T(packageName,sourceAddressLine,sourceCity,sourceState,sourcePin,destinationAddressLine,destinationCity,destinationState,destinationPin,TotalCost,packagetype,deliveryType,userID,OrderDate)" + " VALUES ('"+pkgName+"','"+fromAddr+"','"+fromCity+"','"+fromState+"','"+fromPin+"','"+toAddr+"','"+toCity+"','"+toState+"','"+toPin+"','"+pkgCost+"','"+pkgType+"','"+deliveryMode+"','"+userID+"','"+date+"')";
			//CREATE TABLE order_T (orderID int auto_increment, packageName VARCHAR(50), sourceAddressLine varchar(500), sourceCity varchar(50), sourceState varchar(50),sourcePin varchar(6),destinationAddressLine varchar(500), destinationCity varchar(50), destinationState varchar(50),destinationPin varchar(6), userID VARCHAR(20), PRIMARY KEY(OrderID),FOREIGN KEY (userID) REFERENCES customer_T (userID));
		    statement.executeUpdate(sql);
		    Alert a = new Alert(AlertType.INFORMATION);
		    a.setContentText("Order Placed!");
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
		
		return "Your Order has been successfully placed";
	}
	

	}
}
