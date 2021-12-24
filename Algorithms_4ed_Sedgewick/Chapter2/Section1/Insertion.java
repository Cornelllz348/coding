package chapter0201;

import edu.princeton.cs.algs4.StdOut;

public class Insertion {
	
	// insertion sort uses ~n^2/4 compares and ~n^2/4 exchanges to sort a randomly ordered array of length n with distinct keys on avg
	// the worst case is ~n^2/2 compares and ~n^2/2 exchanges and the best case is n-1 compares and 0 exchanges
	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			// insert a[i] among a[i-1], a[i-2], a[i-3], ...
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exchange(a, j, j-1);
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) return false;
		}
		return true;
	}

}
