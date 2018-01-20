package application;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;
import javafx.stage.Window;

public class UpdateCostController extends UpdateCostDao{

@FXML
private Label showCost,showSourceCity,showDestCity,showSourceState,showDestState;

@FXML
Label showCostLabel;


@FXML
Label showSourceLabel,showSourceStateLabel,showSourcePinLabel;

@FXML
Label showDestinationLabel,showDestStateLabel,showDestPinLabel,newCostLabel;

@FXML
private Button updateCostButton;

@FXML
private Node anchorPane;

@FXML 
private TextField newCost;


public void setText(String sourceCity,String sourceState,String destCity,String destState,String costFinal)
{
	
	
	this.showSourceCity.setText(sourceCity);
	this.showSourceState.setText(sourceState);
	this.showDestCity.setText(destCity);
	this.showDestState.setText(destState);
	this.showCost.setText(costFinal);
	
	
	
}


	
	@SuppressWarnings("unused")
	public void handleSubmitButtonAction(ActionEvent event) throws SQLException {
		
		Window owner = updateCostButton.getScene().getWindow();
		String fromCity=showSourceCity.getText();
		String fromState=showSourceState.getText();
		String toCity=showDestCity.getText();
		String toState=showDestState.getText();
		String pkgCost=showCost.getText();
		String updatedCost=newCost.getText();
		
		String s;
		s=updateRateChartTable(fromCity,fromState,toCity,toState,pkgCost,updatedCost);
		
    	/*FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/application/Invoice.fxml"));
		try {
    loader.load();
    } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
       InvoiceController ic = loader.getController();
		ic.setText(pkgName,fromAddr,fromCity,fromState,fromPin,toAddr,toCity,toState,toPin,pkgCost,pkgType,deliveryMode,userID,costFragile,costExpress);
		Parent p = loader.getRoot();
		Stage stage = new Stage();
		stage.setScene(new Scene(p));
		stage.show();*/
}	
	
}
