package chapter0202;

// bottom-up mergesort uses between ~1/2nlgn and nlgn compares and at most 6nlgn array accesses to sort an array of length n

// Exercise 3:

// 						0 1 2 3 4 5 6 7 8 9 10 11
// len = 1				E A S Y Q U E S T I O  N
// merge(a, 0, 0, 1)    A E S Y Q U E S T I O  N
// merge(a, 2, 2, 3)	A E S Y Q U E S T I O  N
// merge(a, 4, 4, 5)    A E S Y Q U E S T I O  N
// merge(a, 6, 6, 7)    A E S Y Q U E S T I O  N
// merge(a, 8, 8, 9)	A E S Y Q U E S I T O  N
// merge(a, 10,10,11)   A E S Y Q U E S I T N  O
// len = 2
// merge(a, 0, 1, 3)	A E S Y Q U E S I T N  O
// merge(a, 4, 5, 7)    A E S Y E Q S U I T N  O
// merge(a, 8, 9, 11)   A E S Y E Q S U I N O  T
// len = 4
// merge(a, 0, 3, 7)	A E E Q S S U Y I N O  T
// len = 8
// merge(a, 0, 7, 11)   A E E I N O Q S S T U  Y

public class Exercise03 {
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a) {
		int n = a.length;
		aux = new Comparable[n];
		for (int len = 1; len < n; len *= 2) {
			for (int lo = 0; lo < n - len; lo += len + len) {
				merge(a, lo, lo + len - 1, Math.min(lo + len + len -1 , n - 1));
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
