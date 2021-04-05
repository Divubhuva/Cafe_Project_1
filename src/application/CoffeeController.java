package application;

import java.net.URL;
import java.util.ArrayList;
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
    	
    	
    	NumberOfCoffeCombo.setValue(String.valueOf(STARTCOUNT));
    	
	}
	 
	
    
    @FXML
    void AddToOrderButtonPress(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
    	handler.addToCoffeeOrder();
    	
    	String typeOfsize  = SizeOfCoffee.getSelectionModel().getSelectedItem();
    	int count = NumberOfCoffeCombo.getSelectionModel().getSelectedIndex() + STARTCOUNT;
    	
    	WhippedCreamCheckbox.setSelected(false);
    	CreamCheckBox.setSelected(false);
    	MilkCheckBox.setSelected(false);
    	SyrupCheckBox.setSelected(false);
    	CaramelCheckBox.setSelected(false);
    	
    	handler.selectSizeOfCoffee(typeOfsize, new ArrayList<String>(), count);
    	
    	Logger.appendText("Coffee is added to oreder.\n");
    }

    @FXML
    void CaramelCheckBoxChange(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
		
    	if (CaramelCheckBox.isSelected()) {
    		handler.addAddIn(CaramelCheckBox.getText());
    	}
    	else {
    		handler.removeAddIn(CaramelCheckBox.getText());
    	}
    	DollaramountTextField.setText(String.valueOf(handler.getCoffeePrice()));
    }

    @FXML
    void CreamCheckBoxChange(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
		
    	if (CreamCheckBox.isSelected()) {
    		handler.addAddIn(CreamCheckBox.getText());
    	}
    	else {
    		handler.removeAddIn(CreamCheckBox.getText());
    	}
    	DollaramountTextField.setText(String.valueOf(handler.getCoffeePrice()));
    }

    @FXML
    void MilkCheckBoxChange(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
		
    	if (MilkCheckBox.isSelected()) {
    		handler.addAddIn(MilkCheckBox.getText());
    	}
    	else {
    		handler.removeAddIn(MilkCheckBox.getText());
    	}
    	DollaramountTextField.setText(String.valueOf(handler.getCoffeePrice()));
    }

    @FXML
    void NumberOfCoffeChange(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
    	int count = NumberOfCoffeCombo.getSelectionModel().getSelectedIndex() + STARTCOUNT;
    	handler.setNumberOfCoffee(count);
    	DollaramountTextField.setText(String.valueOf(handler.getCoffeePrice()));
    }

    @FXML
    void SizeOfCoffeeChange(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
    	String typeOfsize  = SizeOfCoffee.getSelectionModel().getSelectedItem();
    	int count = NumberOfCoffeCombo.getSelectionModel().getSelectedIndex() + STARTCOUNT;
    	ArrayList<String> selectedList = new ArrayList<String>();
    	
    	if (WhippedCreamCheckbox.isSelected()) selectedList.add(WhippedCreamCheckbox.getText());
    	if (CreamCheckBox.isSelected()) selectedList.add(CreamCheckBox.getText()); 
    	if (MilkCheckBox.isSelected()) selectedList.add(MilkCheckBox.getText()); 
    	if (SyrupCheckBox.isSelected()) selectedList.add(SyrupCheckBox.getText()); 
    	if (CaramelCheckBox.isSelected()) selectedList.add(CaramelCheckBox.getText()); 
    	
		handler.selectSizeOfCoffee(typeOfsize,selectedList , count);
		
		DollaramountTextField.setText(String.valueOf(handler.getCoffeePrice()));
    }

    @FXML
    void SyrupCheckBoxChange(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
		
    	if (SyrupCheckBox.isSelected()) {
    		handler.addAddIn(SyrupCheckBox.getText());
    	}
    	else {
    		handler.removeAddIn(SyrupCheckBox.getText());
    	}
    	DollaramountTextField.setText(String.valueOf(handler.getCoffeePrice()));
    }

    @FXML
    void WhippedCreamChange(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
		
    	if (WhippedCreamCheckbox.isSelected()) {
    		handler.addAddIn(WhippedCreamCheckbox.getText());
    	}
    	else {
    		handler.removeAddIn(WhippedCreamCheckbox.getText());
    	}
    	DollaramountTextField.setText(String.valueOf(handler.getCoffeePrice()));
    }
	
    public void setMainController(MainScreenController controller) {
		mainController = controller;
		
		CafeHandler handler = mainController.getCafeHandler();
		coffeeSizeTypeList.addAll(handler.getTypesOfCoffeeSize());
		SizeOfCoffee.setValue(new CoffeeShort().getSizeOfCoffee());
		
		for(int index = STARTCOUNT ; index <= handler.getMaxCount(); index++) {
			NumberOfCoffeCombo.getItems().add(String.valueOf(index));
    	}

		String typeOfsize  = SizeOfCoffee.getSelectionModel().getSelectedItem();
    	int count = NumberOfCoffeCombo.getSelectionModel().getSelectedIndex() + STARTCOUNT;
		handler.selectSizeOfCoffee(typeOfsize, new ArrayList<String>(), count);
		
		DollaramountTextField.setText(String.valueOf(handler.getCoffeePrice()));
	}
}
