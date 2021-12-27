package chapter0104;

import edu.princeton.cs.algs4.StdOut;

// given two sorted arrays of n int values, prints all elements that appear in both arrays in sorted order

//                p
// a: 1 2 5 7 8 9
//                q
// b: 2 3 4 6 7 9
// -> 2 7 9

//                p
// a: 1 1 1 1 1 1
//    q
// b: 2 2 2 2 2 2

public class Exercise12 {
	
	public static void printDupElements(int[] a, int[] b) {
		int p = 0;
		int q = 0;
		while (p < a.length && q < b.length) {
			if (a[p] < b[q]) {
				p++;
			} else if (a[p] > b[q]) {
				q++;
			} else {
				StdOut.print(a[p] + " ");
				p++;
				q++;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 5, 7, 8, 9};
		int[] b = {2, 3, 4, 6, 7, 9};
		StdOut.print("Result: ");
		printDupElements(a, b);
		StdOut.println("Expected: 2 7 9");
	}
	
}