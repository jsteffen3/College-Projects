import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Adjacency-matrix-based implementation of the CS240 Graph ADT. Note that this implementation only
 * allows integer valued vertices and it does not support adding or removing nodes.
 * 
 * See Graph.java for method specifications.
 * 
 * @author Nathan Sprague &&
 * @version ??
 *
 */
public class ArrayGraph implements Graph<Integer> {

  private boolean[][] matrix;
  private int numEdges;

  /**
   * Create an ArrayGraph with the specified size. Initially the graph contains no edges.
   * 
   * @param numNodes The number of nodes in this graph.
   */
  public ArrayGraph(int numNodes) {
    matrix = new boolean[numNodes][numNodes];
    numEdges = 0;
  }

  /**
   * Returns true if the indicated id represents a valid node in this graph.
   */
  private boolean nodeValid(Integer id) {
    return id >= 0 && id < numNodes();
  }

  /**
   * Returns true if the start and end nodes exist in this graph.
   */
  private boolean edgeValid(Integer from, Integer to) {
    return nodeValid(from) && nodeValid(to);
  }

  /**
   * It is not possible to add nodes for this graph class.
   */
  @Override
  public void addNode(Integer id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addEdge(Integer from, Integer to) {
    // UNFINISHED
    if (edgeValid(from, to) && from != to && !matrix[from][to]) {
      matrix[from][to] = true;
      numEdges++;
    }
  }

  @Override
  public boolean hasEdge(Integer from, Integer to) {
    if (edgeValid(from, to)) {
      return matrix[from][to];
    }
    return false;
  }

  /**
   * It is not possible to remove nodes for this graph class.
   */
  @Override
  public void removeNode(Integer id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void removeEdge(Integer from, Integer to) {
    // UNFINISHED
    if (edgeValid(from, to) && matrix[from][to]) {
      matrix[from][to] = false;
      numEdges--;
    }
  }

  @Override
  public Set<Integer> neighbors(Integer id) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < numNodes(); i++) {
      if (hasEdge(id, i)) {
        set.add(i);
      }
    }
    return Collections.unmodifiableSet(set);
  }

  @Override
  public Set<Integer> allNodes() {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < numNodes(); i++) {
      set.add(i);
    }
    return Collections.unmodifiableSet(set);
  }

  @Override
  public int numNodes() {
    return matrix.length;
  }

  @Override
  public int numEdges() {
    return numEdges;
  }

}
