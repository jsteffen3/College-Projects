package grading;

/**
 * CS 345 HW1 Missing.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
public class Missing
{
  private static double DEFAULT_MISSING_VALUE = 0;

  /**
   * Determines if the double is null if it is returns 0.0.
   * 
   * @param number
   *          to check
   * @return the value
   */
  public static double doubleValue(final Double number)
  {
    if (number == null)
    {
      return DEFAULT_MISSING_VALUE;
    }
    return (double) number;
  }

  /**
   * Determines if the double is null if it is returns missingValue.
   * 
   * @param number
   *          to check
   * @param missingValue
   *          to return if number is null
   * @return the determines values
   */
  public static double doubleValue(final Double number, final double missingValue)
  {
    if (number == null)
    {
      return missingValue;
    }
    return (double) number;
  }
}
