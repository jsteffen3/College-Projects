package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import grading.Missing;

/**
 * CS 345 HW1 MissingTest.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
class MissingTest
{

  /**
   * Tests for default doubleValue.
   */
  @Test
  void testDeafult()
  {
    assertEquals(0, Missing.doubleValue(null));
    assertEquals(1.1, Missing.doubleValue(1.1));
  }

  /**
   * Tests for doubleValue with missingValue.
   */
  @Test
  void testWithMissingV()
  {
    assertEquals(1.1, Missing.doubleValue(null, 1.1));
    assertEquals(1.1, Missing.doubleValue(1.1, 0.0));
  }

}
