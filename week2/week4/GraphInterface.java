package week4;

import java.util.Queue;

//interface for a graph
public interface GraphInterface<T> {
	boolean isEmpty();
	
	boolean isFull();
	
	void addVertex(T vertex);
	
	boolean hasVertex(T vertex);
	
	void addEdge(T fromVertex, T toVertex);
	
	Queue<T> getToVertices(T vertex);
	
	void clearMarks();
	
	void markVertex(T vertex);
	
	boolean isMarked(T vertex);
	
	T getUnmarked();

}
