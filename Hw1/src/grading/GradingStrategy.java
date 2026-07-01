package grading;

import java.util.List;

/**
 * CS 345 HW1 GradingStrategy.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
public interface GradingStrategy
{
  /**
   * Calculates the grade.
   * 
   * @param key
   *          for the new grade
   * @param grades
   *          to total
   * @return the grade
   * @throws SizeException
   *           throw if grades is null or 0 size
   */
  public Grade calculate(String key, List<Grade> grades) throws SizeException;
}
