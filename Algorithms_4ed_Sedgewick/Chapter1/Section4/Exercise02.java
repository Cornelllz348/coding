package chapter0104;

import java.math.BigInteger;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// modify threeSum to work properly even when the int values are so large that
// adding two of them might cause integer overflow

public class Exercise02 {
	
	public static int count(int[] a) {
		int n = a.length;
		int count = 0;
		BigInteger bigInt;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					bigInt = BigInteger.valueOf(a[i]);
					bigInt = bigInt.add(BigInteger.valueOf(a[j]));
					bigInt = bigInt.add(BigInteger.valueOf(a[k]));
					if (bigInt.intValue() == 0) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = new int[4];
		a[0] = 2147483647; // largest int Java can represent
		a[1] = 2;
		a[2] = 1;
		a[3] = -3;
		int count = count(a);
		StdOut.println(count); // count = 1; no error
	}
	
}