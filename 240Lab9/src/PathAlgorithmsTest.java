import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;

/**
 * Simple tests for the GraphAlgorithms class
 * @author Chris Johnson
 *
 */
class PathAlgorithmsTest {

  private static ArrayGraph parseGraph(int vertexCount, String edgeCsv) {
    ArrayGraph graph = new ArrayGraph(vertexCount);

    if (edgeCsv.length() > 0) {
      String[] edges = edgeCsv.split(",", 10);

      for (String edge : edges) {
        String[] vertices = edge.split("-");
        int from = Integer.parseInt(vertices[0]);
        int to = Integer.parseInt(vertices[1]);
        if (from >= vertexCount) {
          throw new IndexOutOfBoundsException(from);
        } else if (to >= vertexCount) {
          throw new IndexOutOfBoundsException(to);
        }
        graph.addEdge(from, to);
      }
    }

    return graph;
  }

  private static String graphToDot(ArrayGraph graph) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bos);

    out.printf("Visualize the graph by pasting the following into http://graphviz.it/#/new:%n%n");
    out.println("digraph {");
    for (Integer vertex : graph.allNodes()) {
      out.printf("  %d;%n", vertex);
    }
    for (Integer from : graph.allNodes()) {
      for (Integer to : graph.neighbors(from)) {
        out.printf("  %d -> %d;%n", from, to);
      }
    }
    out.println("}");

    out.close();

    return bos.toString();
  }

  private static ArrayGraph randomGraph(int vertexCount, int edgeCount, int seed) {
    Random random = new Random(seed);
    ArrayGraph graph = new ArrayGraph(vertexCount);
    for (int i = 0; i < edgeCount; ++i) {
      int from = random.nextInt(vertexCount);
      int to = random.nextInt(vertexCount);
      graph.addEdge(from, to);
    }
    return graph;
  }

  private static void assertHasCycle(boolean expected, ArrayGraph graph) {
    boolean actual = PathAlgorithms.hasCycle(graph);
    if (expected != actual) {
      Assertions.fail(String.format("Graph %s has cycles?%n  Expected: %b%n  Actual:   %b%n%n%s", graph, expected, actual, graphToDot(graph)));
    }
  }

  private static void assertHasCycle(boolean expected, int vertexCount, String edgeCsv) {
    assertHasCycle(expected, parseGraph(vertexCount, edgeCsv));
  }

  @Test
  public void testHasCyclesLines() {
    assertHasCycle(false, 1, "");
    assertHasCycle(false, 2, "0-1");
    assertHasCycle(false, 3, "0-1,1-2");
    assertHasCycle(false, 4, "0-1,1-2,2-3");
  }

  @Test
  public void testHasCyclesTrees() {
    assertHasCycle(false, 3, "0-1,0-2");
    assertHasCycle(false, 7, "0-1,0-2,1-3,1-4,2-5,2-6");
    assertHasCycle(false, 7, "0-1,1-2,2-3,2-4,3-5,4-6");
  }

  @Test
  public void testHasCyclesCircuitsOnly() {
    assertHasCycle(true, 2, "0-1,1-0");
    assertHasCycle(true, 4, "0-1,1-2,2-3,3-0");
  }

  @Test
  public void testHasCyclesForkJoin() {
    assertHasCycle(false, 4, "0-1,0-2,1-3,2-3");
    assertHasCycle(false, 6, "0-1,0-2,1-3,2-4,3-5,4-5");
  }

  @Test
  public void testHasNoCycles() {
    assertHasCycle(false, 4, "0-1,0-2,1-3,2-1");
    assertHasCycle(false, 4, "0-1,1-3,2-3");
    assertHasCycle(false, 5, "0-4,1-4,2-4,3-4");
  }

  @Test
  public void testHasCycles() {
    assertHasCycle(true, 4, "0-1,1-2,1-3,3-0,3-2");
    assertHasCycle(true, 8, "0-1,1-2,2-3,3-4,0-5,5-6,6-7,7-4,4-0");
    assertHasCycle(true, 4, "0-1,1-2,2-3,3-2");
    assertHasCycle(true, 4, "0-1,1-2,2-3,3-1");
  }

  @Test
  public void testHasCyclesRandom() {
    assertHasCycle(true, randomGraph(5, 9, 99));
    assertHasCycle(true, randomGraph(5, 9, 101));
    assertHasCycle(true, randomGraph(5, 8, 29));
    assertHasCycle(true, randomGraph(5, 7, 203));
    assertHasCycle(true, randomGraph(5, 6, 300));
    assertHasCycle(false, randomGraph(5, 3, 217));
    assertHasCycle(true, randomGraph(10, 20, 13));
    assertHasCycle(false, randomGraph(10, 10, 13));
    assertHasCycle(false, randomGraph(100, 20, 19));
    assertHasCycle(false, randomGraph(100, 90, 19));
    assertHasCycle(true, randomGraph(100, 200, 19));
    assertHasCycle(true, randomGraph(100, 500, 19));
  }

  private static void assertTopologicalSort(int vertexCount, String edgeCsv, Integer... vertices) {
    ArrayGraph graph = parseGraph(vertexCount, edgeCsv);
    ArrayList<Integer> actual = PathAlgorithms.topologicalSort(graph);
    List<Integer> expected = Arrays.asList(vertices);
    if (!expected.equals(actual)) {
      Assertions.fail(String.format("Topological sort of graph %s%n  Expected: %s%n  Actual:   %s%n%n%s", graph, expected, actual, graphToDot(graph)));
    }
  }

  @Test
  public void testTopologicalSort() {
    assertTopologicalSort(1, "", 0);
    assertTopologicalSort(2, "0-1", 0, 1);
    assertTopologicalSort(3, "0-1,1-2", 0, 1, 2);
    assertTopologicalSort(4, "0-1,1-2,2-3", 0, 1, 2, 3);
    assertTopologicalSort(3, "0-1,0-2", 0, 2, 1);
    assertTopologicalSort(4, "0-1,0-2,1-3,2-3", 0, 2, 1, 3);
    assertTopologicalSort(4, "0-1,0-2,0-3", 0, 3, 2, 1);
    assertTopologicalSort(4, "0-1,0-2,0-3,3-2", 0, 3, 2, 1);
    assertTopologicalSort(4, "0-1,0-2,0-3,2-3,2-1", 0, 2, 3, 1);
    assertTopologicalSort(3, "0-2,1-2", 1, 0, 2);
    assertTopologicalSort(3, "0-1,1-2,0-2", 0, 1, 2);
  }
}