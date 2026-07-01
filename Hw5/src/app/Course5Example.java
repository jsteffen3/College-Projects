package app;

import java.util.*;
import grading.*;

/**
 * An example of grades in a course with the structure of Course 5.
 * The purposes of this example is to demonstrate that the new/improved
 * design can support complicated class structures.
 * 
 * @author Sagacious Media
 */
public class Course5Example
{
  /**
   * The entry point of the example.
   * 
   * @param args  The command-line arguments are not used.
   */
  public static void main(String[] args)
  {
    CompositeGrade           course, exams, homeworks, midterms;
    LeafGrade                participation;
    DropFilter               homeworkFilter;
    HashMap<String,Double>   examWeights, courseWeights, midtermWeights;
    WeightedTotalStrategy    examStrategy, courseStrategy;
    
      // Participation
      participation = new LeafGrade("Participation", 90.0);
      System.out.println(participation.toString());
    
      // Midterm Exams
      midterms = new CompositeGrade("Midterms");
      midtermWeights = new HashMap<String, Double>();
      midtermWeights.put("Exam 1",    0.50);
      midtermWeights.put("Exam 2",    0.50);
      midterms.setStrategy(new WeightedTotalStrategy(midtermWeights));
      midterms.add(new LeafGrade("Exam 1", 65.0));
      midterms.add(new LeafGrade("Exam 2", 85.0));
      System.out.println(midterms.toString());
      
      // Exams (the midterms and the final)
      examWeights = new HashMap<String, Double>();
      examWeights.put("Midterms",      0.30);
      examWeights.put("Final Exam",    0.70);
      examStrategy = new WeightedTotalStrategy(examWeights);
      exams = new CompositeGrade("Exams");
      exams.setStrategy(examStrategy);
      exams.add(midterms);
      exams.add(new LeafGrade("Final Exam", 70.0));
      System.out.println(exams.toString());
      
      // Homework
      homeworkFilter = new DropFilter(true, false);
      homeworks = new CompositeGrade("Homework");
      homeworks.setFilter(homeworkFilter);
      homeworks.setStrategy(new TotalStrategy());
      homeworks.add(new LeafGrade("H1", 15.0));
      homeworks.add(new LeafGrade("H2",  2.0));
      homeworks.add(new LeafGrade("H3",  6.0));
      homeworks.add(new LeafGrade("H4", 19.0));
      homeworks.add(new LeafGrade("H5", 17.0));
      homeworks.add(new LeafGrade("H6", 20.0));
      System.out.println(homeworks.toString());
      
      // All grades
      course = new CompositeGrade("Course Grade");
      courseWeights = new HashMap<String, Double>();
      courseWeights.put("Participation", 0.10);
      courseWeights.put("Homework",      0.30);
      courseWeights.put("Exams",         0.60);
      courseStrategy = new WeightedTotalStrategy(courseWeights);
      course.setStrategy(courseStrategy);
      course.add(participation);
      course.add(exams);
      course.add(homeworks);
      System.out.println(course.toString());
  }
}