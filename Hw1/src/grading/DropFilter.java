package grading;

import java.util.ArrayList;
import java.util.List;

/**
 * CS 345 HW1 DropFilter.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
public class DropFilter implements Filter
{
  private boolean shouldDropLowest;
  private boolean shouldDropHighest;

  /**
   * Default constructor.
   */
  public DropFilter()
  {
    shouldDropLowest = true;
    shouldDropHighest = true;
  }

  /**
   * Constructor with paramenters.
   * 
   * @param shouldDropLowest
   *          whether the lowest grade is dropped
   * @param shouldDropHighest
   *          whether the highest grade is dropped
   */
  public DropFilter(final boolean shouldDropLowest, final boolean shouldDropHighest)
  {
    this.shouldDropLowest = shouldDropLowest;
    this.shouldDropHighest = shouldDropHighest;
  }

  @Override
  public List<Grade> apply(final List<Grade> grades) throws SizeException
  {
    if (grades == null || grades.size() == 0)
      throw new SizeException();
    int count = 0;
    if (shouldDropLowest)
      count++;
    if (shouldDropHighest)
      count++;
    if (count >= grades.size())
      throw new SizeException();
    ArrayList<Grade> edit = new ArrayList<Grade>(grades);
    if (shouldDropHighest)
    {
      double high = 0.0;
      int indexOfHigh = 0;
      for (int i = 0; i < edit.size(); i++)
      {
        if (high < Missing.doubleValue(edit.get(i).getValue()))
        {
          high = Missing.doubleValue(edit.get(i).getValue());
          indexOfHigh = i;
        }
      }
      edit.remove(indexOfHigh);
    }
    if (shouldDropLowest)
    {
      double low = 100.0;
      int indexOfLow = 0;
      for (int i = 0; i < edit.size(); i++)
      {
        if (low > Missing.doubleValue(edit.get(i).getValue()))
        {
          low = Missing.doubleValue(edit.get(i).getValue());
          indexOfLow = i;
        }
      }
      edit.remove(indexOfLow);
    }
    return edit;
  }
}
