package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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

    private ObservableList<String> DountTypeList = FXCollections.observableArrayList(); 	
    private ObservableList<String> FlavorListData = FXCollections.observableArrayList();
    
    private static final int STARTCOUNT = 1;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	DonuteTypeComboBox.setItems(DountTypeList);
    	FlowersList.setItems(FlavorListData);
    	FlowersList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	
    	DonuteTypeComboBox.setValue(new YeastDonut().getDountName());
    	
    	NumberOfCountComboBox.setValue(String.valueOf(STARTCOUNT));
    	
	}
    
    
    @FXML
    void AddToListButtonPress(ActionEvent event) {
    	
    }

    @FXML
    void DonuteTypeValueChange(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
    	String selectedType = DonuteTypeComboBox.getSelectionModel().getSelectedItem();
    	
    	FlavorListData.clear();
    	FlavorListData.addAll(handler.getDountsFlavor(selectedType));
    	
    	
    }

    @FXML
    void RemoveFromListButtonPress(ActionEvent event) {

    }
	

	
	public void setMainController(MainScreenController controller) {
		mainController = controller;
		
		CafeHandler handler = mainController.getCafeHandler();
    	DountTypeList.addAll(handler.getTypesOfDounts());

    	FlavorListData.addAll(handler.getDountsFlavor(new YeastDonut().getDountName()));
    	FlowersList.getSelectionModel().selectFirst();
    	
    	for(int index = STARTCOUNT ; index <= handler.getMaxDocuntCount(); index++) {
    		NumberOfCountComboBox.getItems().add(String.valueOf(index));
    	}
	} 
}
