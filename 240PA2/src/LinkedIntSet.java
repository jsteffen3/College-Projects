import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * CS240 PA2 LinkedIntSet. This Code Compiles in accordance with the JMU honor Code I received no
 * outside help on this assignment.
 * 
 * @author Joshua Steffen
 * @version 9/24/21
 */
public class LinkedIntSet implements IntSet {

  private Node start;
  private int size; // # of #s in the intervals
  private int length; // # of Nodes

  /**
   * Creates a new LinkedIntSet with no data.
   */
  public LinkedIntSet() {
    start = null;
    size = 0;
    length = 0;
  }

  /**
   * Creates and returns a new LinkedSetIterator.
   * 
   * @return the LinkedSetIterator
   */
  @Override
  public Iterator<Integer> iterator() {
    return new LinkedSetIterator();
  }

  /**
   * Checks if the Set is empty.
   * 
   * @return if the starting node is empty.
   */
  @Override
  public boolean isEmpty() {
    return length == 0;
  }

  /**
   * Returns the size.
   * 
   * @return the size
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Returns the number of intervals in the Set.
   * 
   * @return the number of intervals in the Set
   */
  @Override
  public int getIntervalCount() {
    return size;
  }

  /**
   * Returns the Set as a String.
   * 
   * @return the Set as a Srting.
   */
  @Override
  public String toString() {
    if (isEmpty()) {
      return "{}";
    }
    String result = "{";
    Node hold = start;
    ArrayList<Integer> temp = new ArrayList<Integer>();
    while (hold != null) {
      temp.add(hold.getdata().getLowerBound());
      hold = hold.getNext();
    }
    Collections.sort(temp);
    hold = start;
    for (int i = 0; i < temp.size(); i++) {
      while (hold != null) {
        if (hold.getdata().contains(temp.get(i))) {
          if (temp.size() - 1 == i) {
            result = result + hold.getdata().toString();
          } else {
            result = result + hold.getdata().toString() + ",";
          }
        }
        hold = hold.getNext();
      }
      hold = start;
    }
    return result + "}";
  }

  /**
   * Returns the ith interval in the set.
   * 
   * @return the ith interval in the set
   */
  @Override
  public Interval getInterval(int i) {
    if (isEmpty() || i > size) {
      throw new IndexOutOfBoundsException();
    }
    Node hold = start;
    for (int n = 0; n < size; n++) {
      if (n == i) {
        return hold.getdata();
      }
      hold = hold.getNext();
    }
    return null;
  }

  /**
   * Checks if the give int is included in the set.
   * 
   * @return if the int is in the set
   */
  @Override
  public boolean contains(int test) {
    Node hold = start;
    while (hold != null) {
      if (hold.getdata().contains(test)) {
        return true;
      }
      hold = hold.getNext();
    }
    return false;
  }

  /**
   * Attempts to add the integer to the set.
   * 
   * @return if the int was added to the set
   */
  @Override
  public boolean add(int add) {
    if (contains(add)) {
      return false;
    }
    size++;
    Node hold = start;
    boolean addedAsNew = true;
    while (hold != null) {
      if (hold.getdata().getLowerBound() - 1 == add) {
        hold.getdata().setLowerBound(add);
        addedAsNew = false;
      } else if (hold.getdata().getUpperBound() + 1 == add) {
        hold.getdata().setUpperBound(add);
        addedAsNew = false;
      }
      hold = hold.getNext();
    }
    if (addedAsNew) {
      hold = start;
      start = new Node(new Interval(add, add), hold);
      length++;
    } else {
      merge();
    }
    return true;
  }

  /**
   * Attempts to merge any Intervals.
   */
  private void merge() {
    Node hold = start;
    Node check = start;
    while (hold != null) {
      while (check != null) {
        if (hold.getdata().getLowerBound() == check.getdata().getUpperBound()) {
          if (hold.getPrevious() == null) {
            start = hold.getNext();
            check.getdata().setLowerBound(hold.getdata().getLowerBound());
          } else if (hold.getNext() == null) {
            hold.getPrevious().setNext(null);
            check.getdata().setLowerBound(hold.getdata().getLowerBound());
          } else {
            hold.getPrevious().setNext(hold.getNext());
            hold.getNext().setPrevious(hold.getPrevious());
            check.getdata().setLowerBound(hold.getdata().getLowerBound());
          }
        } else if (check.getdata().getLowerBound() == hold.getdata().getUpperBound()) {
          if (hold.getPrevious() == null) {
            start = hold.getNext();
            check.getdata().setUpperBound(hold.getdata().getUpperBound());
          } else if (hold.getNext() == null) {
            hold.getPrevious().setNext(null);
            check.getdata().setUpperBound(hold.getdata().getUpperBound());
          } else {
            hold.getPrevious().setNext(hold.getNext());
            hold.getNext().setPrevious(hold.getPrevious());
            check.getdata().setUpperBound(hold.getdata().getUpperBound());
          }
        }
        check = check.getNext();
      }
      check = start;
      hold = hold.getNext();
    }
  }

  @Override
  public boolean remove(int remove) {
    if (!contains(remove)) {
      throw new NoSuchElementException();
    }
    size--;
    Node hold = start;
    while (hold != null) {
      if (hold.getdata().contains(remove)) {
        if (remove == hold.getdata().getLowerBound()) {
          hold.getdata().setLowerBound(remove + 1);
        } else if (remove == hold.getdata().getUpperBound()) {
          hold.getdata().setUpperBound(remove - 1);
        } else {
          hold.setNext(new Node(new Interval(remove + 1, hold.getdata().getUpperBound()),
              hold.getNext(), hold));
          hold.getNext().getNext().setPrevious(hold.getNext());
          hold.getdata().setLowerBound(remove - 1);
        }
      }
      hold = hold.getNext();
    }
    return true;
  }

  private class LinkedSetIterator implements Iterator<Integer> {

    private Node current = start;
    private boolean canRemove = false;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Integer next() {
      if (hasNext()) {
        canRemove = true;
        Node hold = current;
        current = current.getNext();
        return hold.getdata().getLowerBound();
      }
      throw new NoSuchElementException();
    }

    public void remove() {
      if (canRemove) {
        Node hold = current.getPrevious();
        if (hold.getPrevious() == null) {
          hold.setNext(null);
        } else {
          hold.getPrevious().setNext(hold.getNext());
          hold.getNext().setPrevious(hold.getPrevious());
        }
        canRemove = false;
      }
    }

  }
}
