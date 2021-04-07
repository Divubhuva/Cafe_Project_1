package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * This is the controller that binds to the CurrentOrderView.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
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
	 
	 private static final int START_COUNT = 1;

	 private ObservableList<String> currentOrderListInfo = FXCollections.observableArrayList();

	/**
	 * This is the method that is executed whenever PlaceOrderButton is pressed.
	 * @param event, the captured event.
	 */
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

	/**
	 * This is the method that is executed whenever RemoveSelectedButton is pressed.
	 * @param event, the captured event.
	 */
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

	/**
	 * This initializes the CurrentOrderView.
	 * @param arg0 the URL.
	 * @param arg1 is the resource bundle given by the fxml loader.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		PrinterArea.setItems(currentOrderListInfo);
		
	}

	/**
	 * This sets this controller's Total, Subtotal, and Sales Tax to be that of the MainController's CafeHandler.
	 * As well, it also adds all the MainController's order list to this controller's order list.
	 */
	private void initValues() {
		currentOrderListInfo.clear();
		CafeHandler handler = mainController.getCafeHandler();
		SubtotalText.setText(handler.getCurrentOderSubTotal());
		SalesTaxText.setText(handler.getCurrentOrderSalesTax());
		TotalText.setText(handler.getCurrentOderTotal());
		currentOrderListInfo.addAll(handler.getCurrentOrderStringList());
		
		 if(currentOrderListInfo.size() == START_COUNT) {
			 PrinterArea.getSelectionModel().selectFirst();
	     }
	}

	/**
	 * This sets the main controller.
	 * @param controller to set the current controller equal to.
	 */
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
