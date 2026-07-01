package grading.io;

import java.util.List;

import grading.*;

/**
 * CS 345 HW4 Course.
 * 
 * @author Joshua Steffen
 * @version 2/10/22
 */
public class Course
{

  private GradingStrategy strategy;
  private List<Category> categories;

  /**
   * Creates a new Course object.
   * 
   * @param categories
   *          assigned to categories
   * @param strategy
   *          assigned to strategy
   */
  public Course(final List<Category> categories, final GradingStrategy strategy)
  {
    this.strategy = strategy;
    this.categories = categories;
  }

  /**
   * Returns the categories.
   * 
   * @return the categories
   */
  public List<Category> getCategories()
  {
    return categories;
  }

  /**
   * Returns the strategy.
   * 
   * @return the strategy
   */
  public GradingStrategy getStrategy()
  {
    return strategy;
  }
}
