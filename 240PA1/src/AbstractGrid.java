import java.util.ArrayList;
import java.util.Collections;

/**
 * CS 240 ArrayGrid.
 * 
 * @author Joshua Steffen
 * @version 9/1/21
 */
public abstract class AbstractGrid<E> implements Grid<E> {

  /**
   * Constructor.
   */
  public AbstractGrid() {

  }

  /**
   * checks if the given location is valid.
   * 
   * @param loc the potential location
   */
  public void validLocation(Location loc) {
    if (numRows() <= loc.getRow() || numCols() <= loc.getCol()) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * checks if the item is null.
   * 
   * @param item the potential item.
   */
  public void nullItemCheck(E item) {
    if (item == null) {
      throw new NullPointerException();
    }
  }

}
