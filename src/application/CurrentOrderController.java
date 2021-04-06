package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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
	 
	 private static final int STARTCOUNT = 1;

	 private ObservableList<String> currentOrderListInfo = FXCollections.observableArrayList();
	 
	 @FXML
	 void PlaceOrderButtonPress(ActionEvent event) {
		 CafeHandler handler = mainController.getCafeHandler();
		 handler.getCurrentOrderList().clear();
	 }

	 @FXML
     void RemoveSelectedButtonPress(ActionEvent event) {
		 CafeHandler handler = mainController.getCafeHandler();
		 String selectedString = PrinterArea.getSelectionModel().getSelectedItem();
		 currentOrderListInfo.remove(selectedString);
		 handler.RemoveItemFromCurrentOrder(selectedString);
	 }

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		PrinterArea.setItems(currentOrderListInfo);
		
	}
	
	private void initValues() {
		currentOrderListInfo.clear();
		CafeHandler handler = mainController.getCafeHandler();
		SubtotalText.setText(handler.getCurrentOderSubTotal());
		SalesTaxText.setText(handler.getCurrentOrderSalesTax());
		TotalText.setText(handler.getCurrentOderTotal());
		currentOrderListInfo.addAll(handler.getCurrentOrderStringList());
		
		 if(currentOrderListInfo.size() == STARTCOUNT) {
			 PrinterArea.getSelectionModel().selectFirst();
	     }
	}
	
	public void setMainController(MainScreenController controller) {
		mainController = controller;
		initValues();
		CafeHandler handler = mainController.getCafeHandler();
		handler.getCurrentOrderList().addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable arg0) {
				initValues();
			}
	    });
	}
	
	
}
