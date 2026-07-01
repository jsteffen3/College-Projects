/**
 * Mutable 2-tuple type.
 * 
 * @author Nathan Sprague and Michael S. Kirkpatrick
 * @version V4, 8/2021
 */
public class Pair<F, S> {

  private F first;
  private S second;

  /**
   * Create an Pair with the provided objects.
   * 
   * @param first The first object.
   * @param second The second object.
   */
  public Pair(F first, S second) {
    this.first = first;
    this.second = second;
  }

  public F getFirst() {
    return first;
  }

  public void setFirst(F first) {
    this.first = first;
  }

  public S getSecond() {
    return second;
  }

  public void setSecond(S second) {
    this.second = second;
  }

  @Override
  public String toString() {
    return "<" + first.toString() + ", " + second.toString() + ">";
  }

}