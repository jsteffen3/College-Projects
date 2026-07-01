package testing;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import grading.Grade;
import grading.SizeException;
import grading.TotalStrategy;

/**
 * CS 345 HW1 TotalStrategy.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
class TotalStrategyTest
{

  /**
   * Tests both cases for a size exception.
   */
  @Test
  void testSizeException()
  {
    TotalStrategy test = new TotalStrategy();
    ArrayList<Grade> nullerror = null;
    assertThrows(SizeException.class, () -> {
      test.calculate("f", nullerror);
    });
    ArrayList emptyerror = new ArrayList<Grade>();
    assertThrows(SizeException.class, () -> {
      test.calculate("f", emptyerror);
    });
  }

  /**
   * Test to get correct total.
   * @throws SizeException will not throw
   * @throws IllegalArgumentException will not throw
   */
  void testTotal() throws IllegalArgumentException, SizeException
  {
    TotalStrategy test = new TotalStrategy();
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new Grade("o", 50.0));
    grades.add(new Grade("hw", null));
    assertEquals(0, new Grade("hw", 0.0).compareTo(test.calculate("hw", grades)));
    grades.add(new Grade("hw", 75.0));
    assertEquals(0, new Grade("hw", 75.0).compareTo(test.calculate("hw", grades)));
  }

}
