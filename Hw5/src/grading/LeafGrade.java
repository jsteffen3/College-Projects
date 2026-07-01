package grading;

/**
 * CS 345 HW5 LeafGrade.
 * 
 * @author Joshua Steffen
 * @version 2/17/22
 */
public class LeafGrade extends AbstractGrade
{
  private Double value;

  /**
   * Default Constructor.
   * 
   * @param key
   *          the name
   * @throws IllegalArgumentException
   *           thrown if key is null or ""
   */
  public LeafGrade(final String key) throws IllegalArgumentException
  {
    super(key);
    this.value = 0.0;
  }

  /**
   * Constructs a new Leaf Grade.
   * 
   * @param key
   *          the name
   * @param value
   *          the amount for value
   * @throws IllegalArgumentException
   *           thrown if key is null or ""
   */
  public LeafGrade(final String key, final double value) throws IllegalArgumentException
  {
    super(key);
    this.value = value;
  }

  /**
   * Constructs a new Leaf Grade.
   * 
   * @param key
   *          the name
   * @param value
   *          the amount for value
   * @throws IllegalArgumentException
   *           thrown if key is null or ""
   */
  public LeafGrade(final String key, final Double value) throws IllegalArgumentException
  {
    super(key);
    this.value = value;
  }

  /**
   * Returns the value.
   */
  @Override
  public Double getValue()
  {
    return value;
  }

  /**
   * Returns the Grade as a String.
   */
  @Override
  public String toString()
  {
    if (value == null)
    {
      return super.toString();
    }
    else
    {
      return String.format("%s: %5.1f", this.getKey(), value);
    }
  }

  /**
   * Compares this grade to the given.
   * 
   * @param other
   *          compare to this
   */
  @Override
  public int compareTo(final Object other)
  {
    return super.compareTo(other);
  }

  /**
   * Creates a LeafGrade with the given params.
   * 
   * @param key
   *          the name
   * @param value
   *          the value
   * @return the new grade
   * @throws IllegalArgumentException
   *           thrown if key is null or ""
   */
  public static LeafGrade parseLeafGrade(final String key, final String value)
      throws IllegalArgumentException
  {
    if (key == null || key.equals(""))
    {
      throw new IllegalArgumentException();
    }
    LeafGrade result = new LeafGrade(key, Double.parseDouble(value));
    return result;
  }
}
