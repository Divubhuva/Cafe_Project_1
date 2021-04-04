package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class DonutController implements Initializable{

	private MainScreenController mainController;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void setMainController(MainScreenController controller) {
		mainController = controller;
	} 
}
