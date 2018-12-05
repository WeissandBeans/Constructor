package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewUserView {

    @FXML
    private TextField newName;

    @FXML
    private Button startBtn;

    @FXML
    private Label emailLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private TextField newEmail;

    @FXML
    void startButtonAction(ActionEvent event) {
    		//set name and email
    		//change scene to profile
    	
    	appGUI.setScene(getClass().getResource("ProjectListView.fxml"));
    }
}