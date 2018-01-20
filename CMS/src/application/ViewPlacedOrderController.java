package application;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ViewPlacedOrderController extends ConfirmOrderDao{

@FXML
private Label showCost,showUserId,showPackageName,showSourceCity,showDestCity,showSourceState,showDestState,showSourcePin,showDestPin,showPackageType,showDeliveryType;

@FXML
Label showCostLabel,FragileCostLabel, ExpressCostLabel;

@FXML
Label showPackageNameLabel;

@FXML
Label showUserIdLabel;

@FXML
Label showSourceLabel,showSourceStateLabel,showSourcePinLabel;

@FXML
Label showDestinationLabel,showDestStateLabel,showDestPinLabel;

@FXML
Label showPackageTypeLabel,showDeliveryTypeLabel,fromLabel,toLabel;

@FXML
private Label fromSource,toDestination,FragileCost,ExpressCost;

@FXML
private Button confirmOrderButton;

public void setText(String pkgName,String sourceAddress,String sourceCity,String sourceState,String sourcePin,String destinationAddress,String destCity,String destState,String destinationPin,String costFinal,String Fragile,String DeliveryType,String userID,String FragileCost,String expressCost)
{
	
	this.showUserId.setText(userID);
	this.showPackageName.setText(pkgName);
	this.fromSource.setText(sourceAddress);
	this.showSourceCity.setText(sourceCity);
	this.showSourceState.setText(sourceState);
	this.showSourcePin.setText(sourcePin);
	this.toDestination.setText(destinationAddress);
	this.showDestCity.setText(destCity);
	this.showDestState.setText(destState);
	this.showDestPin.setText(destinationPin);
	this.showCost.setText(costFinal);
	this.showPackageType.setText(Fragile);
	this.showDeliveryType.setText(DeliveryType);
	this.FragileCost.setText(FragileCost);
	this.ExpressCost.setText(expressCost);
	
	
}

@SuppressWarnings("unused")
public void handleSubmitButtonAction(ActionEvent event) throws SQLException {
	
	Window owner = confirmOrderButton.getScene().getWindow();
	String userID=showUserId.getText();
	String pkgName=showPackageName.getText();
	String fromAddr=fromSource.getText();
	String fromCity=showSourceCity.getText();
	//String srcAddressLine=fromSource.getText();
	String fromState=showSourceState.getText();
	String fromPin=showSourcePin.getText();
	//String destAddressLine=showDestination.getText();
	String toAddr=toDestination.getText();
	String toCity=showDestCity.getText();
	String toState=showDestState.getText();
	String toPin=showDestPin.getText();
	String pkgCost=showCost.getText();
	String pkgType=showPackageType.getText();
	String deliveryMode=showDeliveryType.getText();
	String costFragile=FragileCost.getText();
	String costExpress=ExpressCost.getText();
	
	String s;
	s=insertOrderTable(userID,pkgName,fromAddr,fromCity,fromState,fromPin,toAddr,toCity,toState,toPin,pkgCost,pkgType,deliveryMode);
}





	



	
	
}