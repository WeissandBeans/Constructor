package view;

import java.math.BigDecimal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Profile;
/*
 * The whole class
 * @author Tien Ortman
 */
public class ProfileView {
		Profile myProfile = new Profile();
		
		//String myName = myProfile.getProfileName();
		String myComplete = String.valueOf(myProfile.getSavings());
		String mySavings = String.valueOf(myProfile.getCompletedCount());
		String myCount = String.valueOf(myProfile.getProjectCount());
		
		String myName = "Tien Ortman";

		
		
	    @FXML
	    private Label total;
	    

	    @FXML
	    private Label completed;

	    @FXML
	    private Label savings;
	    
		// get the name of user
		@FXML
		private Label lblName;
	    
	    
	    //get the complete project count
	    @FXML
		private Label lblCompleteCount;
	    
		
		//get the total project count
		@FXML
		private Label lblgetProjectCount;
		//get savings value
		@FXML
		private Label lblSavings;
		
		
		@FXML
		private void initialize() {
			
			lblName.setText(myName);
			lblCompleteCount.setText(myComplete);
			lblgetProjectCount.setText(myCount);
			lblSavings.setText(mySavings);
		}
		
	    @FXML
	    private Button goToProjects;
	    

	    @FXML
	    void goToProjectScene(ActionEvent event) {
	    	appGUI.setScene(getClass().getResource("ProjectListView.fxml"));
	    }
		
		
//    public static void main(String args[]) {
//    	launch(args);
//    }
}
