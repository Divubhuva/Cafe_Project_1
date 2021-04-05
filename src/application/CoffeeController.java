package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CoffeeController implements Initializable {

	private MainScreenController mainController;
	
    @FXML
    private ComboBox<String> SizeOfCoffee;

    @FXML
    private ComboBox<String> NumberOfCoffeCombo;

    @FXML
    private TextField DollaramountTextField;

    @FXML
    private CheckBox CreamCheckBox;

    @FXML
    private CheckBox MilkCheckBox;

    @FXML
    private CheckBox SyrupCheckBox;

    @FXML
    private CheckBox WhippedCreamCheckbox;

    @FXML
    private CheckBox CaramelCheckBox;

    @FXML
    private TextArea Logger;

    private static final int STARTCOUNT = 1;
    private ObservableList<String> coffeeSizeTypeList = FXCollections.observableArrayList(); 
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	SizeOfCoffee.setItems(coffeeSizeTypeList);
    	SizeOfCoffee.setValue(new CoffeeShort().getSizeOfCoffee());
    	
    	NumberOfCoffeCombo.setValue(String.valueOf(STARTCOUNT));
	}
	 
	
    
    @FXML
    void AddToOrderButtonPress(ActionEvent event) {

    }

    @FXML
    void CaramelCheckBoxChange(ActionEvent event) {

    }

    @FXML
    void CreamCheckBoxChange(ActionEvent event) {

    }

    @FXML
    void MilkCheckBoxChange(ActionEvent event) {

    }

    @FXML
    void NumberOfCoffeChange(ActionEvent event) {

    }

    @FXML
    void SizeOfCoffeeChange(ActionEvent event) {

    }

    @FXML
    void SyrupCheckBoxChange(ActionEvent event) {

    }

    @FXML
    void WhippedCreamChange(ActionEvent event) {

    }
	
    public void setMainController(MainScreenController controller) {
		mainController = controller;
		
		CafeHandler handler = mainController.getCafeHandler();
		coffeeSizeTypeList.addAll(handler.getTypesOfCoffeeSize());
		
		for(int index = STARTCOUNT ; index <= handler.getMaxCount(); index++) {
			NumberOfCoffeCombo.getItems().add(String.valueOf(index));
    	}
	}
}
