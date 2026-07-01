package grading;

/**
 * CS 345 HW5 Grade.
 * 
 * @author Joshua Steffen
 * @version 2/17/22
 */
public interface Grade extends Comparable
{

  /**
   * Returns the key.
   * 
   * @return the key
   */
  public String getKey();

  /**
   * Returns the value.
   * 
   * @return the value
   */
  public Double getValue();
}
