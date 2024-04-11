package calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTests {

	@Test
	void testThatItSubtractsBelowZero() {
		CalculatorController calc = new CalculatorController();
		double result = calc.evaluateExpression("2-3");
		assertEquals(-1.0, result, 0.0001);
		
	}
	
	@Test
	void testThatItDividesSmallerNumbersIntoBigger() {
		CalculatorController calc = new CalculatorController();
		double result = calc.evaluateExpression("2/3");
		assertEquals(0.66666666666, result, 0.0001);
		
	}
	
	@Test
	void testThatItMultipliesCorrectly() {
		CalculatorController calc = new CalculatorController();
		double result = calc.evaluateExpression("2x3");
		assertEquals(6.0, result, 0.0001);
		
	}
	
	@Test
	void testThatItSubtractsCorrectly() {
		CalculatorController calc = new CalculatorController();
		double result = calc.evaluateExpression("3-2");
		assertEquals(1.0, result, 0.0001);
		
	}
	
	@Test
	void testThatItAddsCorrectly() {
		CalculatorController calc = new CalculatorController();
		double result = calc.evaluateExpression("3+2");
		assertEquals(5.0, result, 0.0001);
		
	}
	
	@Test
	void testThatItDividesCorrectly() {
		CalculatorController calc = new CalculatorController();
		double result = calc.evaluateExpression("6/2");
		assertEquals(3.0, result, 0.0001);
		
	}
	
	
		

}
