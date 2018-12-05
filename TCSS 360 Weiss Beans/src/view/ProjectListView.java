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
import javafx.stage.Stage;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProjectListView {
	
	//TODO: Table views should represent objects
	
	public void initialize() {
       model.Profile user = appGUI.getUser();
       //for each project in user
       //populate the table with that project data!
    }
	
    @FXML
    private TableColumn<TableView<model.Project>, String> colName;

    @FXML
    private TableColumn<TableView<model.Project>, BigDecimal> colSavings;

    @FXML
    private TableView<model.Project> tblProjects;

    @FXML
    private TableColumn<TableView<model.Project>, BigDecimal> colCost;

    @FXML
    private TableColumn<TableView<model.Project>, String> colMaterials;

    @FXML
    private Button btnAddProject;

    @FXML
    void addProjectAction(ActionEvent event) {

    }

}
