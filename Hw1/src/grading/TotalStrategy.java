package grading;
import java.util.List;

/**
 * CS 345 HW1 TotalStrategy.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
public class TotalStrategy implements GradingStrategy
{

  /**
   * Default constructor.
   */
  public TotalStrategy()
  {

  }

  /**
   * Adds up all grades of given key.
   */
  @Override
  public Grade calculate(final String key, final List<Grade> grades) throws SizeException
  {
    if (grades == null || grades.size() == 0)
    {
      throw new SizeException();
    }
    Grade result;
    double total = 0.0;
    for (int i = 0; i < grades.size(); i++)
    {
      if (grades.get(i).getKey().equals(key) && grades.get(i).getValue() != null)
        total += grades.get(i).getValue();
    }
    result = new Grade(key, total);
    return result;
  }

}
