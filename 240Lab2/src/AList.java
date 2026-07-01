
import java.util.Iterator;

/**
 * Array-based List implementation
 * 
 * @author OpenDSA Textbook
 *
 * @param <E> - Element type to store.
 */

/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 */

class AList<E> implements List<E>{

    protected E[] listArray; // Array holding list elements
    // Protected instead of private to facilitate testing/grading.

    private static final int defaultSize = 10; // Default size
    private int maxSize; // Maximum size of list
    private int listSize; // Current # of list items
    private int curr; // Position of current element

    /**
     * Create a new list object with maximum size "size".
     * 
     * @param size Initial array size.
     */
    @SuppressWarnings("unchecked") // Generic array allocation
    public AList(int size) {
        maxSize = size;
        listSize = curr = 0;
        listArray = (E[]) new Object[size];
    }

    /**
     * Create a list with the default capacity.
     */
    public AList() {
        this(defaultSize); // Just call the other constructor
    }

    /**
     * Reinitialize the list.
     */
    public void clear() {
        listSize = curr = 0;
    }

    /**
     * Insert item at current position.
     * 
     * @param it The item to insert
     */
    public boolean insert(E it) {
        if (listSize >= maxSize) {
            resizeHelper();
        }
        for (int i = listSize; i > curr; i--) { // Shift elements up
            listArray[i] = listArray[i - 1]; // to make room
        }
        listArray[curr] = it;
        listSize++; // Increment list size
        return true;
    }

    /**
     * Append item to list.
     * 
     * @param it The item to append
     */
    public boolean append(E it) {
        if (listSize >= maxSize) {
            resizeHelper();
        }
        listArray[listSize++] = it;
        return true;
    }

    /**
     * Remove and return the current element.
     */
    public E remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * Set position to front.
     */
    public void moveToStart() {
        curr = 0;
    }

    /**
     * Set position to end.
     */
    public void moveToEnd() {
        curr = listSize;
    }

    /**
     * Move position left.
     */
    public void prev() {
        if (curr != 0) {
            curr--;
        }
    }

    /**
     * Move position right.
     */
    public void next() {
        if (curr < listSize) {
            curr++;
        }
    }

    /**
     * Return the list size.
     */
    public int length() {
        return listSize;
    }

    /**
     * Return the current position.
     */
    public int currPos() {
        return curr;
    }

    /**
     * Set the current position to the specified value.
     * 
     * @return false if the position is invalid.
     */
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) {
            return false;
        }
        curr = pos;
        return true;
    }

    /**
     * Return true if the position is at the end of the list.
     */
    public boolean isAtEnd() {
        return curr == listSize;
    }

    /**
     * Return the element at the current position.
     */
    public E getValue() {
        if ((curr < 0) || (curr >= listSize)) { // No current element
            return null;
        }
        return listArray[curr];
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

  public void resizeHelper() {
     E[] tempArray = (E[]) new Object[listArray.length * 2];
     maxSize = tempArray.length;
     for(int i = 0; i < listArray.length; i++) {
         tempArray[i] = listArray[i]; 
     }
     listArray = tempArray;
  }
  
  public void downSize() {
      E[] tempArray = (E[]) new Object[listArray.length / 2];
      maxSize = tempArray.length;
      for(int i = 0; i < listArray.length/2; i++) {
          tempArray[i] = listArray[i]; 
      }
      listArray = tempArray;
  }

    private class ListIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public E next() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
        }

    }

}
