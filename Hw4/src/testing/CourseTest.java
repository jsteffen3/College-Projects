package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import grading.DropFilter;
import grading.Grade;
import grading.TotalStrategy;
import grading.io.Category;
import grading.io.Course;

/**
 * CS 345 HW4 CourseTest.
 * 
 * @author Joshua Steffen
 * @version 2/10/22
 */
class CourseTest
{

  @Test
  void testCourse()
  {
    ArrayList<Category> li = new ArrayList<Category>();
    String key = "test";
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new Grade(key));
    DropFilter filter = new DropFilter();
    TotalStrategy strat = new TotalStrategy();
    Category add = new Category(key, grades, filter, strat);
    li.add(add);
    Course test = new Course(li, strat);
    assertEquals(li, test.getCategories());
    assertEquals(strat, test.getStrategy());
  }

}
