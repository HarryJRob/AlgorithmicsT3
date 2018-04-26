package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	List<Vertex> vertices;
	List<Edge> edges;
	
	
	private class Vertex {
		
		private String vertexIdentifer;
		
		private int positionX;
		private int positionY;
		
		public Vertex(String identifer, int posX, int posY) {
			this.vertexIdentifer = identifer;
			this.positionX = posX;
			this.positionY = posY;
		}
		
		public String getIdentifer() { return vertexIdentifer; }
		
		public int getPositionX() { return positionX; }
		
		public int getPositionY() { return positionY; }
		
		@Override
	    public boolean equals(Object o) {
	        if (o instanceof Vertex) {
	        	Vertex myObject = (Vertex) o;
	            return myObject.getIdentifer() == this.getIdentifer();
	        }

	        return false;
	    }
	}
	
	private class Edge {
		
		private Vertex beginningVertex;
		private Vertex endingVertex;
		private int weight;
		
		public Edge(Vertex beginning, Vertex ending, int weight) {
			this.beginningVertex = beginning;
			this.endingVertex = ending;
			this.weight = weight;
		}
		
		public Vertex getStart() { return beginningVertex; }
		
		public Vertex getEnd() { return endingVertex; }
		
		public int getWeight() { return weight; }
		
		@Override
	    public boolean equals(Object o) {
	        if (o instanceof Edge) {
	        	Edge myObject = (Edge) o;
	            return (myObject.getStart() == this.getStart() && myObject.getEnd() == this.getEnd()) 
	            		|| (myObject.getEnd() == this.getStart() && myObject.getStart() == this.getEnd());
	        }

	        return false;
	    }
	}
	
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	public boolean addVertex(String identifer, int posX, int posY) {
		if(!vertexExists(identifer)) {
			vertices.add(new Vertex(identifer, posX, posY));
			return true;
		}
		
		return false;
	}

	public boolean removeVertex(int vertexIndex) {
		if(vertexIndex >= 0 && vertexIndex < vertices.size()) {
			vertices.remove(vertexIndex);
			return true;
		}
		
		return false;
	}
	
	public boolean vertexExists(String identifer) {
		return vertices.contains(new Vertex(identifer, 0, 0));
	}
	
	public String getVertexIdentifer(int vertexIndex) {
		if(vertexIndex >= 0 && vertexIndex < vertices.size()) {
			return vertices.get(vertexIndex).getIdentifer();
		}
		
		return "";
	}
	
	public int getVertexXPosition(int vertexIndex) {
		if(vertexIndex >= 0 && vertexIndex < vertices.size()) {
			return vertices.get(vertexIndex).getPositionX();
		}
		
		return -1;
	}
	
	public int getVertexYPosition(int vertexIndex) {
		if(vertexIndex >= 0 && vertexIndex < vertices.size()) {
			return vertices.get(vertexIndex).getPositionY();
		}
		
		return -1;
	}
	
	public int getVertexCount() {
		return vertices.size();
	}
	
	public boolean addEdge(int vertexIndex1, int vertexIndex2, int weight) {
		if(vertexIndex1 >= 0 && vertexIndex1 < vertices.size() 
				&& vertexIndex2 >= 0 && vertexIndex2 < vertices.size() 
				&& !edgeExists(vertexIndex1, vertexIndex2)) {
			edges.add(new Edge(vertices.get(vertexIndex1), vertices.get(vertexIndex2), weight));
			return true;
		}
			
		return false;
	}
	
	public boolean removeEdge(int edgeIndex) {
		if(edgeIndex >= 0 && edgeIndex < edges.size()) {
			edges.remove(edgeIndex);
			return true;
		}
		
		return false;
	}
	
	public boolean edgeExists(int vertexIndex1, int vertexIndex2) {
		return edges.contains(new Edge(vertices.get(vertexIndex1), vertices.get(vertexIndex2), 0));
	}
	
	public int getEdgeStartIndex(int edgeIndex) {
		if(edgeIndex >= 0 && edgeIndex < edges.size()) {
			return vertices.indexOf(edges.get(edgeIndex).getStart());
		}
		
		return -1;
	}
	
	public int getEdgeEndIndex(int edgeIndex) {
		if(edgeIndex >= 0 && edgeIndex < edges.size()) {
			return vertices.indexOf(edges.get(edgeIndex).getEnd());
		}
		
		return -1;
	}
	
	public int getEdgeWeight(int edgeIndex) {
		if(edgeIndex >= 0 && edgeIndex < edges.size()) {
			edges.get(edgeIndex).getWeight();
		}
		
		return -1;
	}
	
	public int getEdgeCount() {
		return edges.size();
	}
}
