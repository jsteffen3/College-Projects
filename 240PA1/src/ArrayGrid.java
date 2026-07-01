import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * CS 240 ArrayGrid.
 * This Code Compiles in accordance with the JMU honor Code I received no outside
 * help on this assignment.
 * 
 * @author Joshua Steffen
 * @version 9/1/21
 */
public class ArrayGrid<E> extends AbstractGrid<E> {

  private E[][] data;
  private int numItems;

  /**
   * Creates a new ArrayGrid with rows and cols as its lengths.
   * 
   * @param rows number of rows for the array
   * @param cols number of colomns for the array
   */
  public ArrayGrid(int rows, int cols) {
    if (rows < 1 || cols < 1) {
      throw new IllegalArgumentException();
    }
    numItems = 0;
    data = (E[][]) new Object[rows][cols];
  }

  /**
   * Creates an iterator for the class.
   */
  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return new ArrayGridIterator();
  }

  /**
   * Attempts to put the given value at the location if the previous item was not null increase
   * numItems. Throw IllegalArgumentException if the location is invalid. Throw a
   * NullPointerException if the item is null.
   * 
   * @param loc where to add the item
   * @param item what is going to be added
   */
  @Override
  public void put(Location loc, E item) {
    super.validLocation(loc);
    super.nullItemCheck(item);
    if (data[loc.getRow()][loc.getCol()] == null) {
      numItems++;
    }
    data[loc.getRow()][loc.getCol()] = (E) item;
  }

  /**
   * Attempt to retrieve the item stored at the location. Throw a IllegalArgumentException if the
   * location is invalid.
   * 
   * @param loc where to attempt to retrieve the item
   */
  @Override
  public E get(Location loc) {
    super.validLocation(loc);
    return data[loc.getRow()][loc.getCol()];
  }

  /**
   * Attempt to remove the item at loc if it was not null decrase numItems. Throw
   * IllegalArgumentException if loc is invalid.
   * 
   * @param loc location to remove the item at.
   */
  @Override
  public E remove(Location loc) {
    super.validLocation(loc);
    E removed = data[loc.getRow()][loc.getCol()];
    data[loc.getRow()][loc.getCol()] = null;
    if (removed != null) {
      numItems--;
    }
    return removed;
  }

  /**
   * gets numRows.
   */
  @Override
  public int numRows() {
    return data.length;
  }

  /**
   * gets numCols.
   */
  @Override
  public int numCols() {
    return data[0].length;
  }

  /**
   * gets numItems.
   */
  @Override
  public int numItems() {
    return numItems;
  }

  /**
   * returns all locations within the array.
   */
  @Override
  public Iterable<Location> allLocations() {
    ArrayList<Location> hold = new ArrayList<Location>();
    for (int r = 0; r < data.length; r++) {
      for (int c = 0; c < data[r].length; c++) {
        hold.add(new Location(r, c));
      }
    }
    return Collections.unmodifiableList(hold);
  }

  /**
   * returns only the locations with data.
   */
  @Override
  public Iterable<Location> itemLocations() {
    ArrayList<Location> hold = new ArrayList<Location>();
    for (int r = 0; r < data.length; r++) {
      for (int c = 0; c < data[r].length; c++) {
        if (data[r][c] != null) {
          hold.add(new Location(r, c));
        }
      }
    }
    return Collections.unmodifiableList(hold);
  }

  /**
   * returns the neighbors of the location if its valid.
   * 
   * @param loc the potential location
   */
  @Override
  public Iterable<Location> eightNeighbors(Location loc) {
    super.validLocation(loc);
    ArrayList<Location> hold = new ArrayList<Location>();
    if (loc.getRow() - 1 >= 0) {
      hold.add(new Location(loc.getRow() - 1, loc.getCol()));
      if (loc.getCol() - 1 >= 0) {
        hold.add(new Location(loc.getRow() - 1, loc.getCol() - 1));
      }
      if (loc.getCol() + 1 < data[0].length) {
        hold.add(new Location(loc.getRow() - 1, loc.getCol() + 1));
      }
    }
    if (loc.getRow() + 1 < data.length) {
      hold.add(new Location(loc.getRow() + 1, loc.getCol()));
      if (loc.getCol() + 1 < data[0].length) {
        hold.add(new Location(loc.getRow() + 1, loc.getCol() + 1));
      }
      if (loc.getCol() - 1 >= 0) {
        hold.add(new Location(loc.getRow() + 1, loc.getCol() - 1));
      }
    }
    if (loc.getCol() + 1 < data[0].length) {
      hold.add(new Location(loc.getRow(), loc.getCol() + 1));
    }
    if (loc.getCol() - 1 >= 0) {
      hold.add(new Location(loc.getRow(), loc.getCol() - 1));
    }
    return Collections.unmodifiableList(hold);
  }

  /**
   * returns the neighbors of the location if its valid.
   * 
   * @param loc the potential location
   */
  @Override
  public Iterable<Location> fourNeighbors(Location loc) {
    super.validLocation(loc);
    ArrayList<Location> hold = new ArrayList<Location>();
    if (loc.getRow() - 1 >= 0) {
      hold.add(new Location(loc.getRow() - 1, loc.getCol()));
    }
    if (loc.getRow() + 1 < data.length) {
      hold.add(new Location(loc.getRow() + 1, loc.getCol()));
    }
    if (loc.getCol() + 1 < data[0].length) {
      hold.add(new Location(loc.getRow(), loc.getCol() + 1));
    }
    if (loc.getCol() - 1 >= 0) {
      hold.add(new Location(loc.getRow(), loc.getCol() - 1));
    }
    return Collections.unmodifiableList(hold);
  }

  private class ArrayGridIterator implements Iterator<E> {

    private int index = 0;
    private boolean lastOperation = false;

    /**
     * checks if the array has another item.
     */
    @Override
    public boolean hasNext() {
      lastOperation = false;
      return (index < numItems && data[index % data.length][index / data.length] != null);
    }

    /**
     * gets the next item.
     */
    @Override
    public E next() {
      if (hasNext()) {
        lastOperation = true;
        E hold;
        hold = data[index % data.length][index / data.length];
        index++;
        return hold;
      }
      throw new NoSuchElementException();
    }

    /**
     * removes the last item given by next.
     */
    public void remove() {
      if (!lastOperation) {
        throw new IllegalStateException();
      }
      data[index - 1 % data.length][index - 1 / data.length] = null;
      for (int i = index - 1; i < numItems; i++) {
        data[i % data.length][i / data.length] = data[i + 1 % data.length][i + 1 / data.length];
      }
      lastOperation = false;
    }
  }
}
