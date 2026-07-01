package grading;

import java.util.ArrayList;
import java.util.List;

/**
 * A composite (in the sense of the Composite Pattern) of Grade objects.
 *
 * @author  Prof. David Bernstein, James Madison University
 * @version 1.0
 */
public class CompositeGrade extends AbstractGrade
{
  private Filter                filter;    
  private GradingStrategy       strategy;    
  private List<Grade>           components;

  /**
   * Explicit Value Constructor.
   *
   * @param key   The key for this CompositeGrade object
   * @throws      IllegalArgumentException if key is null or the empty string
   */
  public CompositeGrade(final String key) throws IllegalArgumentException
  {
    super(key);
    components = new ArrayList<Grade>();
  }

  /**
   * Add a Grade object to this CompositeGrade.
   *
   * @param grade   The Grade object to add.
   */
  public void add(final Grade grade)
  {
    components.add(grade);
  }
  
  /**
   * Get the component Grade objects.
   * 
   * @return The Grade objects in this CompositeGrade
   */
  public List<Grade> getComponents()
  {
    return components;
  }
  
  /**
   * Get the Filter associated with this CompositeGrade.
   * 
   * @return  The filter
   */
  public Filter getFilter()
  {
    return filter;
  }
  
  /**
   * Get the GradingStrategy associated with this CompositeGrade.
   * 
   * @return  The GradingStrategy
   */
  public GradingStrategy getStrategy()
  {
    return strategy;
  }
  
  /**
   * Get the value of this Grade object (required by Grade).
   *
   * @return   The value of this Grade object (or null for missing)
   */
  public Double getValue()
  {
    Double             result = null;
    List<Grade>        filtered = components;
	  
    try
    {
  	  if (filter   != null) filtered = filter.apply(components);
      if (strategy != null) result   = strategy.calculate(getKey(), filtered).getValue();
    }
    catch (SizeException se)
    {
    	// Return null (the default)
    }

    return result;
  }

  /**
   * Set the Filter.
   *
   * @param filter   The Filter to use
   */
  public void setFilter(final Filter filter)
  {
    this.filter = filter;        
  }

  /**
   * Set the GradingStrategy.
   *
   * @param strategy   The GradingStrategy to use
   */
  public void setStrategy(final GradingStrategy strategy)
  {
    this.strategy = strategy;        
  }
}
