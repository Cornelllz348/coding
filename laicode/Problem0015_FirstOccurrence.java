package allProblems;

import java.util.Scanner;

/*Given a target integer T and an integer array A sorted in ascending order, 
find the index of the first occurrence of T in A 
or return -1 if there is no such index.*/

//method: binary search
//data structure: array
//time: O(logn)
//space: O(1)

public class Problem0015_FirstOccurrence {
	public static int firstOccurrence(int[] array, int target) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int n = array.length;
		int l = 0;
		int r = n - 1;
		while (l < r - 1) {
			int m = l + (r - l) / 2;
			if (target <= array[m]) {
				r = m;
			} else {
				l = m;
			}
		}
		if (target == array[l]) {
			return l;
		}
		if (target == array[r]) {
			return r;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}
		int target = s.nextInt();
		System.out.println(firstOccurrence(array, target));
	}

}
