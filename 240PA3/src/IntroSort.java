/**
 * CS240 PA3 IntroSort.
 * 
 * @author joshua steffen
 * @version 11/3/21
 */
public class IntroSort {

  /**
   * Sort the provided items using the introsort algorithm.
   */
  public static <T extends Comparable<T>> void introSort(T[] items) {
    if (items.length > 1) {     
      introSort(items, 0, items.length - 1, (int) (2 * Math.floor((Math.log(items.length) / Math.log(2)))));
    }
  }

  /**
   * IntroSort helper method.
   * 
   * @param <T> What we are sorting.
   * @param items the items to sort.
   * @param maxDepth termination condition.
   */
  public static <T extends Comparable<T>> void introSort(T[] items, int left, int right,
      int maxDepth) {
    if (maxDepth == 0) {
      MergeSortsImproved.mergeSort2(items);
    } else {
      int pivot = findPivot(items, left, right);
      int curr = partition(items, left, right, findPivot(items, left, right));
      if ((curr - left) > 1) {
        introSort(items, left, curr - 1, --maxDepth); // Sort left partition
      }
      if ((right - curr) > 1) {
        introSort(items, curr + 1, right, --maxDepth); // Sort right partition
      }
    }
  }
  
  /**
   * Helper method to select the pivot point.
   */
  protected static <T extends Comparable<T>> int findPivot(T[] items, int left, int right) {
    return (left + right) / 2;
  }

  /**
   * Partition the indicated region of the array. The pivot item will be placed in its final sorted
   * position, with all smaller elements moved to the left and all larger elements moved to the
   * right.
   * 
   * @return The final index of the pivot item.
   */
  protected static <T extends Comparable<T>> int partition(T[] items, int left, int right,
      int pivotindex) {

    T pivot = items[pivotindex];
    BasicSorts.swap(items, pivotindex, right); // Stick the pivot at end
    pivotindex = right; // remember where it is.
    right--;


    while (left <= right) { // Move bounds inward until they meet
      while (items[left].compareTo(pivot) < 0) {
        left++;
      }
      while ((right >= left) && (items[right].compareTo(pivot) >= 0)) {
        right--;
      }
      if (right > left) {
        BasicSorts.swap(items, left, right); // Swap out-of-place values
      }
    }
    BasicSorts.swap(items, left, pivotindex); // Put pivot in place

    return left; // Return first position in right partition
  }


}
