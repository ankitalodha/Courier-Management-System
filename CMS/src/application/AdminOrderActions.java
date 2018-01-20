package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AdminOrderActions extends DataSource{
	
	@FXML
	private Button confirmOrder, backButton,transitButton,pieChartButton;
	
	@FXML
	private TextField confirmOrderID;
	

	public void findOrderAndConfirm(ActionEvent event)
	{
		
		if(confirmOrderID.getText().isEmpty()) {
	            AlertHelper.showAlert(Alert.AlertType.ERROR, null, "Form Error!",
	                    "Please enter Order ID!");
	            
	            return;
	        }
		String status = null , orderID = confirmOrderID.getText();
		String query = "SELECT * FROM order_t WHERE orderID ='"+orderID+"'";
	    Statement st = null;
		 Window owner = confirmOrder.getScene().getWindow();
		try 
		{
			st = connection.createStatement();
	        // execute the query, and get a java resultset
	        ResultSet rs = null;
			rs = st.executeQuery(query);
			if (!rs.isBeforeFirst())
			{
				AlertHelper.showAlert(Alert.AlertType.ERROR, null, "Form Error!",
	                    "NO Data!");
				return;
			}	
			else if(rs.next()) 
			{
			  	status = rs.getString("status");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (status.equalsIgnoreCase("Placed"))
		{
				String queryUpd = "UPDATE order_t SET status = ? WHERE orderID ='"+orderID+"'";
				java.sql.PreparedStatement preparedStmt;
				try {
					preparedStmt = connection.prepareStatement(queryUpd);
				 preparedStmt.setString(1, "Confirmed");
			      // execute the java preparedstatement
			      preparedStmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
	            AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Successful!",
 	                    "Your have just updated the status of order" +orderID+"to Confirmed");
		}
		else 
		{
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                    "Something went wrong! Please try again later");	
		}
    }
	
	public void findOrderAndInTransit(ActionEvent event)
	{
		String status = null , orderID = confirmOrderID.getText();
		String query = "SELECT * FROM order_t WHERE orderID ='"+orderID+"'";
	    Statement st = null;
		 Window owner = transitButton.getScene().getWindow();
		try 
		{
			st = connection.createStatement();
	        // execute the query, and get a java resultset
	        ResultSet rs = null;
			rs = st.executeQuery(query);
			if (!rs.isBeforeFirst())
			{
				AlertHelper.showAlert(Alert.AlertType.ERROR, null, "Form Error!",
	                    "NO Data!");
				return;
			}	
			else if(rs.next()) 
			{
			  	status = rs.getString("status");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (status.equalsIgnoreCase("Confirmed"))
		{
				String queryUpd = "UPDATE order_t SET status = ? WHERE orderID ='"+orderID+"'";
				java.sql.PreparedStatement preparedStmt;
				try {
					preparedStmt = connection.prepareStatement(queryUpd);
				 preparedStmt.setString(1, "In Transit");
			      // execute the java preparedstatement
			      preparedStmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
	            AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Successful!",
 	                    "Your have just updated the status of order" +orderID+"to In Transit");
		}
		else 
		{
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                    "Something went wrong! Please try again later");	
		}
    }
	

}