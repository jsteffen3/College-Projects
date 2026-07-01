package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import grading.DropFilter;
import grading.Grade;
import grading.SizeException;

/**
 * CS 345 HW1 DropFilterTest.
 * 
 * @author Joshua Steffen
 * @version 1/23/22
 */
class DropFilterTest
{

  /**
   * Tests drop filter for no drops.
   * 
   * @throws SizeException
   *           wont throw
   */
  @Test
  void testNoDrops() throws SizeException
  {
    DropFilter test = new DropFilter(false, false);
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new Grade("t", 50.0));
    grades.add(new Grade("t", 75.0));
    grades.add(new Grade("t", 100.0));
    ArrayList<Grade> result = (ArrayList<Grade>) test.apply(grades);
    assertEquals(grades.size(), result.size());
  }

  /**
   * Tests drop filter for dropping lowest.
   * 
   * @throws SizeException
   *           wont throw
   */
  @Test
  void testLowDrop() throws SizeException
  {
    DropFilter test = new DropFilter(true, false);
    ArrayList<Grade> grades = new ArrayList<Grade>();
    Grade one = new Grade("t", 50.0);
    Grade two = new Grade("t", 75.0);
    Grade three = new Grade("t", 100.0);
    grades.add(one);
    grades.add(two);
    grades.add(three);
    ArrayList<Grade> result = (ArrayList<Grade>) test.apply(grades);
    assertEquals(grades.size() - 1, result.size());
    assertFalse(result.contains(one));
    assertTrue(result.contains(two));
  }

  /**
   * Tests drop filter for both drops.
   * 
   * @throws SizeException
   *           wont throw
   */
  @Test
  void testBothDrops() throws SizeException
  {
    DropFilter test = new DropFilter(true, true);
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new Grade("t", 50.0));
    grades.add(new Grade("t", 75.0));
    grades.add(new Grade("t", 100.0));
    ArrayList<Grade> result = (ArrayList<Grade>) test.apply(grades);
    assertEquals(grades.size() - 2, result.size());
  }

  /**
   * Tests drop filter for dropping Highest.
   * 
   * @throws SizeException
   *           wont throw
   */
  @Test
  void testHighDrop() throws SizeException
  {
    DropFilter test = new DropFilter(false, true);
    ArrayList<Grade> grades = new ArrayList<Grade>();
    Grade one = new Grade("t", 50.0);
    Grade two = new Grade("t", 75.0);
    Grade three = new Grade("t", 100.0);
    grades.add(one);
    grades.add(two);
    grades.add(three);
    ArrayList<Grade> result = (ArrayList<Grade>) test.apply(grades);
    assertEquals(grades.size() - 1, result.size());
    assertFalse(result.contains(three));
    assertTrue(result.contains(two));
  }

  /**
   * Tests drop filter for errors.
   * 
   * @throws SizeException
   *           wont throw
   */
  @Test
  void testErrors()
  {
    DropFilter test = new DropFilter(true, true);
    ArrayList<Grade> grades1 = null;
    assertThrows(SizeException.class, () -> {
      test.apply(grades1);
    });
    ArrayList<Grade> grades2 = new ArrayList<Grade>();
    assertThrows(SizeException.class, () -> {
      test.apply(grades2);
    });
    ArrayList<Grade> grades3 = new ArrayList<Grade>();
    grades3.add(new Grade("o", 97.0));
    DropFilter test2 = new DropFilter(true, false);
    assertThrows(SizeException.class, () -> {
      test.apply(grades3);
    });
    ArrayList<Grade> grades4 = new ArrayList<Grade>();
    grades4.add(new Grade("o", 97.0));
    DropFilter test3 = new DropFilter(false, true);
    assertThrows(SizeException.class, () -> {
      test3.apply(grades4);
    });
    ArrayList<Grade> grades5 = new ArrayList<Grade>();
    grades5.add(new Grade("o", 97.0));
    grades5.add(new Grade("o", 97.0));
    DropFilter test4 = new DropFilter(true, true);
    assertThrows(SizeException.class, () -> {
      test4.apply(grades5);
    });
  }

  /**
   * Tests drop filter for default.
   * 
   * @throws SizeException
   *           wont throw
   */
  @Test
  void testDeafult() throws SizeException
  {
    DropFilter test = new DropFilter();
    ArrayList<Grade> grades = new ArrayList<Grade>();
    Grade one = new Grade("t", 50.0);
    Grade two = new Grade("t", 75.0);
    Grade three = new Grade("t", 100.0);
    grades.add(one);
    grades.add(two);
    grades.add(three);
    ArrayList<Grade> result = (ArrayList<Grade>) test.apply(grades);
    assertEquals(grades.size() - 2, result.size());
    assertFalse(result.contains(three));
    assertTrue(result.contains(two));
  }
  
  /**
   * Tests drop filter for Missing.
   * 
   * @throws SizeException
   *           wont throw
   */
  @Test
  void testMissing() throws SizeException
  {
    DropFilter test = new DropFilter();
    ArrayList<Grade> grades = new ArrayList<Grade>();
    Grade one = new Grade("t", 50.0);
    Grade two = new Grade("t", 75.0);
    Grade three = new Grade("t", 100.0);
    Grade four = new Grade("t", null);
    grades.add(one);
    grades.add(two);
    grades.add(three);
    grades.add(four);
    ArrayList<Grade> result = (ArrayList<Grade>) test.apply(grades);
    assertEquals(grades.size() - 2, result.size());
    assertFalse(result.contains(three));
    assertTrue(result.contains(two));
    assertFalse(result.contains(four));
  }

}
