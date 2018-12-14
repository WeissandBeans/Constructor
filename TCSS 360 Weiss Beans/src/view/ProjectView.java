/**
 * @author Samantha
 */

package view;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Project;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.scene.Parent;

public class ProjectView extends ProjectBasedController {
	
	/**
	 * Populates the Project View with the fields for its associated project.
	 * @author Samantha
	 */
	public void populate(){
	    	lblProjectName.setText(this.project.getName());
	    	lblNotes.setText(this.project.getNotes());
	    	lblSavings.setText(this.project.getSavings().toString());
	    	lblCost.setText(this.project.getCost().toString());
	    	//lblMats.setText(this.project.getMaterial().getName());
	    }

	    @FXML
	    private Button btnEditProject;

	    @FXML
	    private Button btnBack;

	    @FXML
	    private Label lblProjectName;

	    @FXML
	    private Label lblNotes;

	    @FXML
	    private Label lblSavings;

	    @FXML
	    private Label lblMats;

	    @FXML
	    private Label lblCost;

	    
	    /**
	     * Deletes the project being viewed from the user's profile.
	     * @param event The event associated with the button being pressed.
	     * @author Samantha
	     */
	    @FXML
	    void btnDeleteProjectAction(ActionEvent event) {
	    	
	    	for (Project p : appGUI.getUser().getProjects()) {
    			if (p.getName().equals(this.project.getName())) {
    				appGUI.getUser().getProjects().remove(p);
    			}
    		}
	    	appGUI.setScene(getClass().getResource("ProjectListView.fxml"));
	    	
	    }

	    
	    /**
	     * Event handler for the "edit project" button. Opens the create project window 
	     * to edit the currently viwed project.
	     * @param event The event associated with the button being pressed
	     * @author Samantha
	     */
	    @FXML
	    void btnEditProjectAction(ActionEvent event) {
	    	CreateProjectView v = (CreateProjectView)appGUI.setScene(getClass().getResource("CreateProjectView.fxml"));
	    	v.setProject(this.project);
	    	v.populate();
	    }

	    /**
	     * Event handler for the 'back' button. Returns to the project list.
	     * @param event The event associated with the button being pressed.
	     * @author Samantha
	     */
	    @FXML
	    void btnBackAction(ActionEvent event) {
	    	appGUI.setScene(getClass().getResource("ProjectListView.fxml"));
	    }




}
