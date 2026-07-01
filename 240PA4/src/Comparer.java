import java.util.Comparator;

/**
 * CS 240 PA4 compare.
 * 
 * @author joshua steffen
 * @version 11/24/21
 * @apiNote I have neither given or received help on this PA.
 */
public class Comparer implements Comparator<Node> {
  public int compare(Node one, Node two) {
    return one.frequency - two.frequency;
  }
}
