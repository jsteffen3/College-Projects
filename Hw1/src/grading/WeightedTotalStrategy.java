package grading;

import java.util.List;
import java.util.Map;

/**
 * CS 345 HW1 WeightedTotalStrategy.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
public class WeightedTotalStrategy extends TotalStrategy implements GradingStrategy
{
  private Map<String, Double> weights;

  /**
   * Default constructor initializes weights to null.
   */
  public WeightedTotalStrategy()
  {
    weights = null;
  }

  /**
   * Constructor initializes weights to the given map.
   * 
   * @param weights
   *          the map to initialize
   */
  public WeightedTotalStrategy(final Map<String, Double> weights)
  {
    this.weights = weights;
  }

  /**
   * Calculates the weighted total of a type of grade.
   * 
   * @param key
   *          the type of grade
   * @param grades
   *          the grades to be weighted
   */
  @Override
  public Grade calculate(final String key, final List<Grade> grades) throws SizeException
  {
    if (grades == null || grades.size() == 0)
    {
      throw new SizeException();
    }
    double weight;
    if (weights != null)
      weight = Missing.doubleValue(weights.get(key), 1.0);
    else
      weight = 1.0;
    return new Grade(key, super.calculate(key, grades).getValue() * weight);
  }

}
