# mp-sorting-maven

An exploration of sorting in Java.

Authors

*Jana Vadillo
* Samuel A. Rebelsky (starter code)

Acknowledgements

* _Forthcoming_.

This code may be found at <https://github.com/\J-vadillo/mp-sorting-maven>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-sorting-maven>.


additionally, the following readings where used as a reference on copying a section of an array
https://www.tutorialspoint.com/how-to-copy-a-specific-section-of-an-array-in-java

Description of custom sorting algorithm
---------------------------------------
My custom sorting algorithm is pretty basic, mainly taking advantage of the strenghts of different sorting algorithms at different rates. In particular,it first preforms a quick check on all of the elements to see if they are already in order, to avoid needlesly itterating through the list in this case, and then largely works like my algorithm for quicksort, which, as largely one of the best choices for large data sets does the bulk of the brunt work.  However, whenever an array gets small enough for quick sort to no longer be as effective (I decided under 8,) a swap is made to a method more similar to insertion sort which tends to work better at smaller scales.
Notes on using Copilot (or other AI)
------------------------------------

_This section is optional_
