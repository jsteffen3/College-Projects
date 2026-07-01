/**
 * CS240 PA2 Node. This Code Compiles in accordance with the JMU honor Code I received no outside
 * help on this assignment.
 * 
 * @author Joshua Steffen
 * @version 9/24/21
 */
public class Node {

  private Node next;
  private Node previous;
  private Interval data;

  /**
   * Creates a new node with no previous node.
   * 
   * @param data the Interval
   * @param next the next Node in the list
   */
  public Node(Interval data, Node next) {
    this.data = data;
    this.next = next;
  }

  /**
   * Creates a new node with all data.
   * 
   * @param data the Interval
   * @param next the next node
   * @param previous the previous node
   */
  public Node(Interval data, Node next, Node previous) {
    this.data = data;
    this.next = next;
    this.previous = previous;
  }

  /**
   * Creates a node with no next or previous.
   * 
   * @param data the interval
   */
  public Node(Interval data) {
    this.data = data;
  }

  /**
   * Gets the nodes data.
   * 
   * @return the Interval
   */
  public Interval getdata() {
    return data;
  }

  /**
   * Gets the next Node.
   * 
   * @return the next node
   */
  public Node getNext() {
    return next;
  }

  /**
   * Gets the previous node.
   * 
   * @return the previous node
   */
  public Node getPrevious() {
    return previous;
  }

  /**
   * Sets the next Node.
   * 
   * @param next the new next Node
   */
  public void setNext(Node next) {
    this.next = next;
  }

  /**
   * Sets the previous Node.
   * 
   * @param previous the new previous Node
   */
  public void setPrevious(Node previous) {
    this.previous = previous;
  }
}
