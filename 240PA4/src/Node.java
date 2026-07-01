/**
 * HuffmanInternalNode.
 * 
 * @author joshua steffen
 * @version 11/24/21
 */
public class Node {

  public int frequency;
  public char data;
  public Node left;
  public Node right;
  public String sequence;

  /**
   * Constructor for Node.
   * 
   * @param data the letter of the node
   */
  public Node(char data) {
    this.data = data;
    this.frequency = 0;
    this.left = null;
    this.right = null;
    this.sequence = "";
  }
}
