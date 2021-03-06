/**
 *
 * @author Samantha
 */

package view;
import java.math.BigDecimal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArrayBase;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ProjectListView {
	/**
     * @author Samantha
     */
	
	ObservableList<Project> projects;
	
	/**
	 * Initializes the view.
	 * Precondition: AppGUI user is not null
	 * Postcondition: The view is initialized and the projectdata inside of the user is shown
	 * @author Samantha
	 */
	public void initialize() {
	   projects = FXCollections.observableArrayList();
       model.Profile user = appGUI.getUser();
       for(Project p : user.getProjects()) {
    	   projects.add(p);
       }
       
       colName.setCellValueFactory(
    		    new PropertyValueFactory<Project,String>("Name")
    		);
    		colMaterials.setCellValueFactory(
    		    new PropertyValueFactory<Project,String>("Description")
    		);
    		colMaterials.setText("Description");
    		colCost.setCellValueFactory(
    		    new PropertyValueFactory<Project,BigDecimal>("Cost")
    		);
    		colSavings.setCellValueFactory(
    				new PropertyValueFactory<Project, BigDecimal>("Savings")
    		);
    		
    	tblProjects.setItems(projects);
    	//tblProjects.getColumns().clear();
    	//tblProjects.getColumns().addAll(colName, colCost, colSavings);
    	
    	
    }
	
	//Various fields for FXML objects we want access to
    @FXML
    private TableColumn<Project, String> colName;

    @FXML
    private TableColumn<Project, BigDecimal> colSavings;

    @FXML
    private TableView<Project> tblProjects;

    @FXML
    private TableColumn<Project, BigDecimal> colCost;

    @FXML
    private TableColumn<Project, String> colMaterials;

    @FXML
    private Button btnAddProject;

    /**
     * Action handler for clicking the "create project" button.
     * Precondition: The "create project" button is clicked
     * Postcondition: User is brought to the "Create project" view.
     * @author Samantha
     */
    @FXML
    void addProjectAction(ActionEvent event) {
    	appGUI.setScene(getClass().getResource("createProjectView.fxml"));
    }
    
    /**
     * Action handler for clicks on the project Table
     * Precondition: The project table is clicked
     * Postcondition: If applicable, the ProjectView associated with the clicked item is shown
     * @param event The event associated with the action
     * @author Samantha
     */
    @FXML
    void tblClickAction(MouseEvent event) {
    	if (tblProjects.getSelectionModel().getSelectedItem() != null) {
    		ProjectView newView = (ProjectView) appGUI.setScene(getClass().getResource("ProjectView.fxml"));
    		newView.setProject(tblProjects.getSelectionModel().getSelectedItem());
    		newView.populate();
    	}
    	
    }

}
