/**
 * CS 240 Grid.
 * 
 * @author Joshua Steffen
 * @version 9/1/21
 */
public interface Grid<E> extends Iterable<E> {
  /**
   * puts the element in the location if it and the location are valid.
   * 
   * @param loc potential location
   * @param item potential item
   */
  public void put(Location loc, E item);

  /**
   * Attempt to retrieve the item stored at the location. Throw a IllegalArgumentException if the
   * location is invalid.
   * 
   * @param loc where to attempt to retrieve the item
   */
  public E get(Location loc);

  /**
   * Attempt to remove the item at loc if it was not null decrase numItems. Throw
   * IllegalArgumentException if loc is invalid.
   * 
   * @param loc location to remove the item at.
   */
  public E remove(Location loc);

  /**
   * gets numRows.
   */
  public int numRows();

  /**
   * gets numCols.
   */
  public int numCols();

  /**
   * gets numItems.
   */
  public int numItems();

  /**
   * returns all locations within the grid.
   */
  public Iterable<Location> allLocations();

  /**
   * returns only the locations with data.
   */
  public Iterable<Location> itemLocations();

  /**
   * returns the neighbors of the location if its valid.
   * 
   * @param loc the potential location
   */
  public Iterable<Location> eightNeighbors(Location loc);

  /**
   * returns the neighbors of the location if its valid.
   * 
   * @param loc the potential location
   */
  public Iterable<Location> fourNeighbors(Location loc);
}
