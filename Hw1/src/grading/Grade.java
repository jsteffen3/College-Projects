package grading;

/**
 * CS 345 HW1 Grade.
 * 
 * @author Joshua Steffen
 * @version 2/17/22
 */
public class Grade implements Comparable
{
  private String key;
  private Double value;

  /**
   * Creates a Grade obj with given key and a value of 0.0.
   * 
   * @param key
   *          assigned to this.key if no errors
   * @throws IllegalArgumentException
   *           thrown if key is null or empty
   */
  public Grade(final String key) throws IllegalArgumentException
  {
    if (key == null || key.equals(""))
      throw new IllegalArgumentException();
    this.key = key.substring(0);
    this.value = 0.0;
  }

  /**
   * Creates a Grade obj with given key and value.
   * 
   * @param key
   *          assigned to this.key if no errors
   * @param value
   *          assigned to this.value
   * @throws IllegalArgumentException
   *           thrown if key is null or empty
   */
  public Grade(final String key, final double value) throws IllegalArgumentException
  {
    if (key == null || key.equals(""))
      throw new IllegalArgumentException();
    this.key = key.substring(0);
    this.value = value;
  }

  /**
   * Creates a Grade obj with given key and value.
   * 
   * @param key
   *          assigned to this.key if no errors
   * @param value
   *          assigned to this.value
   * @throws IllegalArgumentException
   *           thrown if key is null or empty
   */
  public Grade(final String key, final Double value) throws IllegalArgumentException
  {
    if (key == null || key.equals(""))
      throw new IllegalArgumentException();
    this.key = key.substring(0);
    this.value = value;
  }

  /**
   * Returns the grades key.
   * 
   * @return this.key
   */
  public String getKey()
  {
    return key;
  }

  /**
   * Returns the grades value.
   * 
   * @return this.value
   */
  public Double getValue()
  {
    return value;
  }

  /**
   * Converts the grade into a string.
   * 
   * @return the grade as a string
   */
  public String toString()
  {
    String result = this.key + ": ";
    if (value != null)
      result += String.format("%5.1f", this.value);
    else
      result += String.format("%5s", "NA");
    return result;
  }

  /**
   * Checks if the given grade is equal to this grade.
   * 
   * @return 0 if the same -1 if this is less 1 if this is greater
   */
  @Override
  public int compareTo(final Object o)
  {
    int result = 0;
    Grade other = (Grade) o;
    if (this.value == null || other.getValue() == null)
    {
      if (this.value == null && other.getValue() == null)
      {
        result = 0;
      }
      else if (this.value == null)
      {
        result = -1;
      }
      else
      {
        result = 1;
      }
    }
    else
    {
      result = this.value.compareTo(other.getValue());
    }
    return result;
  }
}
