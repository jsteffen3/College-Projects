import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Simple tests for the GraphAlgorithms class
 * @author Nathan Sprague
 *
 */
class GraphAlgorithmsTest {

	private Graph<Integer> oneVertexGraph;
	private Graph<Integer> fullGraph;
	private Graph<Integer> disconnectedGraph;
	private Graph<Integer> circleDirectedGraph;
	private Graph<Integer> circleUndirectedGraph;
	private Graph<Integer> star;

	@BeforeEach
	void setUp() throws Exception {

		oneVertexGraph = new ArrayGraph(1);

		fullGraph = new ArrayGraph(5);
		for (int from = 0; from < 5; from++) {
			for (int to = 0; to < 5; to++) {
				fullGraph.addEdge(from, to);
			}
		}

		disconnectedGraph = new ArrayGraph(5);
		fullGraph.addEdge(0, 1);
		fullGraph.addEdge(1, 0);
		fullGraph.addEdge(2, 3);
		fullGraph.addEdge(3, 2);
		fullGraph.addEdge(2, 4);
		fullGraph.addEdge(4, 2);
		

		circleDirectedGraph = new ArrayGraph(4);
		circleDirectedGraph.addEdge(0, 1);
		circleDirectedGraph.addEdge(1, 2);
		circleDirectedGraph.addEdge(2, 3);
		circleDirectedGraph.addEdge(3, 0);

		circleUndirectedGraph = new ArrayGraph(4);
		circleUndirectedGraph.addEdge(0, 1);
		circleUndirectedGraph.addEdge(1, 2);
		circleUndirectedGraph.addEdge(2, 3);
		circleUndirectedGraph.addEdge(3, 0);
		circleUndirectedGraph.addEdge(1, 0);
		circleUndirectedGraph.addEdge(2, 1);
		circleUndirectedGraph.addEdge(3, 2);
		circleUndirectedGraph.addEdge(0, 3);
		
	

		star = new ArrayGraph(4);
		star.addEdge(0, 1);
		star.addEdge(0, 2);
		star.addEdge(0, 3);

	}
	

	  @Test
	  public void testGetOutDegree() {

	    assertEquals(0, GraphAlgorithms.getOutDegreeOfVertex(oneVertexGraph, 0));
	    
	    for (Integer vertex : circleDirectedGraph.allNodes()) {
	      assertEquals(1, GraphAlgorithms.getOutDegreeOfVertex(circleDirectedGraph, vertex));
	    }
	    
	    assertEquals(3, GraphAlgorithms.getOutDegreeOfVertex(star, 0));
	    assertEquals(0, GraphAlgorithms.getOutDegreeOfVertex(star, 1));
	    assertEquals(0, GraphAlgorithms.getOutDegreeOfVertex(star, 2));
	    assertEquals(0, GraphAlgorithms.getOutDegreeOfVertex(star, 3));
	    
	    for (Integer vertex : fullGraph.allNodes()) {
	      assertEquals(4, GraphAlgorithms.getOutDegreeOfVertex(fullGraph, vertex));
	    }
	   
	  }
	  
	  @Test
	  public void testGetInDegree() {

	    assertEquals(0, GraphAlgorithms.getInDegreeOfVertex(oneVertexGraph, 0));
	    
	    for (Integer vertex : circleDirectedGraph.allNodes()) {
	      assertEquals(1, GraphAlgorithms.getInDegreeOfVertex(circleDirectedGraph, vertex));
	    }
	    
	    assertEquals(0, GraphAlgorithms.getInDegreeOfVertex(star, 0));
	    assertEquals(1, GraphAlgorithms.getInDegreeOfVertex(star, 1));
	    assertEquals(1, GraphAlgorithms.getInDegreeOfVertex(star, 2));
	    assertEquals(1, GraphAlgorithms.getInDegreeOfVertex(star, 3));
	    
	    for (Integer vertex : fullGraph.allNodes()) {
	      assertEquals(4, GraphAlgorithms.getInDegreeOfVertex(fullGraph, vertex));
	    }
	  }
	  
	  @Test
	  public void testIsConnected() {
	    assertTrue(GraphAlgorithms.isConnected(oneVertexGraph));
	    assertTrue(GraphAlgorithms.isConnected(fullGraph));
	    assertTrue(GraphAlgorithms.isConnected(circleUndirectedGraph));
	    Graph<Integer> noEdgeGraph = new ArrayGraph(5);
	    assertFalse(GraphAlgorithms.isConnected(noEdgeGraph));
	    assertFalse(GraphAlgorithms.isConnected(disconnectedGraph));
	  }
	 



}