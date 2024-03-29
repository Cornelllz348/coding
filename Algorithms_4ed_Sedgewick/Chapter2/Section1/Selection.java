package chapter0201;

import edu.princeton.cs.algs4.StdOut;

public class Selection {
	
	// selection sort uses ~n^2/2 compares and n exchanges to sort an array of length n
	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			// exchange a[i] with smallest entry in a[i], ... , a[n - 1]
			int min = i;
			for (int j = i+1; j < n; j++) {
				if (less(a[j], a[min])) min = j;
			}
			exchange(a, i, min);
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
