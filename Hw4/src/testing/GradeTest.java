package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import grading.Grade;

/**
 * CS 345 HW1 GradeTest.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
class GradeTest
{

  /**
   * Tests for the default constructor.
   */
  @Test
  void testDefaultConstructor()
  {
    Grade test = new Grade("key");
    assertEquals("key", test.getKey());
    assertThrows(IllegalArgumentException.class, () -> {
      new Grade(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Grade("");
    });
  }

  /**
   * Tests for the second constructor.
   */
  @Test
  void test2Constructor()
  {
    Grade test = new Grade("key", 0.9);
    assertEquals("key", test.getKey());
    assertEquals(0.9, test.getValue());
    assertThrows(IllegalArgumentException.class, () -> {
      new Grade(null, 0.9);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Grade("", 0.9);
    });
  }

  /**
   * Tests for the third constructor.
   */
  @Test
  void test3Constructor()
  {
    Double v = new Double(0.9);
    Grade test = new Grade("key", v);
    assertEquals("key", test.getKey());
    assertEquals(0.9, test.getValue());
    assertThrows(IllegalArgumentException.class, () -> {
      new Grade(null, v);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Grade("", v);
    });
  }

  /**
   * Tests for to String.
   */
  @Test
  void testToString()
  {
    Grade valueIf = new Grade("key", null);
    Grade valueElse = new Grade("key", 0.9);
    assertEquals("key:    NA", valueIf.toString());
    assertEquals("key:   0.9", valueElse.toString());
  }

  /**
   * Tests for compareTo.
   */
  @Test
  void testCompare()
  {
    Grade one = new Grade("key", null);
    Grade two = new Grade("key", 0.9);
    Grade three = new Grade("key", 1.7);
    assertEquals(-1, one.compareTo(two));
    assertEquals(0, one.compareTo(one));
    assertEquals(1, two.compareTo(one));
    assertEquals(0, three.compareTo(three));
    assertEquals(1, three.compareTo(two));
    assertEquals(-1, two.compareTo(three));
  }
}
