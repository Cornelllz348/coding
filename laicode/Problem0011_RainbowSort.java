package allProblems;

import java.util.Arrays;
import java.util.Scanner;

/*Given an array of balls, where the color of the balls can only be Red, 
Green or Blue, sort the balls such that all the Red balls are grouped 
on the left side, all the Green balls are grouped in the middle and 
all the Blue balls are grouped on the right side. 
(Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).*/

// method: three pointers
// data structure: array
// time: O(n)
// space: O(1)

public class Problem0011_RainbowSort {
	
	public static int[] rainbowSort(int[] array) {
		// i = 0 ->: to the left of i (not including i) are all -1's
		// j = 0 ->: in [i, j) are all 0's
		// j is the current index
		// [j, k]: yet to be covered
		// k = n - 1 <-: to the right of k (not including k) are all 1's 
		int i = 0, j = 0, k = array.length - 1;
		while (j <= k) {
			if (array[j] == -1) {
				swap(array, i, j);
				i++;
				j++;
			} else if (array[j] == 0) {
				j++;
			} else {
				swap(array, j, k);
				k--;
			}
		}
		return array;
	}
	
	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(Arrays.toString(rainbowSort(input)));
	}
}
