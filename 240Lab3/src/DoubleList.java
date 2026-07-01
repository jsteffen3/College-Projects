import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly-linked list class (UNFINISHED).
 * 
 * @author Joshua Steffen
 *
 */
public class DoubleList<E> implements Iterable<E> {

  private Link<E> head; // Pointer to list header
  private Link<E> tail; // Pointer to last node
  private int listSize; // Size of list

  /**
   * Create an empty LList.
   */
  DoubleList() {
    clear();
  }

  /**
   * Remove all elements.
   */
  public void clear() {
    tail = new Link<E>(null, null); // Create trailer
    head = new Link<E>(null, tail); // Create header
    tail.setPrev(head);
    listSize = 0;
  }

  /**
   * Append item to the end of the list.
   */
  public void append(E item) {
    Link<E> newLink = new Link<>(item, tail.prev(), tail);
    tail.prev().setNext(newLink);
    tail.setPrev(newLink);
    listSize++;
  }


  /**
   * Return the element at the provided index. This method will iterate from the head or the tail
   * depending on which will require fewer steps.
   */
  public E get(int pos) {
    if (pos < 0 || pos >= listSize) {
      throw new IndexOutOfBoundsException();
    }

    if (pos < listSize / 2) {
      return forward(pos).element();
    } else {
      return backward(pos).element();
    }
  }

  /**
   * Helper method for iterating forward from the head.
   */
  private Link<E> forward(int pos) {
    Link<E> current = head.next();
    for (int i = 0; i < pos; i++) {
      current = current.next();
    }
    return current;
  }

  /**
   * Helper method for iterating backward from the tail.
   */
  private Link<E> backward(int pos) {
    Link<E> current = tail.prev();
    for (int i = 0; i < (listSize - 1) - pos; i++) {
      current = current.prev();
    }
    return current;
  }

  /**
   * Return the number of elements stored in the list.
   */
  public int size() {
    return listSize;
  }

  /**
   * Iterates forward through the list. Remove operation is supported.
   */
  @Override
  public Iterator<E> iterator() {
    return new DoubleIterator();
  }

  private class DoubleIterator implements Iterator<E> {

    private boolean lastOperation = false;
    private Link<E> current;
    
    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public E next() {
      if (hasNext()) {
        lastOperation = true;
        return null;
      }
      throw new NoSuchElementException();
    }

    @Override
    public void remove() {
      if (!lastOperation) {
        throw new IllegalStateException();
      }
      current.prev().setNext(current.next());
      current.next().setPrev(current.prev());
    }

  }

  /**
   * Add the item at the specified index.
   */
  public void add(int index, E item) {
    Link<E> holdpre = forward(index - 1);
    Link<E> holdnext = forward(index);
    holdpre.setNext(new Link(item, holdpre, holdnext));
    holdnext.setPrev(holdpre.next());
    listSize++;
  }
  
  /**
   * Remove and return the item at the specified index.
   */
  public E remove(int index) {
    Link holdpre = forward(index -1);
    Link holdnext = forward(index + 1);
    Link hold = forward(index);
    holdpre.setNext(holdnext);
    holdnext.setPrev(holdpre);
    listSize--;
    return (E) hold.element();
  }

  /**
   * Reverse the list (in place)
   */
  public void reverse() {
    
  }



}
