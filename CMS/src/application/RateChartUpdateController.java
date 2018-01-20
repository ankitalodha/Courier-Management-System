package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.Labeled;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert;

public class RateChartUpdateController extends ViewOrderCostDAO{
	
	@FXML
	private Button fetchCostButton , backButton;
	
	@FXML
	private ComboBox<String> sourceCityBox, sourceStateBox , destinationCityBox , destinationStateBox;
	
	//@FXML 
	//private TextField sourcePinField , destinationPinField , sourceAddressField , destinationAddressField , weightField, pkgNameField ;

    static String name , pwd;
    
	ObservableList<String> sourceStateList=FXCollections.observableArrayList("Maharashtra","West Bengal","Karnataka","Goa","Andhra Pradesh");
	ObservableList<String> sourceCityList=FXCollections.observableArrayList("Pune","Mumbai","Kolkata","Bangalore","Panjim","Hyderabad");
	ObservableList<String> destinationStateList=FXCollections.observableArrayList("Maharashtra","West Bengal","Karnataka","Goa","Andhra Pradesh");
	ObservableList<String> destinationCityList=FXCollections.observableArrayList("Pune","Mumbai","Kolkata","Bangalore","Panjim","Hyderabad");
	ObservableList<String> sourceCityListMH=FXCollections.observableArrayList("Pune","Mumbai");
	ObservableList<String> sourceCityListGA=FXCollections.observableArrayList("Panjim");
	ObservableList<String> sourceCityListWB=FXCollections.observableArrayList("Kolkata");
	ObservableList<String> sourceCityListKA=FXCollections.observableArrayList("Bangalore");
	ObservableList<String> sourceCityListAP=FXCollections.observableArrayList("Hyderabad");
	ObservableList<String> destinationCityListMH=FXCollections.observableArrayList("Pune","Mumbai");
	ObservableList<String> destinationCityListGA=FXCollections.observableArrayList("Panjim");
	ObservableList<String> destinationCityListWB=FXCollections.observableArrayList("Kolkata");
	ObservableList<String> destinationCityListKA=FXCollections.observableArrayList("Bangalore");
	ObservableList<String> destinationCityListAP=FXCollections.observableArrayList("Hyderabad");

//	@FXML
//	private TextField packageNameField;

//	@FXML
//	private RadioButton FragileYesButton, FragileNoButton;

//	@FXML
//	private ToggleButton RegularDeliveryButton;

//	@FXML
//	private ToggleButton ExpressDeliveryButton;
	
    @SuppressWarnings("static-access")
	public void setText (String name, String password)
    {
    	this.name = name;
    	this.pwd = password;
    	System.out.println(name);
    }
   @FXML
	   private void initialize() {
		   sourceStateBox.setValue("State");
		   sourceStateBox.setItems(sourceStateList);
		   
		   destinationStateBox.setValue("State");
		   destinationStateBox.setItems(destinationStateList);
		   
		   sourceCityBox.setValue("City");
		   sourceCityBox.setItems(sourceCityList);

		   destinationCityBox.setValue("City");
		   destinationCityBox.setItems(destinationCityList);
	   }
	   
	   @SuppressWarnings("unchecked")
	@FXML
	   public void CityChoice() {
		   if(sourceStateBox.getValue().equals("Maharashtra")) {
			   //sourceCityBox.setValue("Pune");
			   sourceCityBox.setItems(sourceCityListMH);
		   } else if(sourceStateBox.getValue().equals("Goa")) {
			   sourceCityBox.setValue("Panjim");
			   sourceCityBox.setItems(sourceCityListGA);
		   } else if(sourceStateBox.getValue().equals("West Bengal")) {
			   sourceCityBox.setValue("Kolkata");
			   sourceCityBox.setItems(sourceCityListWB);
		   } else if(sourceStateBox.getValue().equals("Andhra Pradesh")) {
			   sourceCityBox.setValue("Hyderabad");
			   sourceCityBox.setItems(sourceCityListAP);
		   } else if(sourceStateBox.getValue().equals("Karnataka")) {
			   sourceCityBox.setValue("Bangalore");
			   sourceCityBox.setItems(sourceCityListKA);
			   }
	   }
	
	   @SuppressWarnings("unchecked")
		@FXML
		   public void destCityChoice() {
			   if(destinationStateBox.getValue().equals("Maharashtra")) {
				   //sourceCityBox.setValue("Pune");
				   destinationCityBox.setItems(destinationCityListMH);
			   } else if(destinationStateBox.getValue().equals("Goa")) {
				   //destinationCityBox.setValue("Panjim");
				   destinationCityBox.setItems(destinationCityListGA);
			   } else if(destinationStateBox.getValue().equals("West Bengal")) {
				   //destinationCityBox.setValue("Kolkata");
				   destinationCityBox.setItems(destinationCityListWB);
			   } else if(destinationStateBox.getValue().equals("Andhra Pradesh")) {
			//	   destinationCityBox.setValue("Hyderabad");
				   destinationCityBox.setItems(destinationCityListAP);
			   } else if(destinationStateBox.getValue().equals("Karnataka")) {
				//   sourceCityBox.setValue("Bangalore");
				   destinationCityBox.setItems(destinationCityListKA);
				   }
		   }
	   
   	 @SuppressWarnings("unchecked")
 	@FXML
 	    protected void handleSubmitButtonAction(ActionEvent event) {
 	        Window owner = fetchCostButton.getScene().getWindow();
 	        
 /*	        if(packageNameField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter your Package name!");
 	            
 	            return;
 	        }*/
 	       /* if(sourceAddressField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter Source Address!");
 	            
 	            return;
 	        }*/
 	        
 	        if(sourceStateBox.getValue().toString().equals("State")) {
 	        	AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please select Source state!");
 	        	return;
 	        }
 	        if(sourceCityBox.getValue().toString().equals("City")) {
 	        	AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please select Source city!");
 	        	return;
 	        }
 	        
 	        /*if(sourcePinField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter Pin code of source address!");
 	            
 	            return;
 	        }*/
 	        
 	       /* if(sourcePinField.getLength() < 6 || sourcePinField.getLength() >= 7) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "PIN should be of only 6 digit. Please re-enter valid PIN.");
 	            
 	            return;
 	        }
 	        
 	        if(destinationAddressField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter Destination Address!");
 	            
 	            return;
 	        }*/
 	        
 	      
 	        if(destinationStateBox.getValue().toString().equals("State")) {
 	        	AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please Select Destination state!");
 	        	return;
 	        
 	        }
 	        
 	        if(destinationCityBox.getValue().toString().equals("City")) {
 	        	AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please select Destination city!");
 	        	return;
 	        }
 	        
 	      /*  if(destinationPinField.getText().isEmpty()) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please enter Pin code of destination address!");
 	            
 	            return;
 	        }

 	        if(destinationPinField.getLength() < 6 || destinationPinField.getLength() >= 7) {
 	            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "PIN should be of only 6 digit. Please re-enter valid PIN.");
 	            
 	            return;
 	        }*/
 	        
 	     /*  if(FragileYesButton.isSelected()) {
 	    	   System.out.println("Fragile Package");
 	       } else if(FragileNoButton.isSelected()) {
 	    	   System.out.println("Normal Package");
 	    	   
 	       } else {
 	    	   AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please Select the package type!");
 	    	   return;
 	       }
 	       
 	       if(RegularDeliveryButton.isSelected()) {
 	    	   System.out.println("Regular Delivery");
 	       } else if(ExpressDeliveryButton.isSelected()) {
 	    	   System.out.println("Express Delivery");
 	    	   
 	       } else {
 	    	   AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
 	                    "Please Select the delivery type!");
 	    	   return;
 	       }*/
 	       
 	       
 	      //  String sourceAddress=sourceAddressField.getText();
 	      //  String sourcePin=sourcePinField.getText();
 	      //  String destinationAddress=destinationAddressField.getText();
 	      //  String destinationPin=destinationPinField.getText();
 	      //  String pkgName=packageNameField.getText();
 	        String sourceState=sourceStateBox.getValue().toString();
 	        String destState=destinationStateBox.getValue().toString();
 	        String sourceCity=sourceCityBox.getValue().toString();
 	        String destCity=destinationCityBox.getValue().toString();
 	       // String userID=name;
 	        
 	        //DaoModel d= new DaoModel();
 	        //System.out.println("sourceAddress="+sourceAddress);
 	        //System.out.println("sorcePin="+sourcePin);
 	        //System.out.println("destinationAddress="+destinationAddress);
 	       // System.out.println("destinationPin="+destinationPin);
 	       // System.out.println("pkgName="+pkgName);
 	       // System.out.println("sourceState="+sourceState);
 	        System.out.println("sourceCity="+sourceCity);
 	        System.out.println("destState="+destState);
 	        System.out.println("destCity="+destCity);
 	        //System.out.println("Order placed by User:" +userID);
 	       
 	        
 	        String cost1 = findCostBySrcDest (sourceState, sourceCity, destCity, destState);
 	        System.out.println("Cost=" +cost1);
 	        int cost=Integer.parseInt(cost1);
 	        
 	       
 	        FXMLLoader loader = new FXMLLoader();
 	        loader.setLocation(getClass().getResource("/application/UpdateCost.fxml"));
 	        try {
 	    loader.load();
 	    } catch (IOException e) {
 	    // TODO Auto-generated catch block
 	    e.printStackTrace();
 	    }
 	        UpdateCostController ucc = loader.getController();
 	       // double finalcost;
 	       // double FragileCost=0;
 	       // double expressCost=0;
 	        
 	   /*     if(FragileYesButton.isSelected() && (ExpressDeliveryButton.isSelected())) {
 	        	FragileCost=100;
 	        	expressCost=100;
 	        	finalcost=cost+200;
 	        	
 	        } else if(FragileYesButton.isSelected() && (RegularDeliveryButton.isSelected())){
 	        	FragileCost=100;
 	        	expressCost=0;
 	        	finalcost=cost+100;
 	        	
 	        } else if(FragileNoButton.isSelected() && (ExpressDeliveryButton.isSelected())){
 	        	FragileCost=0;
 	        	expressCost=100;
 	        	finalcost=cost+100;}
 	        	else {
 	        	FragileCost=0;
 	        	expressCost=0;
 	        	finalcost=cost;
 	        }*/
 	        
 	        System.out.println("Cost="+cost1);
 	       // String Fragile="";
 	       /* if(FragileYesButton.isSelected()) {
 	        	Fragile="Fragile Package";
 	        } else if(FragileNoButton.isSelected()) {
 	        	Fragile="Normal Package";
 	        }*/
 	        
 	   //     String DeliveryType="";
 	      /*  if(RegularDeliveryButton.isSelected()) {
 	        	DeliveryType="Regular";
 	        } else if(ExpressDeliveryButton.isSelected()) {
 	        	DeliveryType="Express";
 	        }*/
 	        String costFinal=Double.toString(cost);
 	      /*  String costFragile=Double.toString(FragileCost);
 	        String costExpress=Double.toString(expressCost);*/
 	        System.out.println("costFinal="+costFinal);
 			//vpoc.setText(costFinal,pkgName,sourceAddress,sourceState,sourceCity,sourcePin,destinationAddress,destState,destCity,destinationPin,userID,DeliveryType,Fragile);
 	        	//vpoc.setText(pkgName,sourceCity,sourceState,sourcePin,destCity,destState,destinationPin,costFinal,Fragile,DeliveryType,userID);
 	        	ucc.setText(sourceCity,sourceState,destCity,destState,costFinal);
 	        	//sourceAddress,//destinationAddress
 	        	Parent p = loader.getRoot();
 	    Stage stage = new Stage();
 	    stage.setScene(new Scene(p));
 	    stage.show();
 	 }
		
 }