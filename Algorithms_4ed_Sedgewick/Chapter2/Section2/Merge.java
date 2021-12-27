package chapter0202;

//												lo	hi  mid
// sort(a, 0, 15)								0   15  7
//     sort(a, 0, 7)							0   7   3
//          sort(a, 0, 3)						0   3   1
//              sort(a, 0, 1)					0   1   0
//					sort(a, 0, 0)				0   0   return
//					sort(a, 1, 1)				1   1   return
//						merge(a, 0, 0, 1)		done
//				sort(a, 2, 3)					2   3	2
//					sort(a, 2, 2)				2   2	return
//					sort(a, 3, 3)				3   3	return
//						merge(a, 2, 2, 3)		done
//				merge(a, 0, 1, 3)				done
//			sort(a, 4, 7)						4   7   5
//				.........

// top-down mergesort uses between ~1/2nlgn and nlgn compares to sort any array of length n

public class Merge {
	
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
		merge(a, lo, mid, hi);					// merge results
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
