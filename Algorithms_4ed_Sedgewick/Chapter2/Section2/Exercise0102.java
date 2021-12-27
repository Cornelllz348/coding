package chapter0202;

// Exercise 1:

// i  j   0 1 2 3 4 5 | 6 7 8 9 10 11		k  0 1 2 3 4 5 6 7 8 9 10 11
// 0  6   A E Q S U Y | E I N O S  T		0  A
// 1  6     E Q S U Y | E I N O S  T        1  A E
// 2  6       Q S U Y | E I N O S  T		2  A E E
// 2  7       Q S U Y |   I N O S  T		3  A E E I
// 2  8       Q S U Y |     N O S  T        4  A E E I N 
// 2  9       Q S U Y |       O S  T		5  A E E I N O
// 2  10      Q S U Y |         S  T		6  A E E I N O Q
// 3  10	    S U Y |			S  T		7  A E E I N O Q S
// 4  10          U Y |			S  T		8  A E E I N O Q S S
// 4  11		  U Y |			   T		9  A E E I N O Q S S T
// 5  11		    Y |			    	    10 A E E I N O Q S S T U
// 6  11              |				        11 A E E I N O Q S S T U  Y

// Exercise 2:

//						0 1 2 3 4 5 | 6 7 8 9 10 11
//						E A S Y Q U | E S T I O  N
//  merge(a, 0, 0, 1)	A E S Y Q U | E S T I O  N
//  merge(a, 2, 2, 2)   A E S Y Q U | E S T I O  N
//merge(a, 0, 1, 2)		A E S Y Q U | E S T I O  N
//  merge(a, 3, 3, 4)	A E S Q Y U | E S T I O  N
//  merge(a, 5, 5, 5)	A E S Q Y U | E S T I O  N
//merge(a, 3, 4, 5)     A E S Q U Y | E S T I O  N
//merge(a, 0, 2, 5)		A E Q S U Y | E S T I O  N
//  merge(a, 6, 6, 7)   A E Q S U Y | E S T I O  N
//  merge(a, 8, 8, 8)   A E Q S U Y | E S T I O  N
//merge(a, 6, 7, 8)		A E Q S U Y | E S T I O  N
//  merge(a, 9, 9, 10)	A E Q S U Y | E S T I O  N
//  merge(a, 11,11,11)  A E Q S U Y | E S T I O  N
//merge(a, 6, 8, 11)    A E Q S U Y | E I N O S  T
//merge(a, 0, 5, 11)	A E E I N O   Q S S T U  Y

public class Exercise0102 {
	
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
