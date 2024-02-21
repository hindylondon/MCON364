package week2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BSTTest {
	

	@Test
	void testThatItAddsStringToBST() {
		BST<String> bst = new BST<>();
		
		assertTrue(bst.add("Hello"));
	}
	
	@Test
	void testThatItAddsIntToBST() {
		BST<Integer> bst = new BST<>();
		
		assertTrue(bst.add(4));
	}
	
	@Test
	void testThatItAddsDoubleToBST() {
		BST<Double> bst = new BST<>();
		
		assertTrue(bst.add(3.2));
	}
	
	@Test
	void testThatItContainsAStringThatIsAddedToBST() {
		BST<String> bst = new BST<>();
		bst.add("Hello");
		assertTrue(bst.contains("Hello"));
	}
	
	@Test
	void testThatItContainsAnIntThatIsAddedToBST() {
		BST<Integer> bst = new BST<>();
		bst.add(4);
		assertTrue(bst.contains(4));
	}
	
	@Test
	void testThatItContainsADoubleThatIsAddedToBST() {
		BST<Double> bst = new BST<>();
		bst.add(3.2);
		assertTrue(bst.contains(3.2));
	}


}
