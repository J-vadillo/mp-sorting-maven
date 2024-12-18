package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Arrays;

/**
 * Something that sorts using merge sort.
 *
 * @param <T>
 *            The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 * @author jana vadillo
 */

public class MergeSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *                   The order in which elements in the array should be ordered
   *                   after sorting.
   */
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
   *
   * @param values
   *               an array to sort.
   *
   * @post
   *       The array has been sorted according to some order (often
   *       one given to the constructor).
   * @post
   *       For all i, 0 &lt; i &lt; values.length,
   *       order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    if (values.length <= 1) {
      return;
    } // base case
    int mid = values.length / 2;
    T[] arrayOne = Arrays.copyOfRange(values, 0, mid);
    T[] arrayTwo = Arrays.copyOfRange(values, mid, values.length);

    this.sort(arrayOne);
    this.sort(arrayTwo);

    int oneSorted = 0;
    int twoSorted = 0;

    for (int i = 0; i < values.length; i++) {
      if (oneSorted >= arrayOne.length) {
        values[i] = arrayTwo[twoSorted];
        twoSorted++;
        continue;
      } else if (twoSorted >= arrayTwo.length) {
        values[i] = arrayOne[oneSorted];
        oneSorted++;
        continue;
      } // checks for if we ran out of elements on either array

      if (this.order.compare(arrayOne[oneSorted], arrayTwo[twoSorted]) <= 0) {
        values[i] = arrayOne[oneSorted];
        oneSorted++;
      } else {
        values[i] = arrayTwo[twoSorted];
        twoSorted++;
      } // if else handling which array to copy from
    } // for loop filling out the needed array.
    return;
  } // sort(T[])

} // class MergeSorter
