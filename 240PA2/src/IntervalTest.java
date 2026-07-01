import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * CS240 PA2 TestInterval. This Code Compiles in accordance with the JMU honor Code I received no
 * outside help on this assignment.
 * 
 * @author Joshua Steffen
 * @version 9/24/21
 */
class IntervalTest {

  /**
   * Test the constructor for accepting data and throwing errors.
   */
  @Test
  public void testConstructor() {
    assertThrows(IllegalArgumentException.class, () -> new Interval(3, 2));
    Interval correct = new Interval(2, 3);
    assertEquals(2, correct.getLowerBound());
    assertEquals(3, correct.getUpperBound());
  }

  /**
   * Test Size for correctness.
   */
  @Test
  public void testSize() {
    Interval correct = new Interval(2, 3);
    assertEquals(2, correct.size());
  }

  /**
   * Tests for Enclose.
   */
  @Test
  public void testEnclose() {
    Interval correct = new Interval(2, 3);
    correct.enclose(1);
    assertEquals(1, correct.getLowerBound());
    correct.enclose(4);
    assertEquals(4, correct.getUpperBound());
    correct.enclose(3);
    assertEquals(4, correct.getUpperBound());
    assertEquals(1, correct.getLowerBound());
    correct.enclose(6);
    assertEquals(6, correct.getUpperBound());
    assertEquals(1, correct.getLowerBound());
  }

  /**
   * Tests for SetUpperBound and SetLowerBound.
   */
  @Test
  public void testSetBounds() {
    Interval correct = new Interval(2, 3);
    correct.setUpperBound(2);
    assertEquals(2, correct.getUpperBound());
    correct.setLowerBound(1);
    assertEquals(1, correct.getLowerBound());
    assertThrows(IllegalArgumentException.class, () -> correct.setLowerBound(4));
    assertThrows(IllegalArgumentException.class, () -> correct.setUpperBound(0));
  }

  /**
   * Tests for Contains.
   */
  @Test
  public void testContains() {
    Interval correct = new Interval(2, 4);
    assertFalse(correct.contains(6));
    assertFalse(correct.contains(0));
    assertTrue(correct.contains(3));
  }

  @Test
  public void testToString() {
    Interval correct = new Interval(2, 3);
    Interval correctSameValues = new Interval(3, 3);
    String sameValues = "3";
    assertTrue(sameValues.equals(correctSameValues.toString()));
    assertTrue(correct.toString().equals("2-3"));
  }
}
