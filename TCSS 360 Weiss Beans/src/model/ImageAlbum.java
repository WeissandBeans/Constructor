package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * 
 * @author Chris Walsh
 *
 */
public class ImageAlbum extends Application {
	
	public static final int THUMBNAIL_SIZE = 100;
	public static final int TILE_GAP = 12;
	public static final int WINDOW_WIDTH = 400;
	public static final int WINDOW_HEIGHT = 600;
	
    Stage stage;
    Scene thumbnailScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
        stage = primaryStage;
        ScrollPane root = new ScrollPane();
        TilePane tile = new TilePane();
        root.setStyle("-fx-background-color: DAE6F3;");
        tile.setPadding(new Insets(TILE_GAP, TILE_GAP, TILE_GAP, TILE_GAP));
        tile.setHgap(TILE_GAP);
        tile.setVgap(TILE_GAP);

        String path = "./testImages";

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (final File file : listOfFiles) {
        		if (file.getName().charAt(0) != '.') {
                ImageView imageView;
                imageView = createImageView(file);
                tile.getChildren().addAll(imageView);
        		}
        }


        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setFitToWidth(true);
        root.setContent(tile);

        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        
        Scene scene = new Scene(root);
        thumbnailScene = scene;
        primaryStage.setScene(thumbnailScene);
        primaryStage.show();

    }

    private ImageView createImageView(final File imageFile) {

        ImageView imageView = null;
        try {
        		
        		final Image sourceImage = new Image(new FileInputStream(imageFile));
            
        		if (sourceImage.getWidth() >= sourceImage.getHeight()) {
        			final Image image = new Image(new FileInputStream(imageFile), 
							 				 THUMBNAIL_SIZE, 0, true, true);
        			
        			imageView = new ImageView(image);
        			imageView.setFitWidth(THUMBNAIL_SIZE);
        		} else {
        			final Image image = new Image(new FileInputStream(imageFile), 
							 				 0, THUMBNAIL_SIZE, true, true);
        			
        			imageView = new ImageView(image);
        			imageView.setFitHeight(THUMBNAIL_SIZE);
        		}
        		
        		imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent mouseEvent) {

                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY) 
                    		&& mouseEvent.getClickCount() == 2){
                    			try {
	                    			BorderPane borderPane = new BorderPane();
	                    			ImageView imageView = new ImageView();
	                    			Image image = new Image(new FileInputStream(imageFile));
	                             imageView.setImage(image);
	                             imageView.setStyle("-fx-background-color: BLACK");
	                             imageView.setFitWidth(stage.getWidth() - 10);
	                             imageView.setPreserveRatio(true);
	                             imageView.setSmooth(true);
	                             imageView.setCache(true);
	                             borderPane.setCenter(imageView);
	                             borderPane.setStyle("-fx-background-color: BLACK");
	                             
	                             
	                             borderPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
									@Override
									public void handle(MouseEvent event) {
										if(event.getButton().equals(MouseButton.PRIMARY) 
					                    		&& event.getClickCount() == 2){
											stage.setScene(thumbnailScene);
										}
									}
								});
	                             
	                             Scene scene = new Scene(borderPane,Color.BLACK);
	                             stage.setScene(scene);
                    			} catch (FileNotFoundException e) {
                                e.printStackTrace();
                    			}
                    }
                }
            });
        		} catch (FileNotFoundException ex) {
        			ex.printStackTrace();
        		}
        		return imageView;
        }

        public static void main(String[] args) {
        		launch(args);
    		}
    }