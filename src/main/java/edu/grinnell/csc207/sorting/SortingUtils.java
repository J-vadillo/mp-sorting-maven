package edu.grinnell.csc207.sorting;
/**
 * A series of usefull functions while sorting.
 * @author Jana Vadillo
 */
public class SortingUtils {
  /**
   * Used for swapping two values in an array.
   * @param values the array of values in which swapping is needed
   * @param a      index of first value
   * @param b      index of second value.
   * @param <T> the type of object in the array.
   * @throws IndexOutOfBoundsException
   */
  public static <T> void swapValues(T[] values, int a, int b) throws IndexOutOfBoundsException {
    if ((a < 0) || (b < 0) || (a >= values.length) || (b >= values.length)) {
      throw new IndexOutOfBoundsException();
    } //check if the given values to swap are outside of the array range.
    T holder = values[a];
    values[a] = values[b];
    values[b] = holder;
    return;
  } //swapvalues(T[], int int)
} //sortingUtils
