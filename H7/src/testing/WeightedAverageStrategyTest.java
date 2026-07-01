package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import grading.Grade;
import grading.LeafGrade;
import grading.WeightedAverageStrategy;
/**
 * CS 345 WeightedAveraeStrategyTest
 * 
 * @author Joshua Steffen
 * @version 3/2/22
 */
class WeightedAverageStrategyTest
{

  @Test
  void testNullWeights() {
    WeightedAverageStrategy weights = new WeightedAverageStrategy(null);
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new LeafGrade("key", 5.0));
    assertEquals(5.0, weights.calculate("key", grades).getValue());
  }
  
  @Test
  void testNormalCase() {
    HashMap w = new HashMap<String, Double>();
    w.put("key", 2.0);
    w.put("test", 1.0);
    WeightedAverageStrategy weights = new WeightedAverageStrategy(w, false);
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new LeafGrade("key", 5.0));
    grades.add(new LeafGrade("test", 1.0));
    grades.add(new LeafGrade("test", 1.0));
    assertEquals(4.0, weights.calculate("result", grades).getValue());
  }
  
  @Test
  void testNoGrades() {
    HashMap w = new HashMap<String, Double>();
    w.put("key", 2.0);
    w.put("test", 1.0);
    WeightedAverageStrategy weights = new WeightedAverageStrategy(w, false);
    // tests if grades is a list of length 0
    ArrayList<Grade> grades = new ArrayList<Grade>();
    assertEquals(0.0, weights.calculate("result", grades).getValue());
    // tests if grades is null
    grades = null;
    assertEquals(0.0, weights.calculate("result", grades).getValue());
  }
  
  @Test
  void testIgnoreMissingGrades() {
    HashMap w = new HashMap<String, Double>();
    w.put("key", 1.0);
    w.put("test", 1.0);
    WeightedAverageStrategy weights = new WeightedAverageStrategy(w, true);
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new LeafGrade("key", 5.0));
    grades.add(new LeafGrade("test", null));
    assertEquals(5.0, weights.calculate("result", grades).getValue());
  }
  
  @Test
  void testNotIgnoreMissingGrades() {
    HashMap w = new HashMap<String, Double>();
    w.put("key", 1.0);
    w.put("test", 1.0);
    WeightedAverageStrategy weights = new WeightedAverageStrategy(w, false);
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new LeafGrade("key", 5.0));
    grades.add(new LeafGrade("test", null));
    assertEquals(2.5, weights.calculate("result", grades).getValue());
  }
  
  @Test
  void testDefaultConstructor() {
    WeightedAverageStrategy weights = new WeightedAverageStrategy();
    ArrayList<Grade> grades = new ArrayList<Grade>();
    grades.add(new LeafGrade("key", 5.0));
    assertEquals(5.0, weights.calculate("key", grades).getValue());
    
  }

}
