import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * CS 240 PA4 JMZip.
 * 
 * @author joshua steffen
 * @version 11/24/21
 * @apiNote I have neither given or received help on this PA.
 */
public class JMZip {

  /**
   * Main method for converting a file into a compressed form.
   * 
   * @param args files to process
   */
  public static void main(String[] args) {
    // creating a new scanner to take in the contents of the new file.
    if (args.length < 2) {
      return;
    }
    Scanner in = new Scanner(args[0]);
    // creating an int array to store the appearances of ever ascii char.
    int[] count = new int[127];
    for (int i = 0; i < count.length; i++) {
      count[i] = 0;
    }
    // Incrementing positions based off what character is given.
    while (in.hasNext()) {
      String next = in.next();
      for (int i = 0; i < next.length(); i++) {
        count[(int) next.charAt(i)]++;
      }
    }
    // creating a priority queue to build the tree.
    PriorityQueue<Node> builder = new PriorityQueue<Node>(new Comparer());
    HashMap<Character, Node> items = new HashMap<Character, Node>();
    for (int i = 0; i < count.length; i++) {
      // skipping positions where there were 0 characters in the file.
      if (count[i] > 0) {
        Node insert = new Node((char) i);
        insert.frequency = count[i];
        builder.add(insert);
        items.put(insert.data, insert);
      }
    }
    // the final node added to the queue is the trees root.
    Node root = null;
    // removing the next 2 nodes in the queue will create the tree.
    while (builder.size() > 1) {
      Node one = builder.poll();
      Node two = builder.poll();
      Node internal = new Node('-');
      internal.frequency = one.frequency + two.frequency;
      internal.left = one;
      internal.right = two;
      builder.add(internal);
      root = internal;
    }
    sequenceAssigner(root, "");
    // reseting the scanner to get input from the start.
    in.reset();
    // getting input from the scanner and converting it to its BitSequence equivalent.
    BitSequence encoded = new BitSequence();
    while (in.hasNext()) {
      String current = in.next();
      for (int i = 0; i < current.length(); i++) {
        encoded.appendBits(items.get(current.charAt(i)).sequence);
      }
    }
    in.close();
    HashMap<Byte, Integer> save = new HashMap<Byte, Integer>();
    for (int i = 0; i < count.length; i++) {
      save.put(Byte.parseByte(String.valueOf(((char) i))), count[i]);
    }
    HuffmanSave result = new HuffmanSave(encoded, save);
    try {
      File zipped = new File(args[1]);
      zipped.createNewFile();
      FileWriter write = new FileWriter(zipped);
      write.write(result.getFrequencies().toString() + "\n");
      write.write(result.getEncoding().toString());
      write.close();
    } catch (IOException e) {
      System.out.print("error");
    }

  }

  private static void sequenceAssigner(Node root, String prevSequence) {
    if (root == null) {
      return;
    }
    root.sequence = prevSequence;
    sequenceAssigner(root.left, prevSequence + "0");
    sequenceAssigner(root.right, prevSequence + "1");
  }
}
