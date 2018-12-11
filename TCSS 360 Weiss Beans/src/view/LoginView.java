package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginView {
	
    @FXML
    private Button btnNew;

    @FXML
    private Button btnLoad;
    
    @FXML
    private Button btnCurrent;
    
    @FXML
    void currentButtonAction(ActionEvent event) {
    	appGUI.setScene(getClass().getResource("Profile_window.fxml"));
    }
    
    @FXML
    void newUserBtn(ActionEvent event) {
    	appGUI.setScene(getClass().getResource("new_user_window.fxml"));

    }
    
	Scene loginView;
	
	

}
