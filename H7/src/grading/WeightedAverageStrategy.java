package grading;

import java.util.*;

/**
 * A GradingStrategy that calculates the weighted average of a collection of grades.
 *
 * @author Ann E. Coda, Sagacious Media
 */
public class WeightedAverageStrategy implements GradingStrategy
{
  private static final Double ZERO = new Double(0.0);

  private boolean shouldIgnoreMissing;
  private Map<String, Double> weights;

  /**
   * Default Constructor.
   */
  public WeightedAverageStrategy()
  {
    this(null, true);
  }

  /**
   * Explicit Value Constructor.
   *
   * @param weights
   *          The Map of weights to use (or null for equal weights)
   */
  public WeightedAverageStrategy(final Map<String, Double> weights)
  {
    super();
    this.weights = weights;
    this.shouldIgnoreMissing = true;
  }

  /**
   * Explicit Value Constructor.
   *
   * @param weights
   *          The Map of weights to use (or null for equal weights)
   * @param shouldIgnoreMissing
   *          true to ignore missing values; false to treat as 0
   */
  public WeightedAverageStrategy(final Map<String, Double> weights,
      final boolean shouldIgnoreMissing)
  {
    this.shouldIgnoreMissing = shouldIgnoreMissing;
    this.weights = weights;
  }

  /**
   * Use this GradingStrategy to calculate a numeric grade.
   *
   * Note: If there are no weights (i.e., the weights Map is null) then each grade is assumed to
   * have a weight of 1. If there are weights but an individual Grade does not have a corresponding
   * weight its weight is assumed to be 0.0.
   *
   * @param key
   *          The key for the Grade to return
   * @param grades
   *          The collection of grades
   * @return The numeric grade
   */
  public Grade calculate(final String key, final List<Grade> grades)
  {
    double denominator, numerator, w;
    Double grade, weight;

    // Early return
    // Size 0 check came before null check
    // null point exception thrown if null grades passed
    if ((grades == null) || (grades.size() == 0))
      return new LeafGrade(key, ZERO);

    numerator = 0.0;
    denominator = 0.0;

    for (Grade g : grades)
    {
      grade = g.getValue();

      if (weights == null) // All weights are unspecified
      {
        // if no weights were present all grades we multiplied by zero
        w = 1.0;
      }
      else // Some weights are specified
      {
        // w was always set to be 1
        w = weights.get(g.getKey());
      }

      if (grade == null)
      {
        // Handle a missing Grade
        if (!shouldIgnoreMissing)
        {
          // numerator += 0.0;
          denominator += w;
        }
      }
      else
      {
        // Handle an existing Grade
        numerator += w * grade;
        denominator += 1;
      }
    }

    return new LeafGrade(key, new Double(numerator / denominator));
  }
}
