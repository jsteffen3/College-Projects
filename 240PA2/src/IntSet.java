/**
 * CS240 PA2 IntSet. This Code Compiles in accordance with the JMU honor Code I received no outside
 * help on this assignment.
 * 
 * @author Joshua Steffen
 * @version 9/24/21
 */
public interface IntSet extends Iterable<Integer> {

  boolean isEmpty(); // returns true if the set is empty.

  int size(); // returns the size of the interval.

  int getIntervalCount(); // returns the number of intervals in the set.

  Interval getInterval(int i); // returns the ith interval in the set.

  boolean contains(int test); // returns true if the int is in the set.

  boolean add(int add); // returns true if the int was added.

  boolean remove(int remove); // returns true if the int was removed.

  String toString(); // returns the set as a String.

  boolean equals(Object other); // returns true if the Object is an Interval that is equal
}
