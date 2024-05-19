package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class StackController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="controls"
    protected HBox controls; // Value injected by FXMLLoader

    @FXML // fx:id="displayLabel"
    protected Label displayLabel; // Value injected by FXMLLoader

    @FXML // fx:id="popButton"
    protected Button popButton; // Value injected by FXMLLoader

    @FXML // fx:id="pushButton"
    protected Button pushButton; // Value injected by FXMLLoader

    @FXML // fx:id="root"
    protected VBox root; // Value injected by FXMLLoader

    @FXML // fx:id="scroolPane"
    protected ScrollPane scrollPane; // Value injected by FXMLLoader

    @FXML // fx:id="stackContainer"
    protected VBox stackContainer; // Value injected by FXMLLoader

    @FXML // fx:id="textFieldInput"
    protected TextField textFieldInput; // Value injected by FXMLLoader

    @FXML
    //removes the top member of the stack
    void popAction(ActionEvent event) {
    	//check if there are any boxes
    	if (stackContainer.getChildren().isEmpty()) {
    		displayLabel.setText("The Stack is Empty");
    		return;
    	}
    	
    	//remove the top box from the stack
    	Rectangle topBox = (Rectangle) stackContainer.getChildren().remove(0);
    	
    	//get info from the box
    	String value = (String) topBox.getUserData();
    	
    	//animate the box being removed
    	TranslateTransition transition = new TranslateTransition(Duration.seconds(.5));
    	transition.setFromY(0);
    	transition.setToY(-30);
    	//show which one is being popped
    	transition.setOnFinished(e -> {
    		displayLabel.setText("Popped: " + value);
    	});
    	transition.play();

    }

    //user inputs the number they want to add to the stack and it is added to the top of the stack
    @FXML
    void pushAction(ActionEvent event) {
    	//set the new box to be the inputted number
    	String value = (String) textFieldInput.getText();
    	
    	//create new box
    	Rectangle newBox = new Rectangle(100, 30);
    	newBox.setUserData(value);
    	stackContainer.getChildren().add(0, newBox);
    	
    	//clear the text box
    	textFieldInput.clear();
    	
    	//animate the new box being added
    	TranslateTransition transition = new TranslateTransition(Duration.seconds(.5));
    	transition.setFromY(-30);
    	transition.setToY(0);
    	transition.play();

    }
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    //all the initialize statements
    void initialize() {
        assert controls != null : "fx:id=\"controls\" was not injected: check your FXML file 'Stack.fxml'.";
        assert displayLabel != null : "fx:id=\"displayLabel\" was not injected: check your FXML file 'Stack.fxml'.";
        assert popButton != null : "fx:id=\"popButton\" was not injected: check your FXML file 'Stack.fxml'.";
        assert pushButton != null : "fx:id=\"pushButton\" was not injected: check your FXML file 'Stack.fxml'.";
        assert root != null : "fx:id=\"root\" was not injected: check your FXML file 'Stack.fxml'.";
        assert scrollPane != null : "fx:id=\"scroolPane\" was not injected: check your FXML file 'Stack.fxml'.";
        assert stackContainer != null : "fx:id=\"stackContainer\" was not injected: check your FXML file 'Stack.fxml'.";
        assert textFieldInput != null : "fx:id=\"textFieldInput\" was not injected: check your FXML file 'Stack.fxml'.";

    }

}
