package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Random;

/**
 * Something that sorts using Quicksort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Jana Vadillo & sam rebelsky
 */

public class VadilloJanaSort<T> implements Sorter<T> {
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
   *   The order in which elements in the array should be ordered
   *   after sorting.
   */
  public VadilloJanaSort(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * a handy dandy random number generator :)
   */
  static Random rand = new Random();

  /**
   * Sort an array in place using Quicksort.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 &lt; i &lt; values.length,
   *     order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    boolean sorted = true;
    for (int i = 1; i < values.length; i++){
        if (this.order.compare(values[i], values[i-1]) == -1){
            sorted = false;
            break;
        }//end if unsorted
    }//check all values for an unsorted one.
    if (!sorted){
        sortRecursive(values, 0, values.length);
    } // sort(T[])

    }
   
/**
 * the recursive core of the sort method described above.
 * @param values the values to be sorted
 * @param lowerBound the lowerBound of sorted values
 * @param upperBound the upper bound of sorted values
 */
  private void sortRecursive(T[] values, int lowerBound, int upperBound){
    int length =  upperBound - lowerBound;
    if (length <= 1){
      return;
    }//base case

    if (length <= 8){
        for (int i = lowerBound;  i < upperBound; i++){
            T val = values[i];
            int checking = i-1;
            while ((checking >= 0) && (this.order.compare(values[checking], val) >= 1)){
              SortingUtils.swapValues(values, checking + 1, checking);
              checking = checking -1;
            }// itterate through shifting back and opening up space
          }//itterate through the list placing values in their correct spot
      }//insertionSort for small arrays

    int pivotSort = 0;// designates the start of the area with the sorted pivot numbers
    int largeSort = 0;//designaes the start of the area with the sorted large numbers
    int unsorted = 0;//designates the start of the area with the unsorted small numbers.

    int pivotIndex = lowerBound + rand.nextInt(length);
    T pivot = values[pivotIndex];

    SortingUtils.swapValues(values, largeSort, pivotIndex);
    largeSort++;
    //place the selected pivot into our location

    //the ++ for unsorted is moved into the function below
    for (unsorted = 0; unsorted < upperBound; unsorted++){
      if (this.order.compare(values[unsorted], pivot) > 0){
        continue;
      }else if (this.order.compare(values[unsorted], pivot) == 0){
        SortingUtils.swapValues(values, largeSort, unsorted);
        largeSort ++;
      }else if(this.order.compare(values[unsorted], pivot) < 0){
        SortingUtils.swapValues(values, largeSort, unsorted);
        SortingUtils.swapValues(values, largeSort, pivotSort);
        largeSort ++;
        pivotSort ++;
      }//decides where to place value
    }// itterates through list dividing hte respective values.

    sortRecursive(values, lowerBound, pivotSort);
    sortRecursive(values, largeSort, unsorted);
    return;
  }
} // class Quicksorter
