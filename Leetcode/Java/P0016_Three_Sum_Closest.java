package leetcode;

import java.util.Arrays;

//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.

public class P0016_Three_Sum_Closest {
    
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int n = nums.length;
		int minDiff = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < n - 2; i++) {
			int j = i + 1, k = n - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target) {
					return sum;
				} else if (sum < target) {
					j++;
					if (Math.abs(sum - target) < minDiff) {
						minDiff = Math.abs(sum - target);
						result = sum;
					}
				} else {
					k--;
					if (Math.abs(sum - target) < minDiff) {
						minDiff = Math.abs(sum - target);
						result = sum;
					}
				}
			}
		}
		return result;
    }

}
