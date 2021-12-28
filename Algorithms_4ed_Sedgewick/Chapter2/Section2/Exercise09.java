package chapter0202;

// Exercise 9:
// Give an implementation of Merge that does not use a static array.
// Do not make aux[] local to merge().
// Hint: pass the aux array as an argument to the recursive sort().

public class Exercise09 {
	
	// private static Comparable[] aux; -- not used
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, 0, a.length - 1, aux);
	}
	
	public static void sort(Comparable[] a, int lo, int hi, Comparable[] aux) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid, aux);						// sort left half
		sort(a, mid + 1, hi, aux);					// sort right half
		merge(a, lo, mid, hi, aux);						// merge results
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] aux) {
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
