/**
 * Sample Skeleton for 'calcGUI.fxml' Controller Class
 */

package calc;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="clear"
	private Button clear; // Value injected by FXMLLoader

	@FXML // fx:id="divide"
	private Button divide; // Value injected by FXMLLoader

	@FXML // fx:id="eight"
	private Button eight; // Value injected by FXMLLoader

	@FXML // fx:id="equals"
	private Button equals; // Value injected by FXMLLoader

	@FXML // fx:id="five"
	private Button five; // Value injected by FXMLLoader

	@FXML // fx:id="four"
	private Button four; // Value injected by FXMLLoader

	@FXML // fx:id="minus"
	private Button minus; // Value injected by FXMLLoader

	@FXML // fx:id="multiply"
	private Button multiply; // Value injected by FXMLLoader

	@FXML // fx:id="nine"
	private Button nine; // Value injected by FXMLLoader

	@FXML // fx:id="one"
	private Button one; // Value injected by FXMLLoader

	@FXML // fx:id="output"
	private TextField output; // Value injected by FXMLLoader

	@FXML // fx:id="plus"
	private Button plus; // Value injected by FXMLLoader

	@FXML // fx:id="seven"
	private Button seven; // Value injected by FXMLLoader

	@FXML // fx:id="six"
	private Button six; // Value injected by FXMLLoader

	@FXML // fx:id="three"
	private Button three; // Value injected by FXMLLoader

	@FXML // fx:id="two"
	private Button two; // Value injected by FXMLLoader

	@FXML // fx:id="zero"
	private Button zero; // Value injected by FXMLLoader

	@FXML
	void action(ActionEvent event) {
	    Button button = (Button) event.getSource();

	    // Get the text of the clicked button
	    String buttonText = button.getText();

	    // Check if the output text is "Error" and clear it if so
	    if (output.getText().equals("Error")) {
	        output.clear();
	    }

	    // Update the label text based on the button clicked
	    String currentText = output.getText();
	    output.setText(currentText + buttonText);
	}

	@FXML
	void clear(ActionEvent event) {
	    // Clear the label text
	    output.setText("");
	}

	@FXML
	void equals(ActionEvent event) {
	    // Get the current text of the label
	    String expression = output.getText();

	    try {
	        // Evaluate the expression
	        double result = evaluateExpression(expression);

	        // Update the label with the result
	        output.setText(Double.toString(result));
	    } catch (Exception e) {
	        // If there's an error during evaluation, display an error message
	        output.setText("Error");
	    }
	}

	protected double evaluateExpression(String expression) {
	    // Extract the operator and operands
	    String operator = "";
	    String[] operands;

	    // Check for multiplication first
	    if (expression.contains("x")) {
	        operator = "x";
	        operands = expression.split("x");
	    } else if (expression.contains("+")) {
	        operator = "+";
	        operands = expression.split("\\+");
	    } else if (expression.contains("-")) {
	        operator = "-";
	        operands = expression.split("-");
	    } else if (expression.contains("/")) {
	        operator = "/";
	        operands = expression.split("/");
	    } else {
	        throw new IllegalArgumentException("Invalid expression");
	    }

	    // Parse the operands
	    double operand1 = Double.parseDouble(operands[0]);
	    double operand2 = Double.parseDouble(operands[1]);

	    // Perform the calculation based on the operator
	    switch (operator) {
	        case "+":
	            return operand1 + operand2;
	        case "-":
	            return operand1 - operand2;
	        case "x":
	            return operand1 * operand2;
	        case "/":
	            if (operand2 == 0) {
	                throw new ArithmeticException("Division by zero");
	            }
	            return operand1 / operand2;
	        default:
	            throw new IllegalArgumentException("Invalid operator");
	    }
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
	    assert clear != null : "fx:id=\"clear\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert divide != null : "fx:id=\"divide\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert eight != null : "fx:id=\"eight\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert equals != null : "fx:id=\"equals\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert five != null : "fx:id=\"five\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert four != null : "fx:id=\"four\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert minus != null : "fx:id=\"minus\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert multiply != null : "fx:id=\"multiply\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert nine != null : "fx:id=\"nine\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert one != null : "fx:id=\"one\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert output != null : "fx:id=\"output\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert plus != null : "fx:id=\"plus\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert seven != null : "fx:id=\"seven\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert six != null : "fx:id=\"six\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert three != null : "fx:id=\"three\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert two != null : "fx:id=\"two\" was not injected: check your FXML file 'calcGUI.fxml'.";
	    assert zero != null : "fx:id=\"zero\" was not injected: check your FXML file 'calcGUI.fxml'.";
	}



}
