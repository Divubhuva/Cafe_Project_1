package application;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainScreenController {

	final int WIDTH = 600;
	final int HEIGHT = 400;
	
    @FXML
    private Button DonutesButton;

    @FXML
    private Button CoffeeButton;

    @FXML
    private Button CurrentOrderButton;

    @FXML
    private Button StoreOrderButton;

    @FXML
    void CoffeeButtonPress(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("CoffeeView.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(loader.load(),WIDTH,HEIGHT);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Coffee Items");
			primaryStage.show();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }

    @FXML
    void CurrentOrderButtonPress(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(loader.load(),WIDTH,HEIGHT);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Current Order");
			primaryStage.show();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void DonutesButtonPress(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("DonutView.fxml"));
    		Stage primaryStage = new Stage();
    		Scene scene = new Scene(loader.load(),WIDTH,HEIGHT);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Donutes Item");
    		primaryStage.show();
			
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void StoreOrderButtonPress(ActionEvent event) {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreView.fxml"));
			Stage primaryStage = new Stage();
			Scene scene = new Scene(loader.load(),WIDTH,HEIGHT);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Total Order");
			primaryStage.show();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

	

}
