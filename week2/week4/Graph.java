package week4;

import java.util.LinkedList;
import java.util.Queue;

public class Graph<T> implements GraphInterface<T> {
	//fields
	public static final int NULL_EDGE = 0;
	private static final int DEFCAP = 50;
	private int numVertices;
	private int maxVertices;
	private T[] vertices;
	private int[][] edges;
	private boolean[] marks;

	//constructor
	public Graph() {
		numVertices = 0;
		maxVertices = DEFCAP;
		vertices = (T[]) new Object[DEFCAP];
		marks = new boolean[DEFCAP];
		edges = new int[DEFCAP][DEFCAP];
	}

	//constructor
	public Graph(int maxV) {
		numVertices = 0;
		maxVertices = maxV;
		vertices = (T[]) new Object[maxV];
		marks = new boolean[maxV];
		edges = new int[maxV][maxV];
	}

	@Override
	public boolean isEmpty() {
		// return if its empty
		return numVertices == 0;
	}

	@Override
	public boolean isFull() {
		// return if its full
		return numVertices == maxVertices;
	}

	@Override
	public void addVertex(T vertex) {
		// check if graph is full
		if (!isFull()) {
			// add vertex to the graph
			vertices[numVertices] = vertex;
			
			//sets it in the graph
			for (int i = 0; i < numVertices; i++) {
				edges[numVertices][i] = NULL_EDGE;
				edges[i][numVertices] = NULL_EDGE;
			}

			//add to num vertices
			numVertices++;
		} else {
			System.out.println("Graph is full.");
		}

	}

	private int indexIs(T vertex) {
		// find the index of a vertex
		for (int i = 0; i < numVertices; i++) {
			if (vertex.equals(vertices[i])) {
				return i;
			}
		}
		return -1;

	}

	@Override
	public boolean hasVertex(T vertex) {
		// check if it has vertex
		for (int i = 0; i < numVertices; i++) {
			if (vertex.equals(vertices[i])) {
				// vertex found
				return true;
			}
		}

		// if vertex not found
		return false;
	}

	@Override
	public void addEdge(T fromVertex, T toVertex) {
		// adds edge with specified vertexes
		int fromIndex = indexIs(fromVertex);
		int toIndex = indexIs(toVertex);

		// check if both vertices exist in the graph
		if (fromIndex != -1 && toIndex != -1) {
			edges[fromIndex][toIndex] = 1;
		} else {
			System.out.println("One or both vertices do not exist.");
		}

	}

	@Override
	public Queue<T> getToVertices(T vertex) {
		// returns a queue of adjacent vertices
		Queue<T> adjVertices = new LinkedList<>();
		int fromIndex, toIndex;

		//checks this index
		fromIndex = indexIs(vertex);

		//goes through each edge
		for (toIndex = 0; toIndex < numVertices; toIndex++) {
			if (edges[fromIndex][toIndex] != NULL_EDGE) {
				adjVertices.offer(vertices[toIndex]);
			}
		}

		return adjVertices;
	}

	@Override
	public void clearMarks() {
		// clear all the marks
		for (int i = 0; i < numVertices; i++) {
			marks[i] = false;
		}

	}

	@Override
	public void markVertex(T vertex) {
		// mark an index
		int index = indexIs(vertex);
		if (index != -1) {
			marks[index] = true;
		}

	}

	@Override
	public boolean isMarked(T vertex) {
		// check if vertex is marked
		int index = indexIs(vertex);
		if (index != -1) {
			// returne true if marked
			return marks[index];
		}
		// if not marked, retuirn false
		return false;
	}

	@Override
	public T getUnmarked() {
		// get the unmarked vertices
		for (int i = 0; i < numVertices; i++) {
			if (!marks[i]) {
				//return which vertices are unmarked
				return vertices[i];
			}
		}
		// if no unmarked vertices, return null
		return null;
	}

	//test if there is a path using breadth first traversal
	public boolean isPathBF(T startVertex, T endVertex) {
		//instantiate queue
		Queue<T> queue = new LinkedList<T>();

		// set found to false
		boolean found = false;

		// clear all marks
		clearMarks();

		// mark the startVertex
		markVertex(startVertex);

		// enqueue the startVertex
		queue.offer(startVertex);

		// while there is more in the queue
		while (!queue.isEmpty() && !found) {
			T currentVertex = queue.poll();

			// if current vertex is end vertex, return true
			if (currentVertex.equals(endVertex)) {
				return true;
			} else {
				// else, go through each adjacent one
				Queue<T> adjVertices = getToVertices(currentVertex);
				while (!adjVertices.isEmpty()) {
					T adjVertex = adjVertices.poll();
					// if its not marked, mark it and enqueue it
					if (!isMarked(adjVertex)) {
						markVertex(adjVertex);
						queue.offer(adjVertex);
					}
				}
			}
		}
		//return if it is found
		return found;

	}

	//print out the adjacency
	public void printGraph() {
		//for each vertex
		for (int i = 0; i < numVertices; i++) {
			//set this vertex as current
			T currentVertex = vertices[i];

			//make queue of adjs
			Queue<T> adjVertices = getToVertices(currentVertex);

			//go thru each adj vertex
			while (!adjVertices.isEmpty()) {
				//print out
				System.out.print(currentVertex + " -> ");
				T adjVertex = adjVertices.poll();
				System.out.println(adjVertex);
			}
			System.out.println();

		}
	}
}
