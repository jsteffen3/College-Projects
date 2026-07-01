package grading;

/**
 * An immutable individual Grade object.
 *
 * @author Prof. David Bernstein, James Madison University
 */
public class Grade implements Comparable<Grade>
{
  private Double value;
  private String key;

  /**
   * Construct a Grade with the given key and a value of 0.0.
   *
   * @param key
   *          The key used to identify this Grade object
   * @throws IllegalArgumentException
   *           if key is null or the empty string
   */
  public Grade(final String key) throws IllegalArgumentException
  {
    this(key, Double.valueOf(0.0));
  }

  /**
   * Construct a Grade with the given key and value.
   *
   * @param key
   *          The key used to identify this Grade object
   * @param value
   *          The value of this Grade
   * @throws IllegalArgumentException
   *           if key is null or the empty string
   */
  public Grade(final String key, final double value) throws IllegalArgumentException
  {
    this(key, Double.valueOf(value));
  }

  /**
   * Construct a Grade with the given key and value.
   *
   * @param key
   *          The key used to identify this Grade object
   * @param value
   *          The value of this Grade
   * @throws IllegalArgumentException
   *           if key is null or the empty string
   */
  public Grade(final String key, final Double value) throws IllegalArgumentException
  {
    if ((key == null) || key.equals(""))
      throw new IllegalArgumentException();

    this.key = key;
    this.value = value;
  }

  /**
   * Compare this Grade object with the specified Grade object for order (required by
   * Comparable<Grade>).
   *
   * @param other
   *          The object to compare to
   * @return -1/0/1 depending on whether this </==/> other
   */
  public int compareTo(final Grade other)
  {
    int result = 0;

    if ((this.getValue() == null) && (other.getValue() == null))
      result = 0;
    else if (this.getValue() == null)
      result = -1;
    else if (other.getValue() == null)
      result = 1;
    else
      result = this.getValue().compareTo(other.getValue());

    return result;
  }

  /**
   * Get the key associated with this Grade object.
   *
   * @return The key
   */
  public String getKey()
  {
    return key;
  }

  /**
   * Get the numeric value associated with this Grade object.
   *
   * @return The numeric value (or null for missing)
   */
  public Double getValue()
  {
    return value;
  }

  /**
   * Create a String representation of this Grade.
   *
   * @return The String representation
   */
  public String toString()
  {
    if (value == null)
      return String.format("%s: %5s", key, "NA");
    else
      return String.format("%s: %5.1f", key, value);
  }

}
