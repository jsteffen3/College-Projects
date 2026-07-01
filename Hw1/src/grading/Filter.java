package grading;

import java.util.List;

/**
 * CS 345 HW1 Filter.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
public interface Filter
{
  /**
   * Filters out grades as specified in implementing object.
   * 
   * @param grades
   *          to filter
   * @return new List of grades with the required grades removed
   * @throws SizeException
   *           thrown if grades is smaller than the required number to be removed
   */
  public List<Grade> apply(List<Grade> grades) throws SizeException;
}
