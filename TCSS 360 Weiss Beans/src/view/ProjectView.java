/**
 *
 * @author Samantha
 */

package view;
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
	    	lblMats.setText(this.project.getMaterial());
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

	    @FXML
	    void btnDeleteProjectAction(ActionEvent event) {
	    	System.out.println("BALEETED!");
	    }

	    @FXML
	    void btnEditProjectAction(ActionEvent event) {
	    	appGUI.setScene(getClass().getResource("CreateProjectView.fxml"));
	    }

	    @FXML
	    void btnBackAction(ActionEvent event) {
	    	appGUI.setScene(getClass().getResource("ProjectListView.fxml"));
	    }




}
