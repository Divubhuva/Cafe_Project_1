package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainScreenController {

	private static final int WIDTH = 600;
	private static final int HEIGHT = 650;
	
	private Stage donuteStage;
	
	private Stage storeOrderStage;
	private Stage coffeeStage;

	private CafeHandler handler = new CafeHandler();
	
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

	
    public CafeHandler getCafeHandler() {
    	return handler;
    }
}
