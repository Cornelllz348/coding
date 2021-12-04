package chapter0104;

import edu.princeton.cs.algs4.StdOut;

public class Exercise07 {

//analyze ThreeSum under a cost model that counts arithmetic operations (and comparisons)
//	a total of 4 operation in each iteration
//	tilde approximation: ~4*n^3/6
//	order of growth: O(n^3)
	
	public static void main(String[] args) {
		int[] a = {-5, -3, -1, 0, 1, 2, 3};
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (a[i] + a[j] + a[k] == 0) { // three operations (two additions; one comparison)
						count++; // one operation (one addition)
					}
				}
			}
		}
		StdOut.println(count);
	}
}
