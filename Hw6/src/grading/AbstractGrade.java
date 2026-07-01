package grading;

/**
 * A partial implementation of the Grade interface that handles the key
 * and the compareTo() method.
 * 
 * @author Prof. David Bernstein, James Madison University
 */
public abstract class AbstractGrade implements Grade
{
  private String          key;

  /**
   * Explicit Value Constructor.
   * 
   * @param key   The key that identifies this Grade
   * @throws      IllegalArgumentException if key is null or the empty string
   */
  protected AbstractGrade(final String key) throws IllegalArgumentException
  {
    if ((key == null) || key.equals("")) throw new IllegalArgumentException();

    this.key = key;
  }

  /**
   * Compare this Grade object (which is a Graded object) with the specified 
   * Graded object for order (required by Graded).
   *
   * @param other  The object to compare to
   * @return       -1/0/1 depending on whether this </==/> other
   */
  public int compareTo(final Grade other)
  {
	  int result = 0;
	  
	  if      ((this.getValue() == null) && (other.getValue() == null)) result =  0;
	  else if (this.getValue() == null)                                 result = -1;
	  else if (other.getValue() == null)                                result =  1;
	  else result = this.getValue().compareTo(other.getValue());
	  
	  return result;
  }

  /**
   * Get the key associated with this Grade object.
   *
   * @return   The key
   */
  public String getKey()
  {
    return key;        
  }

  /**
   * Create a String representation of this Grade object.
   *
   * @return  The String representation
   */
  public String toString()
  {
    if (getValue() == null) return String.format("%s: %5s",   key, "NA");
    else                    return String.format("%s: %5.1f", key, getValue());        
  }
}
