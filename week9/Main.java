package calc;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {	
	@Override
	public void start(Stage primaryStage) {
	    try {
	        // Load the FXML file
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("calcGUI.fxml"));

	        // Set the root element to a new VBox
	        VBox root = new VBox();
	        loader.setRoot(root);

	        // Load the FXML file
	        loader.load();

	        // Create and configure the scene
	        Scene scene = new Scene(root, 400, 400);
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

	        // Set the scene to the stage and show
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
