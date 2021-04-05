package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
public class CurrentOrderController implements Initializable{

	private MainScreenController mainController;
	
	 @FXML
	 private TextField SubtotalText;

	 @FXML
	 private TextField SalesTaxText;

	 @FXML
	 private TextField TotalText;

	 @FXML
	 private ListView<String> PrinterArea;

	 @FXML
	 private TextArea Logger;

	 @FXML
	 void PlaceOrderButtonPress(ActionEvent event) {

	 }

	 @FXML
     void RemoveSelectedButtonPress(ActionEvent event) {
	 }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	private void initValues() {
		CafeHandler handler = mainController.getCafeHandler();
		SubtotalText.setText(handler.getCurrentOderSubTotal());
		SalesTaxText.setText(handler.getCurrentOrderSalesTax());
		TotalText.setText(handler.getCurrentOderTotal());

		
	}
	
	public void setMainController(MainScreenController controller) {
		mainController = controller;
		initValues();
	} 
	
	

}
