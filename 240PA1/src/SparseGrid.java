import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * CS 240 SparseGrid.
 * 
 * @author Joshua Steffen
 * @version 9/1/21
 */
public class SparseGrid<E> extends AbstractGrid<E> {

  private HashMap<Location, E> data;
  private int numRows;
  private int numCols;
  private int numItems;

  /**
   * Constructs an SparseGrid.
   * 
   * @param rows number of rows for the data
   * @param cols number of cols for the data
   */
  public SparseGrid(int rows, int cols) {
    if (rows < 1 || cols < 1) {
      throw new IllegalArgumentException();
    }
    numRows = rows;
    numCols = cols;
    data = new HashMap<Location, E>();
    numItems = 0;
  }

  /**
   * puts the element in the location if it and the location are valid.
   * 
   * @param loc potential location
   * @param item potential item
   */
  @Override
  public void put(Location loc, E item) {
    super.validLocation(loc);
    super.nullItemCheck(item);
    if (data.get(loc) == null) {
      numItems++;
    }
    data.put(loc, item);
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
    return data.get(loc);
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
    if (data.get(loc) != null) {
      numItems--;
    }
    return data.remove(loc);
  }

  /**
   * gets numRows.
   */
  @Override
  public int numRows() {
    return numRows;
  }

  /**
   * gets numCols.
   */
  @Override
  public int numCols() {
    return numCols;
  }

  /**
   * gets numItems.
   */
  @Override
  public int numItems() {
    return numItems;
  }

  /**
   * returns all locations within the grid.
   */
  @Override
  public Iterable<Location> allLocations() {
    ArrayList<Location> hold = new ArrayList<Location>();
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
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
    return java.util.Collections.unmodifiableSet(data.keySet());
  }

  /**
   * returns the neighbors of the location if its valid.
   * 
   * @param loc the potential location
   */
  @Override
  public Iterable<Location> eightNeighbors(Location loc) {
    super.validLocation(loc);
    ArrayList<Location> neighbors = new ArrayList<Location>();
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        if (r == loc.getRow() - 1 && c == loc.getCol() - 1) {
          neighbors.add(new Location(r, c));
        } else if (r == loc.getRow() - 1 && c == loc.getCol()) {
          neighbors.add(new Location(r, c));
        } else if (r == loc.getRow() - 1 && c == loc.getCol() + 1) {
          neighbors.add(new Location(r, c));
        } else if (c == loc.getCol() - 1 && r == loc.getRow()) {
          neighbors.add(new Location(r, c));
        } else if (c == loc.getCol() + 1 && r == loc.getRow()) {
          neighbors.add(new Location(r, c));
        } else if (r == loc.getRow() + 1 && c == loc.getCol() - 1) {
          neighbors.add(new Location(r, c));
        } else if (r == loc.getRow() + 1 && c == loc.getCol()) {
          neighbors.add(new Location(r, c));
        } else if (r == loc.getRow() + 1 && c == loc.getCol() + 1) {
          neighbors.add(new Location(r, c));
        }
      }
    }
    return Collections.unmodifiableList(neighbors);
  }

  /**
   * returns the neighbors of the location if its valid.
   * 
   * @param loc the potential location
   */
  @Override
  public Iterable<Location> fourNeighbors(Location loc) {
    super.validLocation(loc);
    ArrayList<Location> neighbors = new ArrayList<Location>();
    for (int r = 0; r < numRows; r++) {
      for (int c = 0; c < numCols; c++) {
        if (r == loc.getRow() - 1 && c == loc.getCol()) {
          neighbors.add(new Location(r, c));
        } else if (c == loc.getCol() - 1 && r == loc.getRow()) {
          neighbors.add(new Location(r, c));
        } else if (c == loc.getCol() + 1 && r == loc.getRow()) {
          neighbors.add(new Location(r, c));
        } else if (r == loc.getRow() + 1 && c == loc.getCol()) {
          neighbors.add(new Location(r, c));
        }
      }
    }
    return Collections.unmodifiableList(neighbors);
  }

  /**
   * Creates an iterator for the class.
   */
  @Override
  public Iterator<E> iterator() {
    return new SparseGridIterator();
  }

  private class SparseGridIterator implements Iterator<E> {

    private int index = 0;
    private boolean lastOperation = false;

    /**
     * checks if the array has another item.
     */
    @Override
    public boolean hasNext() {
      lastOperation = false;
      return (index < numItems && data.get(new Location(index % numRows, index / numRows)) != null);
    }

    /**
     * gets the next item.
     */
    @Override
    public E next() {
      if (hasNext()) {
        lastOperation = true;
        E hold;
        hold = data.get(new Location(index % numRows, index / numRows));
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
      data.remove(new Location(index - 1 % numRows, index - 1 / numRows));
      for (int i = index - 1; i < numItems; i++) {
        data.put(new Location(i % numRows, i / numRows),
            data.get(new Location(i + 1 % numRows, i + 1 / numRows)));
      }
      lastOperation = false;
    }
  }
}
