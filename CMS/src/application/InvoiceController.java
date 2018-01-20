package application;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;

public class InvoiceController extends DataSource{
	
	@FXML
	private Label showPackageName , sourceAddressLine , destAddressLine , SourceCity, SourceState , 
	destCity, destState , invoiceID,sPIN , dPIN , orderID , invoiceDate , totaltobepaid,pkgcost,amountpaid,due;
	
	@FXML
	private Pane anchorPane;
	

    @FXML
    Button saveInvoice;

	public void setText(String name, String showPackage , String sourceAddressLine ,String destAddressLine ,String SourceCity
		,String SourceState,String destCity,String destState ,String sPIN ,String dPIN ,String orderID ,String invoiceDate ,
		String totaltobepaid,String fragileType , String deliveryType)
	{
		this.showPackageName.setText(showPackage);
		this.sourceAddressLine.setText(sourceAddressLine);
		this.SourceCity.setText(SourceCity);
		this.SourceState.setText(SourceState);
		this.sPIN.setText(sPIN);
		this.destAddressLine.setText(destAddressLine);
		this.destCity.setText(destCity);
		this.destState.setText(destState);
		this.dPIN.setText(dPIN);
		this.orderID.setText(orderID);
		this.invoiceDate.setText(invoiceDate);
		this.totaltobepaid.setText(totaltobepaid);
		this.pkgcost.setText(totaltobepaid);
		this.due.setText(totaltobepaid);
		this.amountpaid.setText("0.00");
		
		try {
			String s = insertInvoice(name,showPackage, 
					 sourceAddressLine, SourceCity, SourceState, sPIN,
			         destAddressLine, destCity, destState, dPIN,
			         orderID, totaltobepaid, fragileType, deliveryType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String insertInvoice(String userID,String pkgName,String fromAddr,String fromCity,String fromState,
			String fromPin,String toAddr,String toCity,String toState,String toPin,String orderID,String pkgCost,String fragileCharge,String deliveryCost) throws SQLException { 
		// TODO Auto-generated method stub
		Connector connect = new Connector();
		Statement statement;
		try {
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			System.out.println("Attempting to connect!");
			statement = connect.getConnection().createStatement();
		    System.out.println("here before insert");
			String sql = "INSERT INTO invoice_t(orderID,packageName,sourceAddressLine,sourceCity,sourceState,sourcePin,destinationAddressLine,destinationCity,destinationState,destinationPin,TotalCost,fragileCost,deliveryCost,userID,OrderDate)" + 
					     " VALUES (+'"+orderID+"','"+pkgName+"','"+fromAddr+"','"+fromCity+"','"+fromState+"','"+fromPin+"','"+toAddr+"','"+toCity+"','"+toState+"',"
							+ "'"+toPin+"','"+pkgCost+"','"+fragileCharge+"','"+deliveryCost+"','"+userID+"','"+date+"')";
			//CREATE TABLE order_T (orderID int auto_increment, packageName VARCHAR(50), sourceAddressLine varchar(500), sourceCity varchar(50), sourceState varchar(50),sourcePin varchar(6),destinationAddressLine varchar(500), destinationCity varchar(50), destinationState varchar(50),destinationPin varchar(6), userID VARCHAR(20), PRIMARY KEY(OrderID),FOREIGN KEY (userID) REFERENCES customer_T (userID));
		    statement.executeUpdate(sql);
		    Alert a = new Alert(AlertType.INFORMATION);
		    a.setContentText("Invoice generated!");
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
			
			String querySelect = "SELECT * FROM invoice_t WHERE orderID ='"+orderID+"'";

			System.out.println("4");
			Statement st = connection.createStatement();
	        ResultSet rs = st.executeQuery(querySelect);
			while( rs.next() ) {
				System.out.println(rs.getString("invoiceID"));
				this.invoiceID.setText(rs.getString("invoiceID"));
			}
		
		return "Your Order has been successfully placed";
	}
	
	@FXML
	private void saveOrderInformation(ActionEvent action)
	{
		WritableImage image = anchorPane.snapshot(new SnapshotParameters(), null);

		File file = new File("E:\\anchor1.png");

		try {
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
