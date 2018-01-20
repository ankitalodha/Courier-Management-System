package application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class CancelOrderController extends DataSource{
	
	@FXML
	private Button cancelOrder, backButton;
	
	@FXML
	private TextField cancelOrderID;
	
    static String name , pwd;
	public void setText(String name, String pwd) {
		// TODO Auto-generated method stub
		this.name = name;
    	this.pwd = pwd;
	}
	public void findOrderAndCancel(ActionEvent event)
	{
		String status = null , orderID = cancelOrderID.getText();
		String query = "SELECT * FROM order_t WHERE userID = '"+name+"' AND orderID ='"+orderID+"'";
	    Statement st = null;
		 Window owner = cancelOrder.getScene().getWindow();
		try 
		{
			st = connection.createStatement();
	        // execute the query, and get a java resultset
	        ResultSet rs = null;
			rs = st.executeQuery(query);
			if(rs.next()) 
			{
			  	status = rs.getString("status");
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (status.equalsIgnoreCase("confirmed"))
		{
				String queryUpd = "UPDATE order_t SET status = ? WHERE orderID ='"+orderID+"'";
				java.sql.PreparedStatement preparedStmt;
				try {
					preparedStmt = connection.prepareStatement(queryUpd);
				 preparedStmt.setString(1, "CANCELLED");
			      // execute the java preparedstatement
			      preparedStmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Your order has been cancelled!");
		}
		else 
		{
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                    "Your order has been Shipped, Sorry can not be cancelled!");	
		}
    }



}
