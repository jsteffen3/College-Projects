package testing;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import grading.Grade;
import grading.SizeException;
import grading.WeightedTotalStrategy;

class WeightedTotalStrategyTest
{

  /**
   * Tests both cases for a size exception.
   */
  @Test
  void testSizeException()
  {
    WeightedTotalStrategy test = new WeightedTotalStrategy();
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
   * Tests for correct output with a default object.
   * 
   * @throws SizeException
   *           will not throw
   * @throws IllegalArgumentException
   *           will not throw
   */
  @Test
  void testDefault() throws IllegalArgumentException, SizeException
  {
    WeightedTotalStrategy test = new WeightedTotalStrategy();
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new Grade("hw", 100.0));
    grades.add(new Grade("o", 50.0));
    grades.add(new Grade("hw", null));
    assertEquals(-1, new Grade("hw", 100.0).compareTo(test.calculate("hw", grades)));
  }

  /**
   * Tests for correct output with a default object.
   * 
   * @throws SizeException
   *           will not throw
   * @throws IllegalArgumentException
   *           will not throw
   */
  @Test
  void testWithParam() throws IllegalArgumentException, SizeException
  {
    HashMap<String, Double> map = new HashMap<String, Double>();
    map.put("hw", 0.5);
    map.put("o", null);
    WeightedTotalStrategy test = new WeightedTotalStrategy(map);
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new Grade("hw", 100.0));
    grades.add(new Grade("o", 50.0));
    grades.add(new Grade("hw", null));
    assertEquals(-1, new Grade("hw", 50.0).compareTo(test.calculate("hw", grades)));
    assertEquals(-1, new Grade("o", 50.0).compareTo(test.calculate("o", grades)));
  }

}
