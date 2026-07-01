package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import grading.*;

import org.junit.jupiter.api.Test;

/**
 * CS 345 HW5 CompositeGradeTest.
 * 
 * @author Joshua Steffen
 * @version 2/17/22
 */
class CompositeGradeTest
{

  @Test
  void testErrors()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      new CompositeGrade(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new CompositeGrade("");
    });
  }

  @Test
  void testNormal()
  {
    WeightedTotalStrategy s = new WeightedTotalStrategy();
    DropFilter f = new DropFilter();
    CompositeGrade test = new CompositeGrade("test");
    test.setFilter(f);
    test.setStrategy(s);
    assertEquals(f, test.getFilter());
    assertEquals(s, test.getStrategy());
    LeafGrade add = new LeafGrade("key");
    test.add(add);
    List<Grade> result = test.getComponents();
    assertEquals(add, result.get(0));
    assertEquals(0.0, test.getValue());
    f = new DropFilter(true, true);
    test.setFilter(f);
    assertEquals(0.0, test.getValue());
  }
}
