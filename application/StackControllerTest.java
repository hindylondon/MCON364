package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import java.util.concurrent.CountDownLatch;

class StackControllerTest{
	
    private StackController controller;



    @BeforeEach
    public void setUp() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Platform.startup(() -> {
            // Initialize JavaFX components here
            controller = new StackController();
            controller.controls = new HBox();
            controller.displayLabel = new Label();
            controller.popButton = new Button();
            controller.pushButton = new Button();
            controller.root = new VBox();
            controller.scrollPane = new ScrollPane();
            controller.stackContainer = new VBox();
            controller.textFieldInput = new TextField();
            
            // Count down the latch to signal that initialization is complete
            latch.countDown();
        });

        // Wait for initialization to complete
        latch.await();
    }

	
	@Test
	void testPushButton() {
		
		ActionEvent event = new ActionEvent();
		
		controller.textFieldInput.setText("Valid");
		
		controller.pushAction(event);
		
		assertEquals("Valid", 
				((Rectangle)controller.stackContainer.getChildren().get(0)).getUserData());
	}
	
	@Test
	void testPopButtonWithNonEmptyStack() {
		ActionEvent event = new ActionEvent();
		
		controller.textFieldInput.setText("Valid");
		
		controller.pushAction(event);
		
		controller.popAction(event);
		
		assertEquals(0, controller.stackContainer.getChildren().size());
	}
	
	@Test
	void testPopButtonWithEmptyStack() {
		ActionEvent event = new ActionEvent();
		
		controller.popAction(event);
		
		assertEquals("The Stack is Empty", controller.displayLabel.getText());
	}
	
    @Test
    public void testInitialize() {
        // Execute
        controller.initialize();

        // Verify
        assertNotNull(controller.controls);
        assertNotNull(controller.displayLabel);
        assertNotNull(controller.popButton);
        assertNotNull(controller.pushButton);
        assertNotNull(controller.root);
        assertNotNull(controller.scrollPane);
        assertNotNull(controller.stackContainer);
        assertNotNull(controller.textFieldInput);
    }
    
    @Test
    public void testPushActionWithEmptyInput() {
        // Set up
        controller.textFieldInput.setText("");

        // Execute
        controller.pushAction(new ActionEvent());

        // Verify
        assertEquals(0, controller.stackContainer.getChildren().size());
    }

}
