package chapter0202;

// Exercise 4:
// The abstract in-place merge produce proper result iff the two input arrays are in sorted order.

// Exercise 5:
// Give the sequence of subarray lengths in the merges performed by both the top-down and the bottom-up mergesort algorithms,
// for n = 39
// top-down:
// 3,2,5,3,2,5,10,3,2,5,10,3,2,5,10,20,3,2,5,3,2,5,10,3,2,5,2,2,4,9,19,39
// bottom-up:
// 2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,4,4,4,4,4,4,4,4,3,8,8,8,8,7,16,16,7,32,7,39

public class Exercise0405 {
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);				// sort left half
		sort(a, mid + 1, hi);			// sort right half
		merge(a, lo, mid, hi);			// merge results
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {	
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

}
