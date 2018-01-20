package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class GenerateInvoiceController extends DataSource{
		
@FXML
private TextField invoiceField;

@FXML
private Button genInv,back;

static String name , pwd;
public void setText (String name, String password)
{
	this.name = name;
	this.pwd = password;
	System.out.println(name);
}

@FXML
public void genInv ()
{
	System.out.println("1");
    String showPackageName = null , sourceAddressLine = null , destAddressLine = null , SourceCity = null, SourceState = null , 
	destCity = null, destState = null , sPIN = null , dPIN = null , orderID = null , invoiceDate = null , 
	totaltobepaid = null,expressType = null,fragileType = null;
	
	String invorderID = invoiceField.getText();
	String query = "SELECT * FROM invoice_t WHERE userID = '"+name+"' AND orderID ='"+invorderID+"'";
    Statement st = null;
	 System.out.println("2");
	try 
	{
		st = connection.createStatement();
        // execute the query, and get a java resultset
        ResultSet rs = null;
		rs = st.executeQuery(query);
		boolean empty = true;
		while( rs.next() ) {
		    // ResultSet processing here
		    empty = false;
		    Alert a = new Alert(AlertType.INFORMATION);
		    a.setContentText("Invoice Already Generated!");
		    a.showAndWait();  
		    return;
		}
		if( empty ) 
		{
			String querySelect = "SELECT * FROM order_t WHERE userID = '"+name+"' AND orderID ='"+invorderID+"'";
		    try 
			{
				System.out.println("4");
				st = connection.createStatement();
		        rs = st.executeQuery(querySelect);
				while( rs.next() ) {
				orderID           = rs.getString("orderID");  
				showPackageName   = rs.getString("packageName");
				sourceAddressLine = rs.getString("sourceAddressLine");
				SourceCity    = rs.getString("sourceCity"); 
				SourceState   = rs.getString("sourceState");
				sPIN          = rs.getString("sourcePin");
				destAddressLine  = rs.getString("destinationAddressLine");
				destCity      = rs.getString("destinationCity"); 
				destState     = rs.getString("destinationState"); 
				dPIN          = rs.getString("destinationPin"); 
				totaltobepaid = rs.getString("TotalCost"); 
				name          = rs.getString("userID");
				fragileType   = rs.getString("packageType"); 
				expressType   = rs.getString("deliveryType"); 
				invoiceDate   = rs.getString("OrderDate"); 
				
				}
			}
			catch  (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	    FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(getClass().getResource("/application/Invoice.fxml"));
	    try {
	loader.load();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	InvoiceController invc = loader.getController();
		invc.setText(name, showPackageName , sourceAddressLine , destAddressLine , SourceCity, SourceState , 
				destCity, destState , sPIN , dPIN , orderID  , invoiceDate , 
				totaltobepaid,fragileType,expressType);
		
	    	Parent p = loader.getRoot();
	Stage stage = new Stage();
	stage.setScene(new Scene(p));
	stage.show();
    }
}


		
