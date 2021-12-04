package chapter0104;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

// determine the number of pairs of values in an input file that are equal: O(nlogn)

public class Exercise08 {
	
	// test client
	public static void main(String[] args) {
		int[] testArray = {1,2,3,1,1,2,4,4,3,4};
		int count = countPairs(testArray);
	    StdOut.println("Equal pairs: " + count + "; Expected: 8");
	}
	
	public static int countPairs(int[] values) {
		int count = 0;
		int n = values.length;
		if (n <= 1) {
			return count;
		}
		Arrays.sort(values);
		int tmp = 1;
		for (int i = 1; i < n; i++) {
			if (values[i - 1] == values[i]) {
				tmp++;
			} else {
				count += tmp * (tmp - 1) / 2;
				tmp = 1;
			}
		}
		// account for the remaining pairs
		count += tmp * (tmp - 1) / 2;
		return count;
	}
	
}