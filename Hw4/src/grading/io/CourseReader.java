package grading.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import grading.*;

/**
 * CS 345 HW4 CourseReader.
 * 
 * @author Joshua Steffen
 * @version 2/10/22
 */
public class CourseReader
{

  /**
   * Reads the next category.
   * 
   * @param in
   *          the reader for input
   * @param size
   *          the size
   * @param key
   *          the key
   * @param filter
   *          the filter
   * @return information about the next category
   */
  public static Category readCategory(final BufferedReader in, final int size, final String key,
      final Filter filter) throws IOException, IllegalArgumentException
  {
    int numCategoies = Integer.parseInt(in.readLine());
    String tabchar ="\t";
    for (int i = 0; i < numCategoies; i++)
    {
      String line = in.readLine();
      String[] split = line.split(tabchar);
      int numGrades = Integer.parseInt(split[1]);
      if (numGrades == size)
      {
        String g = in.readLine();
        ArrayList<Grade> grades = new ArrayList<Grade>();
        for (int l = 0; l < numGrades; l++)
        {
          String grade = in.readLine();
          String[] gradespl = grade.split(tabchar);
          Grade parsed = new Grade(gradespl[0], Double.parseDouble(gradespl[1]));
          grades.add(parsed);
        }
        break;
      }
      else
      {
        for (int l = 0; l < numGrades; l++)
        {
          in.readLine();
        }
      }
    }

    return null;
  }

  /**
   * Return a Course object that contains size different Category objects.
   * 
   * @param in
   *          takes input
   * @param size
   *          the size
   * @return a Course object that contains size different Category objects
   */
  public static Course readCourse(final BufferedReader in, final int size) throws IOException
  {
    return null;
  }
}
