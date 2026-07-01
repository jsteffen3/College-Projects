package app;
import grading.*;
import grading.io.*;
import java.io.*;
import java.util.*;


/**
 * An application for calculating the numeric grade for
 * a course from the grades on individual assignments.
 * 
 * This version reads the course structure (and optionally the grades)
 * from a file. It assumes:
 * 
 *   The grade in each category is the total of the individual assessments.
 *   
 *   The course grade is the weighted total of the category grades.
 * 
 * @version 2.0
 * @author  Sagacious Media
 *
 */
public class Gradient
{
  /**
   * The entry point for the application.
   * 
   * @param args args[0] contains the path (relative or absolute) to the .grd file
   */
  public static void main(String[] args)
  {
    // Early exit
    if ((args == null) || (args.length < 1))
    {
      System.err.println("You must enter a file name.");
      System.exit(1);
    }

    try
    {
      BufferedReader in = new BufferedReader(new FileReader(args[0]));
      String         line = in.readLine();
      int            categories = Integer.parseInt(line);
      Course         course = CourseReader.readCourse(in, categories);
      in.close();

      ArrayList<Grade> grades = new ArrayList<Grade>();
      for (Category c: course.getCategories())
      {
        GradingStrategy categoryStrategy = c.getStrategy();
        Filter          filter           = c.getFilter();
        Grade grade = categoryStrategy.calculate(c.getKey(), filter.apply(c.getGrades()));
        grades.add(grade);
      }

      GradingStrategy courseStrategy = course.getStrategy();
      Grade courseGrade = courseStrategy.calculate("Course Grade", grades);
      System.out.println(courseGrade.toString());
    }
    catch (IOException ioe)
    {
      System.out.println("Unable to open file.");
      System.exit(1);
    }
    catch (SizeException se)
    {
      // Shouldn't happen
      System.out.println("Size Problem.");
      System.exit(2);
    }
  }
}