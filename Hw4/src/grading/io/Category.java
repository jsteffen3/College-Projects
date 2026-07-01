package grading.io;

import java.util.List;

import grading.*;

/**
 * CS 345 HW4 Category.
 * 
 * @author Joshua Steffen
 * @version 2/10/22
 */
public class Category
{
  private Filter filter;
  private GradingStrategy strategy;
  private List<Grade> grades;
  private String key;

  /**
   * Creates a new Category.
   * 
   * @param key
   *          assigned to Category key
   * @param grades
   *          assigned to Category grades
   * @param filter
   *          assigned to Category filter
   * @param strategy
   *          assigned to Category strategy
   */
  public Category(final String key, final List<Grade> grades, final Filter filter,
      final GradingStrategy strategy)
  {
    if (key == null || key.equals(""))
    {
      throw new IllegalArgumentException();
    }
    this.key = key;
    this.grades = grades;
    this.filter = filter;
    this.strategy = strategy;
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
   * Returns the GradingStrategy.
   * 
   * @return the GradingStrategy
   */
  public GradingStrategy getStrategy()
  {
    return strategy;
  }

  /**
   * Returns the grades.
   * 
   * @return the grades
   */
  public List<Grade> getGrades()
  {
    return grades;
  }

  /**
   * Returns the key.
   * 
   * @return the key
   */
  public String getKey()
  {
    return key;
  }
}
