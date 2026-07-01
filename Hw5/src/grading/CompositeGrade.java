package grading;

import java.util.ArrayList;
import java.util.List;

/**
 * CS 345 HW5 CompositeGrade.
 * 
 * @author Joshua Steffen
 * @version 2/17/22
 */
public class CompositeGrade extends AbstractGrade
{

  private Filter filter;
  private GradingStrategy strategy;
  private List<Grade> components;

  /**
   * Creates a new CompositeGrade.
   * 
   * @param key
   *          the name
   * @throws IllegalArgumentException
   *           thrown if key is "" or null
   */
  public CompositeGrade(final String key) throws IllegalArgumentException
  {
    super(key);
    this.components = new ArrayList<Grade>();
  }

  /**
   * Adds the grade to components.
   * 
   * @param grade
   *          to be added
   */
  public void add(final Grade grade)
  {
    components.add(grade);
  }

  /**
   * Returns the components.
   * 
   * @return components
   */
  public List<Grade> getComponents()
  {
    return components;
  }

  /**
   * Returns the filter.
   * 
   * @return the filter
   */
  public Filter getFilter()
  {
    return filter;
  }

  /**
   * Returns the strat.
   * 
   * @return the GradingStrategy
   */
  public GradingStrategy getStrategy()
  {
    return strategy;
  }

  /**
   * Gets the value.
   * 
   * @return the value
   */
  public Double getValue()
  {
    try
    {
      return strategy.calculate(this.getKey(), filter.apply(components)).getValue();
    }
    catch (SizeException e)
    {
      return 0.0;
    }
  }

  /**
   * Sets the filter to the given.
   * 
   * @param filter
   *          to set
   */
  public void setFilter(final Filter filter)
  {
    this.filter = filter;
  }

  /**
   * Sets the Strategy to the given.
   * 
   * @param strategy
   */
  public void setStrategy(final GradingStrategy strategy)
  {
    this.strategy = strategy;
  }
}
