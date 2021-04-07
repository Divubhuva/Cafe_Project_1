package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the controller that binds to the MainScreenView.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
public class MainScreenController {

	/**
	 * This sets a fixed width for the window.
	 */
	private static final int WIDTH = 600;

	/**
	 * This sets a fixed height for the window.
	 */
	private static final int HEIGHT = 650;

	/**
	 * This defines the DonutStage.
	 */
	private Stage donuteStage;

	/**
	 * This defines the StoreOrderStage.
	 */
	private Stage storeOrderStage;

	/**
	 * This defines the CoffeeStage.
	 */
	private Stage coffeeStage;

	/**
	 * This defines the CafeHandler.
	 */
	private final CafeHandler handler = new CafeHandler();

	/**
	 * This is the method that is executed whenever a CoffeeButton is pressed.
	 * @param event, the captured event.
	 */
    @FXML
    void CoffeeButtonPress(ActionEvent event) {
    	try {
    		if (coffeeStage == null) {
        		FXMLLoader loader = new FXMLLoader(getClass().getResource("CoffeeView.fxml"));
        		coffeeStage = new Stage();
    			Scene scene = new Scene(loader.load(),WIDTH,HEIGHT);
    			coffeeStage.setScene(scene);
    			coffeeStage.setTitle("Coffee Items");
    			
    			CoffeeController controller = loader.getController();
    			controller.setMainController(this);
    		}
			coffeeStage.show();
			coffeeStage.requestFocus();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }

	/**
	 * This is the method that is executed whenever a CurrentOrderButton is pressed.
	 * @param event, the captured event.
	 */
    @FXML
    void CurrentOrderButtonPress(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
    		Stage currentOrderStage = new Stage();
    		Scene scene = new Scene(loader.load(),WIDTH,HEIGHT);
    		currentOrderStage.setScene(scene);
    		currentOrderStage.setTitle("Current Order");
    			
    		CurrentOrderController controller = loader.getController();
    		controller.setMainController(this);
    		
			currentOrderStage.show();
			currentOrderStage.requestFocus();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	/**
	 * This is the method that is executed whenever a DonutesButtonButton is pressed.
	 * @param event, the captured event.
	 */
    @FXML
    void DonutesButtonPress(ActionEvent event) {
    	try {
    		if(donuteStage == null) {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("DonutView.fxml"));
    			donuteStage = new Stage();
    			Scene scene = new Scene(loader.load(),WIDTH,HEIGHT);
    			donuteStage.setScene(scene);
    			donuteStage.setTitle("Donutes Item");
    			
    			DonutController controller = loader.getController();
    			controller.setMainController(this);
    			
    		}
    		donuteStage.show();
    		donuteStage.requestFocus();
			
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	/**
	 * This is the method that is executed whenever a StoreOrderButtonButton is pressed.
	 * @param event, the captured event.
	 */
    @FXML
    void StoreOrderButtonPress(ActionEvent event) {
    	try {
    		if (storeOrderStage == null) {
    			FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreView.fxml"));
    			storeOrderStage = new Stage();
    			Scene scene = new Scene(loader.load(),WIDTH,HEIGHT);
    			storeOrderStage.setScene(scene);
    			storeOrderStage.setTitle("Total Order");
    			
    			StoreOrderController controller = loader.getController();
    			controller.setMainController(this);
    		}
    		storeOrderStage.show();
    		storeOrderStage.requestFocus();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	/**
	 * This gets the CafeHandler of the controller.
	 * @return the controller's CafeHandler.
	 */
    public CafeHandler getCafeHandler() {
    	return handler;
    }
}
