/**
 *
 * @author Samantha
 */

package view;
import java.math.BigDecimal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Material;
import model.Project;
import javafx.embed.swing.SwingNode;
import javafx.fxml.*;
import javafx.scene.Parent;

public class CreateProjectView extends ProjectBasedController{
	
	@FXML
    private Button btnEditProject;

    @FXML
    private Button btnBack;

    @FXML
    private TextField txtProjectName;

    @FXML
    private TextField txtNotes;

    @FXML
    private TextField txtSavings;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtMats;
    
    @FXML
    private TextField txtDesc;
    
    private boolean editing = false;
    
    
	public void populate(){
    	txtProjectName.setText(this.project.getName());
    	txtNotes.setText(this.project.getNotes());
    	txtSavings.setText(this.project.getSavings().toString());
    	txtCost.setText(this.project.getCost().toString());
    	txtDesc.setText(this.project.getDescription());
    	editing = true;
    	txtMats.setText(this.project.getMaterial().getName());
    }
    
    
    /**
     * Event handler for the 'finish' button. This creates a new project
     * based on the text fields and saves it to the user profile.
     * @author Samantha
     */
    @FXML
    void brnCompleteProject(ActionEvent event) {
    	
    	//parse project parameters
    	String name = txtProjectName.getText();
    	String desc = txtDesc.getText();
    	String notes = txtNotes.getText();
    	String materials = txtMats.getText();
    	BigDecimal cost = new BigDecimal(0);
    	BigDecimal savings = new BigDecimal(0);
    	try {
    		 cost = new BigDecimal(txtCost.getText());
    		 savings = new BigDecimal(txtSavings.getText());
    	}
    	catch (Exception e) {
    		System.out.println("BWRP BRRRRPPP PLACEHOLDER PARSE PROBLEM");
    	}
    	Project proj = new Project(name, desc, cost, savings, new Material(materials, "Placeholder", new BigDecimal("0"), "Placeholder"), notes, savings.intValue());
    	
    	if (editing){
    		for (Project p : appGUI.getUser().getProjects()) {
    			if (p.getName().equals(this.project.getName())) {
    				appGUI.getUser().getProjects().remove(p);
    				appGUI.getUser().getProjects().add(proj);
    			}
    		}
    	}
    	
    	else
    	appGUI.getUser().addProject(proj);
    	
    	appGUI.setScene(getClass().getResource("ProjectListView.fxml"));
    }

    
    /**
     * Event handler for the 'back' button. Returns to the Project List View.
     * @author Samantha
     */
    @FXML
    void btnBackAction(ActionEvent event) {
    	appGUI.setScene(getClass().getResource("ProjectListView.fxml"));
    }

	
}
