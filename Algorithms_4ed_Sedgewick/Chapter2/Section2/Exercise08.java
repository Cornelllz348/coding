package chapter0202;

// Exercise 8:
// Suppose top-down mergesort is modified to skip the call on merge() whenever a[mid] <= a[mid+1].
// Prove that the number of compares used to mergesort a SORTED array is linear.

// Because the array is already sorted, merge() will always be skipped.
// Therefore there is 1 compare per sub-array and the number of compares is therefor linear.
// e.g.
// 0 1 2 3 4 5 6 7
// A B C D E F G H
// compares: A B, C D, E F, G H, B C, F G, D E

public class Exercise08 {
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);						// sort left half
		sort(a, mid + 1, hi);					// sort right half
		if (less(a[mid+1], a[mid])) {
			merge(a, lo, mid, hi);				// merge results
		}
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];						// copy a[lo..hi] to aux[lo..hi]
		}
		for (int k = lo; k <= hi; k++) {		// merge back to a[lo..hi]
			if (i > mid) {
				a[k] = aux[j++];				// left is exhausted -> take from the right
			} else if (j > hi) {
				a[k] = aux[i++];				// right is exhausted -> take from the left
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];				// current key on right less than current key on left -> take from right
			} else {
				a[k] = aux[i++];				// current key on right >= current key on left -> take from left
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

}
