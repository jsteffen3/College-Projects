/**
 * CS240 PA2 Interval. This Code Compiles in accordance with the JMU honor Code I received no
 * outside help on this assignment.
 * 
 * @author Joshua Steffen
 * @version 9/24/21
 */
public class Interval {

  private int low;
  private int high;

  /**
   * Constructs a new interval.
   * 
   * @param lower the intervals lower bound
   * @param upper the intervals upper bound
   */
  public Interval(int lower, int upper) {
    if (upper < lower) {
      throw new IllegalArgumentException();
    }
    low = lower;
    high = upper;
  }

  /**
   * Returns the upper bound.
   * 
   * @return the value of low
   */
  public int getLowerBound() {
    return low;
  }

  /**
   * Returns the upper bound.
   * 
   * @return the value of high
   */
  public int getUpperBound() {
    return high;
  }

  /**
   * Returns the number of integers in the interval.
   * 
   * @return the number of integers in the interval
   */
  public int size() {
    return high - low + 1;
  }

  /**
   * Checks if the integer is one less or one greater than the bounds and adds it.
   * 
   * @param add the potential integer
   */
  public void enclose(int add) {
    if (add > high) {
      high = add;
    } else if (add < low) {
      low = add;
    }
  }

  /**
   * Attempts to adjust the lower bound.
   * 
   * @param add potential new Lower Bound
   */
  public void setLowerBound(int add) {
    if (add > high) {
      throw new IllegalArgumentException();
    }
    low = add;
  }

  /**
   * Attempts to adjust the Upper bound.
   * 
   * @param add potential new Lower Bound
   */
  public void setUpperBound(int add) {
    if (add < low) {
      throw new IllegalArgumentException();
    }
    high = add;
  }

  /**
   * checks to see if test is within the bounds of the interval.
   * 
   * @param test number to be tested against the bounds
   * @return if test is in the bounds
   */
  public boolean contains(int test) {
    if (test > high || test < low) {
      return false;
    }
    return true;
  }

  /**
   * returns the interval as a String.
   * 
   * @return the interval as a String
   */
  public String toString() {
    if (high == low) {
      return "" + high;
    }
    return "" + low + "-" + high;
  }

}
