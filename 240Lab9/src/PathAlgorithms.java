import java.util.ArrayList;
import java.util.HashSet;

public class PathAlgorithms {
  /**
   * Sequence the vertices of a graph so that no vertex is visited before its
   * prerequisites.
   *
   * @param graph The graph to sort.
   * @return A sequence of vertices, with prerequisites before their
   * successors.
   */
  public static <T> ArrayList<T> topologicalSort(Graph<T> graph) {
    // Start a depth-first traversal from each vertex.
    boolean[] visited = new boolean[graph.numNodes()];
    for (int i = 0; i < graph.numNodes(); i++) {
      visited[i] = false;
    }
    ArrayList<T> result = new ArrayList<T>();
    for (int i = 0; i < graph.numNodes(); i++) {
      if (!visited[i]) {
        travel(graph, i, result);
      }
    }
    return result;
  }
  
  public static <T> void travel(Graph<T> graph, int node, ArrayList<T> result) {
   
  }

  /**
   * Traverse outward from a vertex.
   *
   * @param graph The graph to sequence.
   * @param vertex The vertex from which to traverse outward.
   * @param visited A record of vertices that have been previously visited.
   * @param sequence The sequence of vertices, with prerequisites after their
   * successors.
   */
  private static <T> void topologicalTraverse(Graph<T> graph, T vertex, HashSet<T> visited, ArrayList<T> sequence) {
    // Conduct a standard depth-first traversal, but also record the sequence
    // of visited vertices. Recursively traverse outward from the vertex,
    // visiting only unvisited neighbors. Add vertices to the sequence in
    // reverse order. For example, if the traversed path is 0 -> 1 -> 2, then
    // the sequence will be [2, 1, 0].
  }

  /**
   * Determine if a graph contains a cycle.
   *
   * @param graph The graph to check.
   * @return True iff the graph contains at least one cycle.
   */
  public static <T> boolean hasCycle(Graph<T> graph) {
    // Start a depth-first, back edge-seeking traversal from each vertex. If
    // any vertex's traversal has a back edge, then the graph has a cycle.
    return false;
  }

  /**
   * Determine if traversing outward from a given vertex leads to a back edge.
   *
   * @param graph The graph to traverse
   * @param vertex The vertex from which to traverse outward
   * @param everVisited A record of which vertices have ever been visited, whether on this path or others.
   * @param pathVisited A record of which vertices have been visited only on the current path.
   */
  private static <T> boolean hasBackEdge(Graph<T> graph, T vertex, HashSet<T> everVisited, HashSet<T> pathVisited) {
    // Recursively trace all possible paths that lead out from this vertex. If
    // you encounter a neighbor that was visited earlier on the path that led
    // to this vertex, that means there is a "back edge", an edge that is part
    // of a cycle. Otherwise, recurse along any unvisited neighbor.
    //
    // Imagine the graph 0 -> 1 -> 2 -> 0. We start traversing at vertex 0. Its
    // neighbor 1 hasn't been visited on the current path before. Neither has
    // it ever been visited, so we recurse. Vertex 1's neighbor 2 hasn't been
    // visited on the current path before, so we recurse. Vertex 2's neighbor 0
    // has been visited on the current path, so there's a back edge.
    return false;
  }
}