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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * This is the controller that binds to the DonutView.
 *
 * @author Divya Bhuva, Dorothy Wu
 */
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


    @FXML
    private TextArea Logger;

	private final ObservableList<String> DountTypeList = FXCollections.observableArrayList();

    private final ObservableList<String> FlavorListData = FXCollections.observableArrayList();

	private final ObservableList<String> PlaceDountOrderListData = FXCollections.observableArrayList();

	private static final int START_COUNT = 1;

	/**
	 * This initializes the DonutView
	 * @param arg0 is the URL.
	 * @param arg1 is the resource bundle given by the fxml loader.
	 */
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	DonuteTypeComboBox.setItems(DountTypeList);
    	FlowersList.setItems(FlavorListData);
    	FlowersList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	
    	DonuteTypeComboBox.setValue(new YeastDonut().getDonutName());
    	
    	NumberOfCountComboBox.setValue(String.valueOf(START_COUNT));
    	
    	DounteOrderListBox.setItems(PlaceDountOrderListData);
    	DounteOrderListBox.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    	
    	
	}

	/**
	 * This is the method that is executed whenever the AddToListButton is pressed.
	 * @param event, the captured event.
	 */
	@FXML
    void AddToListButtonPress(ActionEvent event) {
    	String typeOfDounte  = DonuteTypeComboBox.getSelectionModel().getSelectedItem();
    	String flower = FlowersList.getSelectionModel().getSelectedItem();
    	int count = NumberOfCountComboBox.getSelectionModel().getSelectedIndex() + START_COUNT;
    	
    	CafeHandler handler = mainController.getCafeHandler();
    	handler.addDounteToList(typeOfDounte, flower, count);
    	
    	String info = typeOfDounte +"["+flower+"]"+"["+count+"]";
    	PlaceDountOrderListData.add(info);
    	DounteAmountTextField.setText(handler.getTotalPriceForDonut());
    	
    	if(PlaceDountOrderListData.size() == START_COUNT) {
    		DounteOrderListBox.getSelectionModel().selectFirst();
    	}
    }

	/**
	 * This is the method that is executed whenever the DonuteType is selected.
	 * @param event, the captured event.
	 */
	@FXML
    void DonuteTypeValueChange(ActionEvent event) {
    	CafeHandler handler = mainController.getCafeHandler();
    	String selectedType = DonuteTypeComboBox.getSelectionModel().getSelectedItem();
    	
    	FlavorListData.clear();
    	FlavorListData.addAll(handler.getDountsFlavor(selectedType));
    	FlowersList.getSelectionModel().selectFirst();
    	
    }

	/**
	 * This is the method that is executed whenever RemoveFromListButton is pressed.
	 * @param event, the captured event.
	 */
	@FXML
    void RemoveFromListButtonPress(ActionEvent event) {
    	if (!DounteOrderListBox.getSelectionModel().isEmpty()) {
    		String selectedText = DounteOrderListBox.getSelectionModel().getSelectedItem();
    		int index = PlaceDountOrderListData.indexOf(selectedText);
    	
    		PlaceDountOrderListData.remove(index);
    		CafeHandler handler = mainController.getCafeHandler();
    		handler.removeDounteFromList(index);
    		
    		DounteAmountTextField.setText(handler.getTotalPriceForDonut());
    	}
    	else {
    		Logger.appendText("Dounts List is empty.\n");
    	}
    }

	/**
	 * This is the method that is executed whenever AddToOrderButton is pressed.
	 * @param event, the captured event.
	 */
	@FXML
    void AddToOrderButtonPress(ActionEvent event) {
    	
    	CafeHandler handler = mainController.getCafeHandler();
		
    	Logger.clear();
    	
    	if (handler.getNumberOfOrderDonuts() == 0) {
    		Logger.appendText("Dounts List is empty.\n");
    	}
    	if (handler.addToDonutsOrder()) {
    		PlaceDountOrderListData.clear();
    		DounteAmountTextField.setText(handler.getTotalPriceForDonut());
    		Logger.appendText("Dounts List is added to Current order.\n");
    	}
  }

	/**
	 * This sets the main controller.
	 * @param controller to set the current controller equal to.
	 */
	public void setMainController(MainScreenController controller) {
		mainController = controller;
		
		CafeHandler handler = mainController.getCafeHandler();
    	DountTypeList.addAll(handler.getTypesOfDounts());

    	FlavorListData.addAll(handler.getDountsFlavor(new YeastDonut().getDonutName()));
    	FlowersList.getSelectionModel().selectFirst();
    	
    	for(int index = START_COUNT; index <= handler.getMaxCount(); index++) {
    		NumberOfCountComboBox.getItems().add(String.valueOf(index));
    	}
    	
    	DounteAmountTextField.setText(handler.getTotalPriceForDonut());
	}
	
	
}
