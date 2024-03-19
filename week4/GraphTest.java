package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphTest {
	

	@Test
	void testIfIsPathBFWithString() {
		Graph<String> s = new Graph<>();
		
		s.addVertex("hello");
		s.addVertex("bye");
		
		s.addEdge("hello", "bye");
		
		assertTrue(s.isPathBF("hello", "bye"));
	}
	
	@Test
	void testIfIsPathBFWithInt() {
		Graph<Integer> s = new Graph<>();
		
		s.addVertex(10);
		s.addVertex(4);
		
		s.addEdge(10, 4);
		
		assertTrue(s.isPathBF(10, 4));
	}
	
	@Test
	void testIfIsPathBFWithDouble() {
		Graph<Double> s = new Graph<>();
		
		s.addVertex(5.5);
		s.addVertex(2.7);
		
		s.addEdge(5.5, 2.7);
		
		assertTrue(s.isPathBF(5.5, 2.7));
	}
	
	@Test
	void testIfNotIsPathBFWithString() {
		Graph<String> s = new Graph<>();
		
		s.addVertex("hello");
		s.addVertex("bye");
		
		s.addEdge("hello", "bye");
		
		assertFalse(s.isPathBF("hello", "hi"));
	}
	
	@Test
	void testIfNotIsPathBFWithInt() {
		Graph<Integer> s = new Graph<>();
		
		s.addVertex(10);
		s.addVertex(4);
		
		s.addEdge(10, 4);
		
		assertFalse(s.isPathBF(10, 7));
	}
	
	@Test
	void testIfNotIsPathBFWithDouble() {
		Graph<Double> s = new Graph<>();
		
		s.addVertex(5.5);
		s.addVertex(2.7);
		
		s.addEdge(5.5, 2.7);
		
		assertFalse(s.isPathBF(5.5, 6.9));
	}

}
