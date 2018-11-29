package view;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/*
 * The whole class
 * @author Tien Ortman
 */
public class profileController extends Application {

	Scene scene1;
	
	@Override
	public void start(Stage appStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root;
	
	    	
	    	
	    	root = FXMLLoader.load(getClass().getResource("Profile_window.fxml"));
	    	scene1= new Scene(root);
	        appStage.setScene(scene1);
	    	appStage.setTitle("Profile");
	        appStage.setScene(scene1);
	        appStage.show();	
		
		
	}

	
	


	    @FXML
	    private Label total;


	    @FXML
	    private Label completed;

	    @FXML
	    private Label savings;
	    
	    @FXML
		private Label lblCompleteCount;
		 
		@FXML
		private Label lblName;

		@FXML
		private Label lblgetProjectCount;

		@FXML
		private Label lblSavings;
		
		
//    public static void main(String args[]) {
//    	launch(args);
//    }
}
