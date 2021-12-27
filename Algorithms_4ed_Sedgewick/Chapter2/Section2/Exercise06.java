package chapter0202;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise06 {
	
	private static Comparable[] aux;
	private static int numberOfArrayAccesses;
	private static final int maxN = 512;

	public static void sort(Comparable[] a, String type) {
		int n = a.length;
		aux = new Comparable[n];
		if (type == "TD") {
			sort(a, 0, n - 1);
		} else if (type == "BU") {
			for (int len = 1; len < n; len *= 2) {
				for (int lo = 0; lo < n - len; lo += len + len) {
					merge(a, lo, lo + len - 1, Math.min(lo + len + len - 1 , n - 1));
				}
			}
		}
	}
	
	public static Comparable[] generateRandomArray(int n) {
		Comparable[] a = new Comparable[n];
		for (int i = 0; i < n; i++) {
			a[i] = StdRandom.uniform();
		}
		return a;
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
			numberOfArrayAccesses += 2;
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
				numberOfArrayAccesses += 2;
			} else if (j > hi) {
				a[k] = aux[i++];
				numberOfArrayAccesses += 2;
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
				numberOfArrayAccesses += 4;
			} else {
				a[k] = aux[i++];
				numberOfArrayAccesses += 4;
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void main(String[] args) {
		StdOut.printf("1. Top-Down Mergesort: \n");
		StdOut.printf("%6s %15s %16s", "n", "Exact", "Upper Bound\n");
		for (int n = 1; n <= maxN; n++) {
			Comparable[] a = generateRandomArray(n);
			double ub = 6 * n * Math.log10(n) / Math.log10(2);
			numberOfArrayAccesses = 0;
			sort(a, "TD");
			StdOut.printf("%6d %15d %15.0f\n", n, numberOfArrayAccesses, ub);
		}
		
		StdOut.printf("\n2. Bottom-Up Mergesort: \n");
		StdOut.printf("%6s %15s %16s", "n", "Exact", "Upper Bound\n");
		for (int n = 1; n <= maxN; n++) {
			Comparable[] a = generateRandomArray(n);
			double ub = 6 * n * Math.log10(n) / Math.log10(2);
			numberOfArrayAccesses = 0;
			sort(a, "BU");
			StdOut.printf("%6d %15d %15.0f\n", n, numberOfArrayAccesses, ub);
		}
	}
	
}
