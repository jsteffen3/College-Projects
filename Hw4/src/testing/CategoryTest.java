package testing;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import grading.*;
import grading.io.Category;

/**
 * CS 345 HW4 CategoryTest.
 * 
 * @author Joshua Steffen
 * @version 2/10/22
 */
class CategoryTest
{

  @Test
  void testCategoryErrors()
  {
    String nullkey = null;
    String emptykey = "";
    String normalkey = "test";
    assertThrows(IllegalArgumentException.class, () -> {
      new Category(nullkey, null, null, null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Category(emptykey, null, null, null);
    });
  }

  @Test
  void testCorrectInputs()
  {
    String key = "test";
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new Grade(key));
    DropFilter filter = new DropFilter();
    TotalStrategy strat = new TotalStrategy();
    Category test = new Category(key, grades, filter, strat);
    assertEquals(key, test.getKey());
    assertEquals(grades, test.getGrades());
    assertEquals(filter, test.getFilter());
    assertEquals(strat, test.getStrategy());
  }

}
