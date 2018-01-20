package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class UpdateCostDao extends DataSource{
	Connector connect = new Connector();
	private Statement statement;
	public String updateRateChartTable(String fromCity,String fromState,String toCity,String toState,String pkgCost,String updateCost) throws SQLException { {
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		System.out.println("Attempting to connect!");
		//statement = connect.getConnection().createStatement();
		System.out.println("here before insert");
		String sql = "UPDATE ratechart SET cost = ? WHERE sourceCity ='"+fromCity+"' and sourceState='"+fromState+"' and destCity='"+toCity+"' and destState='"+toState+"'";
		java.sql.PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(sql);
			preparedStmt.setString(1,updateCost.toString());
		  // execute the java preparedstatement
		  preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		//CREATE TABLE order_T (orderID int auto_increment, packageName VARCHAR(50), sourceAddressLine varchar(500), sourceCity varchar(50), sourceState varchar(50),sourcePin varchar(6),destinationAddressLine varchar(500), destinationCity varchar(50), destinationState varchar(50),destinationPin varchar(6), userID VARCHAR(20), PRIMARY KEY(OrderID),FOREIGN KEY (userID) REFERENCES customer_T (userID));
		//statement.executeUpdate(sql);
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText("Cost Updated!");
		a.showAndWait();
		
			
		
		return "Cost has been successfully updated";
	}
	

	}
}
