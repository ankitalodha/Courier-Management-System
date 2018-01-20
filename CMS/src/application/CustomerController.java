package application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;


public class CustomerController{

	@FXML
    private Button viewOrdersButton;
	
	@FXML
    private Button createOrderButton;
	
	@FXML
    private Button cancelOrderButton;
	
	@FXML
    private Button enquiryButton;
	
	@FXML
    private Button editProfileButton;
	
	
	@FXML
    private Button trackOrderButton;
	
	@FXML
    private Button backButton;
	
	@FXML
    private Button logOutButton;
	
    static String name , pwd;
    public void setText (String name, String password)
    {
    	this.name = name;
    	this.pwd = password;
    	System.out.println(name);
    }
    
	public void onLogout(ActionEvent event)
	{
		logOutButton.getScene().getWindow().setOnCloseRequest(null);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    
	@FXML
	private void viewOrders(ActionEvent event)
	{
	   System.out.println("here");
		@SuppressWarnings("rawtypes")
		TableView tableview = new TableView();
		ObservableList<ObservableList> data;

	   	//CONNECTION DATABASE
	   	//CONNECTION DATABASE
	   	  Connection c ;
	         data = FXCollections.observableArrayList();
	         try{
	           c = DBConnect.connect();
	           //SQL FOR SELECTING ALL OF CUSTOMER
	           String SQL = "SELECT orderID , packageName, OrderDate, status, userID FROM order_t where userID = ?;" ;
	           java.sql.PreparedStatement statement = c.prepareStatement(SQL);
	           statement.setString(1, this.name);
	           //ResultSet
	          
	           //ResultSet rs = c.createStatement().executeQuery(SQL);
	           ResultSet rs = statement.executeQuery();
	           
	           /**********************************
	            * TABLE COLUMN ADDED DYNAMICALLY *
	            **********************************/
	           for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
	               //We are using non property style for making dynamic table
	               final int j = i;                
	               @SuppressWarnings("rawtypes")
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
	               col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
	                   public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
	                       return new SimpleStringProperty(param.getValue().get(j).toString());                        
	                   }                    
	               });
	              
	               tableview.getColumns().addAll(col); 
	               System.out.println("Column ["+i+"] ");
	           }

	           /********************************
	            * DATA ADDED TO OBSERVABLELIST*
	            ********************************/
	           while(rs.next()){
	               //Iterate Row
	               ObservableList<String> row = FXCollections.observableArrayList();
	               for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
	                   //Iterate Column
	                   row.add(rs.getString(i));
	               }
	               System.out.println("Row [1] added "+row );
	               data.add(row);
	           }

	           //FINALLY ADD TO TableView
	           tableview.setItems(data);
	         }catch(Exception e){
	             e.printStackTrace();
	             System.out.println("Error on Building Data");             
	         }
	      
	       //Create Main Scene (pop up)
	       tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	       Scene scene = new Scene(tableview);        
	       Stage stage = new Stage();
	       stage.setWidth(500);
	       stage.setScene(scene);
	       stage.show();
	}

	
	@FXML
	private void createOrders(ActionEvent event){
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/PlaceOrder.fxml"));
			new PlaceOrderController().setText(name, pwd);
			Stage stage = new Stage();
			stage.setScene(new Scene(root, 600, 600));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@FXML
	private void cancelOrders(ActionEvent event){
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/CancelOrder.fxml"));
			new CancelOrderController().setText(name, pwd);
			Stage stage = new Stage();
			stage.setScene(new Scene(root, 450, 450));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void viewRateChart(ActionEvent event) throws Exception 
	{  
		 System.out.println("here");
	    
        @SuppressWarnings({ "rawtypes" })
   	
        //TABLE VIEW AND DATA

   	TableView tableview = new TableView();
   	ObservableList<ObservableList> data;

   	//CONNECTION DATABASE
   	  Connection c ;
         data = FXCollections.observableArrayList();
         try{
           c = DBConnect.connect();
           //SQL FOR SELECTING ALL OF CUSTOMER
           String SQL = "SELECT * from rateChart";
           //ResultSet
           ResultSet rs = c.createStatement().executeQuery(SQL);

           /**********************************
            * TABLE COLUMN ADDED DYNAMICALLY *
            **********************************/
           for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               //We are using non property style for making dynamic table
               final int j = i;                
               @SuppressWarnings("rawtypes")
			TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
               col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                   public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                       return new SimpleStringProperty(param.getValue().get(j).toString());                        
                   }                    
               });
              
               tableview.getColumns().addAll(col); 
               System.out.println("Column ["+i+"] ");
           }

           /********************************
            * DATA ADDED TO OBSERVABLELIST*
            ********************************/
           while(rs.next()){
               //Iterate Row
               ObservableList<String> row = FXCollections.observableArrayList();
               for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                   //Iterate Column
                   row.add(rs.getString(i));
               }
               System.out.println("Row [1] added "+row );
               data.add(row);
           }

           //FINALLY ADD TO TableView
           tableview.setItems(data);
         }catch(Exception e){
             e.printStackTrace();
             System.out.println("Error on Building Data");             
         }
      
       //Create Main Scene (pop up)
       tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
       Scene scene = new Scene(tableview);        
       Stage stage = new Stage();
       stage.setWidth(500);
       stage.setScene(scene);
       stage.show();
}
	
	@FXML
	public void genInv(ActionEvent event) throws Exception 
	{
    	try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/GenerateInvoice.fxml"));
			new GenerateInvoiceController().setText(name, pwd);
			Stage stage = new Stage();
			stage.setScene(new Scene(root, 600, 600));
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
