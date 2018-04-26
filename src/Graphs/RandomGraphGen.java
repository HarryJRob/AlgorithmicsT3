package Graphs;

public class RandomGraphGen {
	
	public static void main(String[] args) {
		
		Graph myGraph = randomGraph(20, 0.5f);
		
		
		GraphDisplay myGraphDisplay = new GraphDisplay();
		
		System.out.println(myGraph.getVertexCount());
		
		for(int i = 0; i < myGraph.getVertexCount(); i++) {
			myGraphDisplay.addNode(myGraph.getVertexIdentifer(i), myGraph.getVertexXPosition(i), myGraph.getVertexYPosition(i));
		}
		
		/*Very odd addEdge method if it is to be used externally!
		 * 
		for(int i = 0; i < myGraph.getEdgeCount(); i++) {
		 myGraphDisplay.addEdge(start, end);
		}
		*
		*/
		myGraphDisplay.showInWindow(400, 400, "Random Graph");
		
	}

	private static Graph randomGraph(int numberOfVertices, float probabilityOfEdge) {
		
		Graph graph = new Graph();
		
		for(int i = 0; i < numberOfVertices; i++) {
			graph.addVertex(Integer.toString(i), (int) (Math.random()*numberOfVertices*10), (int) (Math.random()*numberOfVertices*10));
		}
		
		for(int i = 0; i < numberOfVertices; i++) {
			for(int j = 0; j < numberOfVertices; j++) {
				if(Math.random() < probabilityOfEdge) {
					graph.addEdge(i, j, (int) Math.sqrt((graph.getVertexXPosition(i) - graph.getVertexXPosition(j))^2 + (graph.getVertexYPosition(i) - graph.getVertexYPosition(j))^2));
				}
			}
		}
		
		return graph;
	}

}
