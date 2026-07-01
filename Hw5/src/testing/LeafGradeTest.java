package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import grading.*;

/**
 * CS 345 HW5 LeafGradeTest.
 * 
 * @author Joshua Steffen
 * @version 2/17/22
 */
class LeafGradeTest
{

  @Test
  void testConstructorErrors()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      new LeafGrade(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new LeafGrade("");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new LeafGrade(null, 0.0);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new LeafGrade("", 0.0);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new LeafGrade(null, null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new LeafGrade("", null);
    });
  }

  @Test
  void testConstruction()
  {
    LeafGrade first = new LeafGrade("test");
    LeafGrade second = new LeafGrade("test", 5.0);
    LeafGrade third = new LeafGrade("test", new Double(5.0));
    assertEquals("test", first.getKey());
    assertEquals("test", second.getKey());
    assertEquals("test", third.getKey());
    assertEquals(0.0, first.getValue());
    assertEquals(5.0, second.getValue());
    assertEquals(5.0, third.getValue());
  }

  @Test
  void testToString()
  {
    LeafGrade nullValue = new LeafGrade("test", null);
    LeafGrade nonNullValue = new LeafGrade("test", 5.0);
    assertEquals("test:    NA", nullValue.toString());
    assertEquals("test:   5.0", nonNullValue.toString());
  }

  @Test
  void testParse()
  {
    LeafGrade result = new LeafGrade("test", 5);
    assertEquals(0, result.compareTo(LeafGrade.parseLeafGrade("test", "5")));
  }
  
  @Test
  void testCompareTo() {
    LeafGrade low = new LeafGrade("key", 0.0);
    LeafGrade high = new LeafGrade("key", 100.0);
    assertEquals(-1, low.compareTo(high));
    assertEquals(0, low.compareTo(low));
    assertEquals(1, high.compareTo(low));
    LeafGrade isnull = new LeafGrade("key", null);
    assertEquals(-1, isnull.compareTo(high));
    assertEquals(0, isnull.compareTo(isnull));
    assertEquals(1, high.compareTo(isnull));
  }
}
