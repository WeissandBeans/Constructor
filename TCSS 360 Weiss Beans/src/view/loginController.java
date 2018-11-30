package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class loginController extends appGUI {
	
    @FXML
    private Button btnNew;

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnCurrent;
    
	Scene loginView;
	
	@Override
	public void start(Stage appStage) throws Exception {

		Parent root;
	    	root = FXMLLoader.load(getClass().getResource("login_window.fxml"));
	    	
	    	loginView = new Scene(root);
	    	appStage.setScene(loginView);
	    	appStage.setTitle("Log-in");
	    	appStage.setScene(loginView);
	    	appStage.show();	
	    	
	    	btnCurrent.setOnAction((event) -> {
	    		setScene(super.profileView);
	    	});
	   
	}
	
	protected void setScene(Scene scene) {
		super.setScene(scene);
	}

    public static void main(String args[]) {
    		launch(args);
    }

}
