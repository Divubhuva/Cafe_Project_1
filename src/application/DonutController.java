package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DonutController implements Initializable{

	private MainScreenController mainController;
	
	
	
	@FXML
    private ComboBox<String> DonuteTypeComboBox;

    @FXML
    private Button AddToListButton;

    @FXML
    private Button RemoveFromListButton;

    @FXML
    private ComboBox<String> NumberOfCountComboBox;

    @FXML
    private ListView<String> FlowersList;

    @FXML
    private ListView<String> DounteOrderListBox;

    @FXML
    private TextField DounteAmountTextField;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
    
    
    @FXML
    void AddToListButtonPress(ActionEvent event) {
    	
    }

    @FXML
    void DonuteTypeValueChange(ActionEvent event) {

    }

    @FXML
    void RemoveFromListButtonPress(ActionEvent event) {

    }
	

	
	public void setMainController(MainScreenController controller) {
		mainController = controller;
	} 
}
