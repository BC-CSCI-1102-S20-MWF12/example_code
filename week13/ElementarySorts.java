import java.util.*;

public class ElementarySorts {

  // is the array already sorted?
  static boolean isSorted(int[] q) {

    // look at each element
    for (int i=0; i<q.length-1; i++) {

      // if it's greater than the next element, return false
      if (q[i] > q[i+1]) {
        return false;
      }
    }
    // if you get to the end, it must be sorted, so return true.
    return true;
  }


  // bubble sort: let the biggest elements bubble up to the top
  // version where you check to see if it's sorted at each pass
  static int[] bubble_checksort(int[] q) {

    // for fun, keep track of comparisons and swaps
    int totalswap = 0;
    int totalcomp = 0;

    totalcomp+= q.length-1; // number of comps for initial isSorted()

    // while the array is not sorted...
    while (!isSorted(q)) {
      // for each element
      for (int i=0; i < q.length-1; i++) {
        // if that element is bigger than the next elementm, swap
        totalcomp++;
        if (q[i] > q[i+1]) {
          totalswap++;
          int temp = q[i];
          q[i] = q[i+1];
          q[i+1] = temp;
        }
        totalcomp+= q.length-1;
      }
      //printarr(q);
    }
    System.out.println("array length: " + q.length);
    System.out.println("comparisons (including the ones made in isSorted): " + totalcomp);
    System.out.println("swaps: " + totalswap);
    return q;
  }

  // bubble sort variation: let the biggest elements bubble up to the top
  // version where you keep track of swaps and stop when you do 0 swaps
  static int[] bubble_swap(int[] q) {

    int totalswap = 0;
    int totalcomp = 0;

    int swaps = -1;

    // while the number of swaps is not 0
    while (swaps != 0) {
      swaps = 0;

      // for each element
      for (int i=0; i < q.length-1; i++) {

        // if that element is bigger than the next element, swap
        if (q[i] > q[i+1]) {
          int temp = q[i];
          q[i] = q[i+1];
          q[i+1] = temp;
          totalswap++;
          swaps++;
        }
        totalcomp++;
      }
      //printarr(q);
    }
    System.out.println("array length: " + q.length);
    System.out.println("comparisons: " + totalcomp);
    System.out.println("swaps: " + totalswap);
    return q;
  }

  // bubble sort variation: let the biggest elements bubble up to the top
  // version where actually have a nested for loop
  static int[] bubble_nestedfor(int[] q) {

    int totalswap = 0;
    int totalcomp = 0;

    // run the sort q.length times
    for (int i=q.length-1; i>=0; i--) {

      for (int j=0; j<i; j++) {

        // if that element is bigger than the next element, swap
        if (q[j] > q[j+1]) {
          int temp = q[j];
          q[j] = q[j+1];
          q[j+1] = temp;
          totalswap++;
        }
        totalcomp++;
      }
      //printarr(q);
    }
    System.out.println("array length: " + q.length);
    System.out.println("comparisons: " + totalcomp);
    System.out.println("swaps: " + totalswap);
    return q;
  }


  // selection sort: find the smallest, put it in position 0.
  // find the next smallest, put it in position 1. And so on.
  static int[] selection(int[] q) {
    int totalswap = 0;
    int totalcomp = 0;

    // for each element...
    for (int i=0; i<q.length-1;i++) {

      // say for now it's the minimum element (min)
      // save it out and save out its index (minindex)
      int min = q[i];
      int minindex = i;

      // for each subsequent element...
        for (int j = i+1; j < q.length; j++) {

        // if it's smaller than your current min, then set it to be
        // the min and set its index to be the minindex.
        if (q[j] < min) {
          min = q[j];
          minindex = j;
        }
        totalcomp++;
      }

      // swap whatever is in current position i with the element at minindex
      totalswap++;
      q[minindex] = q[i];
      q[i] = min;

      //printarr(q);

    }
    System.out.println("array length: " + q.length);
    System.out.println("comparisons: " + totalcomp);
    System.out.println("swaps: " + totalswap);
    return q;
  }

  // insertion sort:
  static int[] insertion(int[] q) {

    int totalswap = 0;
    int totalcomp = 0;

    // for each element starting at index 1
    for (int i=1; i<q.length; i++) {

      // save out that element (i) as takeout
      // save out that element (q[i]) as idx
      int takeout = q[i];
      int idx = i;

      // while that idx is > 0
      // AND while takeout is less than the element at idx-1
      while (idx > 0 && takeout < q[idx-1]) {
        totalcomp++;

        // set q[idx] to q[idx-1]
        q[idx] = q[idx-1];
        totalswap++;

        // decrement idx
        idx--;
      }
      // finally set the value at idx to takeout
      q[idx] = takeout;
      totalswap++;

    }
    System.out.println("array length: " + q.length);
    System.out.println("comparisons: " + totalcomp);
    System.out.println("swaps: " + totalswap);
    return q;

  }


  static void printarr(int[] q) {
    for (int i=0; i<q.length; i++) {
      System.out.print(q[i] + " ");
    }
    System.out.println();
  }


  public static void main (String[] args) {
    int[] myarray = {12, 4, 19, 2, 7, 11, 3, 10, 5, 1};
    System.out.println("Unsorted Array");
    printarr(myarray);
    System.out.println("\nBubble Sort Check Sorted");
    printarr(bubble_checksort(Arrays.copyOf(myarray, myarray.length)));
    System.out.println("\nBubble Sort with Swap Counting");
    printarr(bubble_swap(Arrays.copyOf(myarray, myarray.length)));
    System.out.println("\nBubble Sort with Nested For Loop");
    printarr(bubble_nestedfor(Arrays.copyOf(myarray, myarray.length)));
    System.out.println("\nSelection Sort");
    printarr(selection(Arrays.copyOf(myarray, myarray.length)));
    System.out.println("\nInsertion Sort");
    printarr(insertion(Arrays.copyOf(myarray, myarray.length)));

    int[] myarray2 = {1, 2, 3, 4, 5, 7, 10, 11, 12, 19};
    System.out.println("\n\nAlready Sorted Array");
    printarr(myarray2);
    System.out.println("\nBubble Sort Check Sorted");
    printarr(bubble_checksort(Arrays.copyOf(myarray2, myarray2.length)));
    System.out.println("\nBubble Sort with Swap Counting");
    printarr(bubble_swap(Arrays.copyOf(myarray2, myarray2.length)));
    System.out.println("\nBubble Sort with Nested For Loop");
    printarr(bubble_nestedfor(Arrays.copyOf(myarray2, myarray2.length)));
    System.out.println("\nSelection Sort");
    printarr(selection(Arrays.copyOf(myarray2, myarray2.length)));
    System.out.println("\nInsertion Sort");
    printarr(insertion(Arrays.copyOf(myarray2, myarray2.length)));

  }

}
