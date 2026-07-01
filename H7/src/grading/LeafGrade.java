package grading;

/**
 * An immutable individual (i.e., component in the sense of the
 * Composite Pattern) Grade object.
 *
 * @author  Prof. David Bernstein, James Madison University
 */
public class LeafGrade extends AbstractGrade
{
  private Double        value;

  /**
   * Construct a Grade with the given key and a value of 0.0.
   *
   * @param key  The key used to identify this Grade object
   * @throws     IllegalArgumentException if key is null or the empty string
   */
  public LeafGrade(final String key) throws IllegalArgumentException
  {
    this(key, Double.valueOf(0.0));        
  }

  /**
   * Construct a Grade with the given key and value.
   *
   * @param key   The key used to identify this Grade object
   * @param value The value of this Grade
   * @throws      IllegalArgumentException if key is null or the empty string
   */
  public LeafGrade(final String key, final double value) throws IllegalArgumentException
  {
    this(key, Double.valueOf(value));
  }

  /**
   * Construct a Grade with the given key and value.
   *
   * @param key   The key used to identify this Grade object
   * @param value The value of this Grade
   * @throws      IllegalArgumentException if key is null or the empty string
   */
  public LeafGrade(final String key, final Double value) throws IllegalArgumentException
  {
    super(key);
    this.value = value;
  }

  /**
   * Get the numeric value associated with this Grade object.
   *
   * @return   The numeric value (or null for missing)
   */
  public Double getValue()
  {
    return value;        
  }

	/**
	 * Construct a LeafGrade object from a key and a String representation of
	 * its value. If the String representation of the value is null or not a valid
	 * double then the resulting LeafGrade will have a missing value.
	 * 
	 * @param key   The key for the LeafGrade
	 * @param value The String representation of the value
	 * @return      The corresponding LeafGrade object
	 * @throws IllegalArgumentException if the key is invalid
	 */
	public static LeafGrade parseLeafGrade(final String key, final String value) 
	    throws IllegalArgumentException
	{
		LeafGrade  result;
		
		try
		{
			Double   v;
			if (value == null) v = null;
			else               v = Double.valueOf(Double.parseDouble(value));
			
			result = new LeafGrade(key, v);
		}
		catch (NumberFormatException nfe)
		{
			result = new LeafGrade(key, null);
		}
		
		return result;
	}
}
