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
import model.Project;
import javafx.embed.swing.SwingNode;
import javafx.fxml.*;
import javafx.scene.Parent;

public class CreateProjectView {
	
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

    
    /**
     * @author Samantha
     */
    @FXML
    void btnDeleteProjectAction(ActionEvent event) {

    }
    
    /**
     * @author Samantha
     */
    @FXML
    void btnEditProjectAction(ActionEvent event) {

    }

    
    /**
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
    	Project proj = new Project(name, desc, cost, savings, null, notes, savings.intValue());
    }

    
    /**
     * @author Samantha
     */
    @FXML
    void btnBackAction(ActionEvent event) {

    }

	
}
