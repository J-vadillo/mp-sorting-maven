fixed quicksort as I realized on recursive calls, I kept setting the base where the indexes are made from (ie where whree smaller than, pivot, and greater than should be) always equal to zero rather than the section of the plot we are sorting thus making the algorithin break on later runs.