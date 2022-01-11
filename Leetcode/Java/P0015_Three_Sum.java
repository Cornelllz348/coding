package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
//such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.

// 0   1   2   3  4  5  6  7
//-5, -4, -2, -1, 2, 3, 4, 6

public class P0015_Three_Sum {
	
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (nums.length <= 2) return result;
    	Arrays.sort(nums);
    	int n = nums.length;
    	for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
    		int target = -1 * nums[i];
    		int j = i + 1, k = n - 1;
    		while (j < k) {
        		if (nums[j] + nums[k] == target) {
        			List<Integer> list = new ArrayList<Integer>();
        			list.add(nums[i]);
        			list.add(nums[j]);
        			list.add(nums[k]);
        			if (!result.contains(list)) result.add(list);
        			j++;
        			k--;
        		} else if (nums[j] + nums[k] < target) {
        			j++;
        		} else {
        			k--;
        		}
    		}
    	}
    	return result;
    }

}
