package application;

//imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;


public class Main extends Application {
	//the start sets the stage
	@Override
	public void start(Stage primaryStage) {
		try {
			//connect to the fxml and load it up
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Stack.fxml"));
			VBox root = loader.load();
			Scene scene = new Scene(root);
			
			//connect to the stylesheets and show scenes
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		//error catching
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//launch the whole program
	public static void main(String[] args) {
		launch(args);
	}
}

