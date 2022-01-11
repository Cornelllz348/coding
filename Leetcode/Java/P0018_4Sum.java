package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] 
// such that:

// 0 <= a, b, c, d < n
// a, b, c, and d are distinct.
// nums[a] + nums[b] + nums[c] + nums[d] == target
// You may return the answer in any order.

public class P0018_4Sum {
	
	int n = 0;
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	n = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }
    
    public ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        
        if (index >= n) {
            return results;
        }
        
        if (k == 2) {
        	// two sum on sorted array using two pointers
            int i = index, j = n - 1;
            while (i < j) {
            	if (nums[i] + nums[j] == target) {
            		List<Integer> result = new ArrayList<>();
            		result.add(nums[i]);
            		result.add(target - nums[i]);
            		results.add(result);
            		while (i < j && nums[i] == nums[i+1]) i++; // dedup
            		while (i < j && nums[j-1] == nums[j]) j--;
            		i++;
            		j--;
            	} else if (nums[i] + nums[j] < target) {
            		i++;
            	} else {
            		j--;
            	}
            }
        } else {
        	for (int i = index; i < n - k + 1; i++) {
        		ArrayList<List<Integer>> result = kSum(nums, target - nums[i], k-1, i+1);
        		if (result != null) {
        			for (List<Integer> res : result) {
        				res.add(0, nums[i]);
        			}
        			results.addAll(result);
        		}
        		while (i < n-1 && nums[i] == nums[i+1]) i++;	// dedup
        	}
        }
        return results;
    }
    
}

// num = [-2,-1,0,1,2,3], target = 0
// 
// kSum(num, target = 0, k = 4, index = 0)
//		kSum(num, target = 2, k = 3, index = 1) 
//			kSum(num, target = 3, k = 2, index = 2)
//			result = { {0, 3}, {1, 2} }
//		result = { {-1, 0, 3}, {-1, 1, 2} }
// result = { {-2, -1, 0, 3}, {-2, -1, 1, 2} } 