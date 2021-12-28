package chapter0202;

// bottom-up mergesort uses between ~1/2nlgn and nlgn compares and at most 6nlgn array accesses to sort an array of length n

public class MergeBU {
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		int n = a.length;
		aux = new Comparable[n];
		for (int len = 1; len < n; len *= 2) {
			for (int lo = 0; lo < n - len; lo += len + len) {
				merge(a, lo, lo + len - 1, Math.min(lo + len + len - 1 , n - 1));
			}
		}
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