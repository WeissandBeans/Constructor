package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.scene.Parent;
@SuppressWarnings("restriction")
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harrison
 * @editor Tien
 * @editor Samantha
 */
                      

public class appGUI extends Application {
	/**
	 * The main stage for this application.
	 */
	
	
	String PROFILE_PATH = "./Profiles";

	private static Stage myStage;
	Scene currentScene;
	Scene loginView;
	protected Scene profileView;
	Scene projectListView;
	Scene projectView;
	Button btnAbout;
	private static model.Profile user;

	private final String VERSION = "0.0.1";
	
    @Override
    /**
     * Starts the application and sets up the initial scene.
     * Inherited from the Application class.
     * @author Samantha
     */
	public void start(Stage appStage) throws Exception {
    	
    		boolean newProfileFolder = new File(PROFILE_PATH).mkdirs();
    	
    		myStage = appStage;
    	
    		Parent root;
    		root = FXMLLoader.load(getClass().getResource("Main_Window.fxml"));
    		currentScene = new Scene(root);
    		
    		myStage.setScene(currentScene);
    		myStage.show();
	}
    
    
    /**
     * Loads and sets the scene associated with the given URL.
     * @author Samantha
     * @param viewURL The URL for the FXML scene file to load.
     * @return The scene that was loaded.
     */
    protected static Object setScene(URL viewURL) {
    	
    	FXMLLoader loader = new FXMLLoader(viewURL);
    	try {
    		Parent root;
    		root = loader.load();
    		myStage.setScene(new Scene(root));
			myStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	return loader.getController();
    }
    
    
    /**
     * Handler for About button. Shows program information.
     * @author Samantha
     */
    @FXML
    private void aboutButtonAction(ActionEvent event) {
        // Button was clicked, do something
        showAboutScreen(VERSION);
    }
    
    /**
     * Handler for the Start button. Moves to the entry point for the application.
     * @author Samantha
     */
    @FXML
    void startButtonAction(ActionEvent event) {
    	appGUI.setScene(getClass().getResource("ProjectListView.fxml"));
    	
    }
    
    /**
     * Event handler to show the about screen.
     * @author Samantha
     */
    @FXML
    private void showAboutScreen(String version) {
    		JOptionPane.showMessageDialog(null, "Constructor\n By Weiss and Beans Team\n Version: " 
    										+ version);
    }
    
    /**
     * Returns the current user profile. for this application.
     * @author Samantha
     */
    protected static model.Profile getUser() {
    	return user;
    }
    


    /**
     * Main method. Since this is a javaFX application, it just calls launch().
     * To change what the application does at launch, 
     * edit appGUI.Start instead.
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    		launch(args);
    }
 
    
    
	
}
