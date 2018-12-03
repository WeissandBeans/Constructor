package view;
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
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.scene.Parent;

public class CreateProjectView {
	
	@FXML
    private Button btnEditProject;

    @FXML
    private Button btnBack;

    @FXML
    private Label lblProjectName;

    @FXML
    private TextField txtNotes;

    @FXML
    private TextField txtSavings;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtMats;

    @FXML
    void btnDeleteProjectAction(ActionEvent event) {

    }

    @FXML
    void btnEditProjectAction(ActionEvent event) {

    }

    @FXML
    void brnCompleteProject(ActionEvent event) {
    	appGUI.setScene(getClass().getResource("ProjectListView.fxml"));
    }

    @FXML
    void btnBackAction(ActionEvent event) {

    }

	
}
