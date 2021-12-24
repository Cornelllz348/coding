package chapter0201;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Exercise 1:
// i  min 0 1 2 3 4 5 6 7 8 9 10 11
// 0  1   E A S Y Q U E S T I O  N
// 1  1   A E S Y Q U E S T I O  N
// 2  6   A E S Y Q U E S T I O  N
// 3  9   A E E Y Q U S S T I O  N
// 4  11  A E E I Q U S S T Y O  N
// 5  10  A E E I N U S S T Y O  Q
// 6  11  A E E I N O S S T Y U  Q
// 7  7   A E E I N O Q S T Y U  S
// 8  11  A E E I N O Q S T Y U  S
// 9  11  A E E I N O Q S S T U  Y
// 10 10  A E E I N O Q S S T U  Y
// 11 11  A E E I N O Q S S T U  Y

// Exercise 2:
// The maximum number of exchanges involving any particular item during selection sort is n-1
// e.g. Z A B C D E F G --> A B C D E F G Z (Z needs to be exchanged 8 times)
// The average number of exchanges involving an item is 1

// Exercise 3:
// Give an example of an array of n items that maximizes the number of times the test a[j] < a[min] succeeds
// e.g. Z A B C D

// Exercise 4:
// i  j  0 1 2 3 4 5 6 7 8 9 10 11
//    E A S Y Q U E S T I O  N		 	
// 1  0  A E S Y Q U E S T I O  N
// 2  2  A E S Y Q U E S T I O  N
// 3  3  A E S Y Q U E S T I O  N
// 4  2  A E Q S Y U E S T I O  N
// 5  4  A E Q S U Y E S T I O  N
// 6  2  A E E Q S U Y S T I O  N
// 7  5  A E E Q S S U Y T I O  N
// 8  6  A E E Q S S T U Y I O  N
// 9  3  A E E I Q S S T U Y O  N
// 10 4  A E E I O Q S S T U Y  N
// 11 4  A E E I N O Q S S T U  Y

// Exercise 5: 
// For each of the two conditions in the inner for loop in insertion sort,
// describe an array of n items where that condition is always false when the loop terminates
// "j > 0": e.g. E D C B A
// "less(a[j], a[j - 1]": e.g. A B C D E

// Exercise 6: 
// Which method runs faster for an array with all keys identical, selection sort or insertion sort?
// Insertion sort will run faster as it will not do any exchanges while selection sort will exchange every item with itself

// Exercise 7: 
// Which method runs faster for an array in reverse order, selection sort or insertion sort?
// Selection sort is faster as it exchanges n times while insertion sort will need to exchange ~n^2/2 times

// Exercise 8: 
// Suppose that we use insertion sort on a randomly ordered array where items have only one of three values.
// Is the running time linear, quadratic, or something in between?
// The running time is quadratic

// Exercise 9:
// 		    i	j   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
// 			        E A S Y S H E L L S O  R  T  Q  U  E  S  T  I  O  N
// h = 13   13  0   E A S Y S H E L L S O  R  T  Q  U  E  S  T  I  O  N
//          14  1   E A S Y S H E L L S O  R  T  Q  U  E  S  T  I  O  N
//          15  2   E A E Y S H E L L S O  R  T  Q  U  S  S  T  I  O  N
//          16  3   E A E S S H E L L S O  R  T  Q  U  S  Y  T  I  O  N
//			17  4   E A E S S H E L L S O  R  T  Q  U  S  Y  T  I  O  N
//          18  5   E A E S S H E L L S O  R  T  Q  U  S  Y  T  I  O  N
//			19  6   E A E S S H E L L S O  R  T  Q  U  S  Y  T  I  O  N
//			20  7   E A E S S H E L L S O  R  T  Q  U  S  Y  T  I  O  N
// h = 4    4   0   E A E S S H E L L S O  R  T  Q  U  S  Y  T  I  O  N
//			5   1	E A E S S H E L L S O  R  T  Q  U  S  Y  T  I  O  N
//			.....
//			7   3   E A E L S H E S L S O  R  T  Q  U  S  Y  T  I  O  N
//          8   4   E A E L L H E S S S O  R  T  Q  U  S  Y  T  I  O  N
//			11  7   E A E L L H E R S S O  S  T  Q  U  S  Y  T  I  O  N
//			13	9	E A E L L H E R S Q O  S  T  S  U  S  Y  T  I  O  N
//			18	14	E A E L L H E R S Q O  S  T  S  I  S  Y  T  U  O  N
//			19	15	E A E L L H E R S Q O  S  T  S  I  O  Y  T  U  S  N
//			20  16	E A E L L H E R S Q O  S  T  S  I  O  N  T  U  S  Y
// h = 1    1   0   A E E L L H E R S Q O  S  T  S  I  O  N  T  U  S  Y
//			.....
// 			5   3   A E E H L L E R S Q O  S  T  S  I  O  N  T  U  S  Y
//          6   3   A E E E H L L R S Q O  S  T  S  I  O  N  T  U  S  Y
//			9   7	A E E E H L L Q R S O  S  T  S  I  O  N  T  U  S  Y
//          10  7   A E E E H L L O Q R S  S  T  S  I  O  N  T  U  S  Y
//			13  12  A E E E H L L O Q R S  S  S  T  I  O  N  T  U  S  Y
//			14  5   A E E E H I L L O Q R  S  S  S  T  O  N  T  U  S  Y
//			15	9	A E E E H I L L O O Q  R  S  S  S  T  N  T  U  S  Y
//			16	8	A E E E H I L L N O O  Q  R  S  S  S  T  T  U  S  Y
//			19  16  A E E E H I L L N O O  Q  R  S  S  S  S  T  T  U  Y

// Exercise 10:
// Why not use selection sort for h-sorting in shellsort?
// Insertion sorting is faster for h-sorting in shellsort. As h decreases, the array becomes "partially sorted"
// Selection sort is not faster for such partially sorted arrays.

public class Exercise01to10 {

	public static void selectionSort(Comparable[] a) {
		// selection sort
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
	
	public static void insertionSort(Comparable[] a) {
		// insertion sort
		int n = a.length;
		for (int i = 1; i < n; i++) {
			// insert a[i] among a[i-1], a[i-2], a[i-3], ...
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exchange(a, j, j-1);
			}
		}
	}
	
	public static void shellSort(Comparable[] a) {
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
