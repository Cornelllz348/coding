package leetcode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

public class P0001_Two_Sum {
	
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> ht = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (ht.containsKey(diff)) {
				result[0] = i;
				result[1] = ht.get(diff);
			} else {
				ht.put(nums[i], i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 26;
		int[] result = twoSum(nums, target);
		System.out.printf("%d and %d", result[0], result[1]);
	}

}
