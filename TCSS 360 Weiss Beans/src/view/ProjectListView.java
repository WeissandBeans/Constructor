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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ProjectListView {
	
	//TODO: Table views should represent objects
	
    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSavings;

    @FXML
    private TableView<?> tblProjects;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colMaterials;

    @FXML
    private Button btnAddProject;

    @FXML
    void addProjectAction(ActionEvent event) {
    	appGUI.setScene(getClass().getResource("CreateProjectView.fxml"));
    }

}
