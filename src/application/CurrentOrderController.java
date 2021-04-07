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

	 private final ObservableList<String> currentOrderListInfo = FXCollections.observableArrayList();
	 
	 @FXML
	 void PlaceOrderButtonPress(ActionEvent event) {
		 CafeHandler handler = mainController.getCafeHandler();
		 if (handler.placeOrderInStore()) {
			 Logger.appendText("Your order is placed.\n");
		 }
		 else {
			 Logger.appendText("Your order is not placed. Orderlist may empty.\n"); 
		 }
	 }

	 @FXML
     void RemoveSelectedButtonPress(ActionEvent event) {
		 CafeHandler handler = mainController.getCafeHandler();
		 String selectedString = PrinterArea.getSelectionModel().getSelectedItem();
		 if(selectedString != null) {
			 currentOrderListInfo.remove(selectedString);
			 if (handler.RemoveItemFromCurrentOrder(selectedString)) {
				 Logger.appendText("Selected Item is remove sucessfully.\n");
			 }
		 }
		 else {
			 Logger.appendText("Item is not selected.\n");
		 }
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
