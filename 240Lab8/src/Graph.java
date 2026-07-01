import java.util.Set;

/**
 * CS240 Graph Interface.
 * 
 * @author CS240 Instructors
 *
 * @param <T> Type associated with graph nodes.
 */
public interface Graph<T> {

  /**
   * Add a node to the graph. This method has no effect if id is already a node.
   * 
   * @param id A node will be created for this value
   */
  void addNode(T id);

  /**
   * Add an edge between the indicated nodes. These nodes will be added to the
   * graph if they don't already exist. This method will have no effect if from
   * equals to.
   * 
   * @param from Start node
   * @param to End node
   */
  void addEdge(T from, T to);

  /**
   * Return true if there is an edge between the indicated vertices.
   * 
   * @param from Start node
   * @param to End node
   */
  boolean hasEdge(T from, T to);

  /**
   * Remove the indicated node from the graph. All edges that start or end at this
   * node will also be removed.
   * 
   * @param id The node to remove
   */
  void removeNode(T id);

  /**
   * Remove the indicated edge. This method has no effect if the edge is not
   * present in the graph.
   * 
   * @param from Start node
   * @param to End node
   */
  void removeEdge(T from, T to);

  /**
   * Returns an unmodifiable Set view of all of the neighbors of the indicated
   * node.
   * 
   * @param id The node
   * @return A set of neighbors
   */
  Set<T> neighbors(T id);

  /**
   * Returns an unmodifiable set view of all of the nodes in the graph.
   */
  Set<T> allNodes();

  /**
   * Returns the number of nodes in the graph.
   */
  int numNodes();

  /**
   * Returns the number of edges in the graph.
   */
  int numEdges();

}