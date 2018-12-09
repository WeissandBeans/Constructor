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

public class ProjectListView {
	
	//TODO: Table views should represent objects
	/**
     * @author Samantha
     */
	
	ObservableList<Project> projects;
	
	public void initialize() {
		projects = FXCollections.observableArrayList();
       //model.Profile user = appGUI.getUser();
       //for(Project p : user.getProjects()) {
    //	   projects.add(p);
    //   }
		projects.add(new Project("Sample", "test project", new BigDecimal("42.0"), 
				new BigDecimal("69.0"), null, 69, "PLACEHOLDER"));
       
       colName.setCellValueFactory(
    		    new PropertyValueFactory<Project,String>("Name")
    		);
    		//colMaterials.setCellValueFactory(
    		//    new PropertyValueFactory<Project,String>("lastName")
    		//);
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
     * @author Samantha
     */
    @FXML
    void addProjectAction(ActionEvent event) {
    	appGUI.setScene(getClass().getResource("CreateProjectView.fxml"));
    }

}
