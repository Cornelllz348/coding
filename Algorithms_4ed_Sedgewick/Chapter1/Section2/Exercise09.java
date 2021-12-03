package chapter0102;

import edu.princeton.cs.algs4.*;

// instrument binary search to use a Counter to count the total number of keys examined during all searches
// and then print the total after all searches are complete

public class Exercise09

{	
	public static int indexOf(int[] a, int key, Counter count) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				StdOut.println(count);
				return mid;
			}
			count.increment();
		}
		StdOut.println(count);
		return -1;
	}
	public static void main(String[] args) {
		Counter count = new Counter("total number of keys examined");
		int[] a = new int[] {2,5,7,10};
		int key = 9;
		indexOf(a, key, count);
	}
}