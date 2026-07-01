package grading.io;

import java.io.*;
import java.util.*;
import grading.*;

/**
 * A utility class for reading Course objects and Category objects.
 * 
 * @author  Prof. David Bernstein, James Madison University
 * @version 2.0
 */
public class CourseReader
{
  private static final String TAB = "\t";
  
  /**
   * Read a CompositeGrade that contains only LeafGrade objects and an associated TotalStrategy.
   * 
   * @param in     The BufferedReader to read from
   * @param size   The number of records
   * @param key    The key for the category
   * @param filter The Filter for the category
   * @return       The CompositeGrade
   * @throws IllegalArgumentException  If the key is invalid
   * @throws IOException If the category can't be read
   */
  public static CompositeGrade readCategory(final BufferedReader in, 
      final int size, final String key, final Filter filter) throws IOException
  {
    CompositeGrade   result = new CompositeGrade(key);
    Double           value;
    String           line;
    String[]         fields;

    result.setFilter(filter);
    for (int i=0; i<size; i++)
    {
      line = in.readLine();
      fields = line.split(TAB);
      if (fields.length >= 2) value = Double.parseDouble(fields[1]);
      else                    value = null;
      result.add(new LeafGrade(fields[0], value));
    }
    GradingStrategy strategy = new TotalStrategy();
    result.setStrategy(strategy);
    
    return result;
  }


  /**
   * Read a CompositeGrade consisting of categories and a WeightedTotalStrategy.
   * 
   * @param in   The BufferedReader to read from
   * @param size The number of records
   * @return     The CompositeGrade
   * @throws IOException If the course can't be read
   */
  public static CompositeGrade readCourse(final BufferedReader in, final int size) 
      throws IOException
  {
    CompositeGrade      result = new CompositeGrade("Course");
    Map<String,Double>  weights = new HashMap<String,Double>();
    String              line;
    String[]            fields;

    for (int i=0; i<size; i++)
    {
      line = in.readLine();
      fields  = line.split(TAB);
      String category  = fields[0];
      int     n        = Integer.parseInt(fields[1]);
      double  weight   = Double.parseDouble(fields[2]);
      boolean dropLow  = Boolean.parseBoolean(fields[3]);
      boolean dropHigh = Boolean.parseBoolean(fields[4]);

      Filter  filter   = new DropFilter(dropLow, dropHigh);
      weights.put(category, weight);

      result.add(readCategory(in, n, category, filter));
    }

    GradingStrategy strategy = new WeightedTotalStrategy(weights);
    result.setStrategy(strategy);
    
    return result;
  }
}
