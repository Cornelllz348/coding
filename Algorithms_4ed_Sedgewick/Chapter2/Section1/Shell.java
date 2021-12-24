package chapter0201;

import edu.princeton.cs.algs4.StdOut;

public class Shell {
	
	public static void sort(Comparable[] a) {
		int n = a.length;
		int h = 1;
		while (h < n/3) h = 3*h + 1; // 1, 4, 13, 40, 121, ...
		while (h >= 1) {
			// h-sort the array
			for (int i = h; i < n; i++) {
				// insert a[i] among a[i-h], a[i-2*h], a[i-3*h], ...
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
					exchange(a, j, j-h);
				}
			}
			h = h/3;
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
