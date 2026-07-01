/**
 * CS240 PA3 MergeSortsImproved. This Code Compiles in accordance with the JMU honor Code I received
 * no outside help on this assignment.
 * 
 * @author joshua steffen
 * @version 11/3/21
 */
public class MergeSortsImproved {

  /**
   * Merge sort the provided array using an improved merge operation.
   */
  public static <T extends Comparable<T>> void mergeSort1(T[] items) {
    T[] temp = (T[]) new Comparable[items.length + 1 / 2];
    mergeSort(items, temp, 0, items.length - 1);
  }

  private static <T extends Comparable<T>> void mergeSort(T[] items, T[] temp, int left,
      int right) {
    if (left >= right) {
      return; // Region has one record so short circuit
    }

    int mid = (left + right) / 2; // Select midpoint

    mergeSort(items, temp, left, mid); // Mergesort first half
    mergeSort(items, temp, mid + 1, right); // Mergesort second half

    merge(items, temp, left, mid, right);

  }

  private static <T extends Comparable<T>> void merge(T[] items, T[] temp, int left, int mid,
      int right) {
    for (int i = left, j = 0; i <= mid; i++, j++) {
      temp[j] = items[i]; // Copy subarray to temp
    }

    int i1 = 0;
    int i2 = mid + 1;
    for (int curr = left; curr <= right; curr++) {
      if (i1 > mid - left) { // Left subarray exhausted
        break;
      } else if (i2 > right) { // Right subarray exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(items[i2]) <= 0) { // Get smaller value
        items[curr] = temp[i1++];
      } else {
        items[curr] = items[i2++];
      }
    }
  }


  /**
   * Merge sort the provided array by using an improved merge operation and switching to insertion
   * sort for small sub-arrays.
   */
  public static <T extends Comparable<T>> void mergeSort2(T[] items) {
    T[] temp = (T[]) new Comparable[items.length + 1 / 2];
    mergeSort2(items, temp, 0, items.length - 1);
  }

  /**
   * Merge sort the provided sub-array using our improved merge sort. This is the fallback method
   * used by introspective sort.
   */
  public static <T extends Comparable<T>> void mergeSort2(T[] items, int start, int end) {
    T[] temp = (T[]) new Comparable[items.length + 1 / 2];
    mergeSort2(items, temp, start, end);
  }

  private static <T extends Comparable<T>> void mergeSort2(T[] items, T[] temp, int left,
      int right) {
    if (right - left <= 15) { // threshold for swapping to insertion sort
      BasicSorts.insertionSort(items, left, right);
      return; // short circuit the rest of the recursion
    }

    int mid = (left + right) / 2; // Select midpoint
    mergeSort(items, temp, left, mid); // Mergesort first half
    mergeSort(items, temp, mid + 1, right); // Mergesort second half
    merge(items, temp, left, mid, right);

  }

}
