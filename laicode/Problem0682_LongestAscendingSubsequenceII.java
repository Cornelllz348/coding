package allProblems;

import java.util.*;

/*
 * Inherits from Problem 0001
 * Given an array A[0]...A[n-1] of integers, 
 * find out the longest ascending subsequence. 
 * If there are multiple results, then return any valid result.
 */

// method: 1D DP
// data structure: array
// time: O(n^2)
// space: O(n)

public class Problem0682_LongestAscendingSubsequenceII {

	public static int[] longestAscendingSubsequenceII(int[] A) {
		if (A.length == 0) {
			return new int[0];
		}
		int[] M = new int[A.length];
		int max = 1;
		for (int i = 0; i < A.length; i++) {
			// initialize M[i] = 1
			M[i] = 1;
			// for each i, scan all previous j
			// M[i] = max(M[j] + 1) for all j where
			// a[j] < a[i] and 0 <= j < i
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					M[i] = Math.max(M[j] + 1, M[i]);
				}
			}
			max = Math.max(M[i], max);
		}
		int[] output = new int[max];
		int count = max;
		int current = Integer.MAX_VALUE;
		for (int i = A.length - 1; i >= 0; i--) {
			if (M[i] == count && A[i] < current) {
				output[count - 1] = A[i];
				current = A[i];
				count--;
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		System.out.println(Arrays.toString(longestAscendingSubsequenceII(A)));
	}

}
