package grading;

/**
 * CS 345 HW5 AbstractGrade.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
public abstract class AbstractGrade implements Grade
{

  private String key;

  /**
   * Creates a new AbstractGrade.
   * 
   * @param key
   *          the name
   * @throws IllegalArgumentException
   *           thrown if key is null or ""
   */
  public AbstractGrade(final String key) throws IllegalArgumentException
  {
    if (key == null || key.contentEquals(""))
    {
      throw new IllegalArgumentException();
    }
    this.key = key;
  }

  /**
   * Returns the key.
   * 
   * @return the key
   */
  public String getKey()
  {
    return this.key;
  }

  /**
   * Returns the value.
   * 
   * @return the value
   */
  public abstract Double getValue();

  /**
   * Returns the Grade as a String.
   * 
   * @return the Grade as a String
   */
  public String toString()
  {
    return this.key + ": " + String.format("%5s", "NA");
  }

  /**
   * Compares this to other.
   * 
   * @return -1 other > this 0 other = this 1 other < this
   */
  @Override
  public int compareTo(final Object other)
  {
    Grade o = (Grade) other;
    if (this.getValue() != null && o.getValue() == null)
    {
      return 1;
    }
    else if (this.getValue() == null && o.getValue() == null)
    {
      return 0;
    }
    else if (this.getValue() == null && o.getValue() != null)
    {
      return -1;
    }
    else
    {
      return this.getValue().compareTo(o.getValue());
    }
  }
}
