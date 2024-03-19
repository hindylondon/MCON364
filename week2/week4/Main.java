package week4;

public class Main {
	public static void main(String[] args) {
		//instantiate new string graph
		Graph<String> g = new Graph<>();
		
		//add 6 vertexes
		g.addVertex("Father");
		g.addVertex("Mother");
		g.addVertex("Son");
		g.addVertex("Daughter");
		g.addVertex("Grandfather");
		g.addVertex("Grandmother");
		
		//add 3 edges to each vertex
		g.addEdge("Father", "Mother");
		g.addEdge("Father", "Son");
		g.addEdge("Father", "Daughter");
		
		g.addEdge("Mother", "Father");
		g.addEdge("Mother", "Son");
		g.addEdge("Mother", "Daughter");
		
		g.addEdge("Son", "Mother");
		g.addEdge("Son", "Father");
		g.addEdge("Son", "Daughter");
		
		g.addEdge("Daughter", "Mother");
		g.addEdge("Daughter", "Father");
		g.addEdge("Daughter", "Son");
		
		g.addEdge("Grandfather", "Mother");
		g.addEdge("Grandfather", "Father");
		g.addEdge("Grandfather", "Grandmother");
		
		g.addEdge("Grandmother", "Mother");
		g.addEdge("Grandmother", "Father");
		g.addEdge("Grandmother", "Grandfather");
		
		//print out the graph
		g.printGraph();
		
		//display three different paths through breadth first traversal
		isPath(g);
		
		
		
		
		
	}

	private static void isPath(Graph<String> g) {
		// Output 3 different paths
		
		//if path from father to mother
		if (g.isPathBF("Father", "Mother")) {
			System.out.println("There is a path from Father to Mother.");
		} else {
			System.out.println("There is no path from Father to Mother.");
		}
		
		//if path from father to son
		if (g.isPathBF("Father", "Son")) {
			System.out.println("There is a path from Father to Son.");
		} else {
			System.out.println("There is no path from Father to Son.");
		}
		
		//if path from father to daughter
		if (g.isPathBF("Father", "Daughter")) {
			System.out.println("There is a path from Father to Daughter.");
		} else {
			System.out.println("There is no path from Father to Daughter.");
		}
		
	}

}
