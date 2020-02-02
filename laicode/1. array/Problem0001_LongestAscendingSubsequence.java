package allProblems;

import java.util.*;

/* Given an array A[0]...A[n-1] of integers, 
 * find out the length of the longest ascending subsequence.*/

// method: 1D DP
// data structure: array
// time: O(n^2)
// space: O(n)

public class Problem0001_LongestAscendingSubsequence {
	
	public static int longestAscendingSubsequence(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int[] M = new int[A.length];
		int result = 1;
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
			result = Math.max(M[i], result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		System.out.println(longestAscendingSubsequence(A));
	}
}