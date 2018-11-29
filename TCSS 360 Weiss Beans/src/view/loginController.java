package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class loginController extends Application{

	Scene scene1;
	
	@Override
	public void start(Stage appStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root;
	
	    	
	    	
	    	root = FXMLLoader.load(getClass().getResource("login_window.fxml"));
	    	scene1= new Scene(root);
	        appStage.setScene(scene1);
	    	appStage.setTitle("Log-in");
	        appStage.setScene(scene1);
	        appStage.show();	
		
		
	}
	
	
    @FXML
    private Button btnNew;

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnCurrent;

    public static void main(String args[]) {
    	launch(args);
    }

}
