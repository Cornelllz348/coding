package leetcode;

import java.util.*;

public class P0046_Permutations {
	
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
        	numsList.add(num);
        }
        int n = nums.length;
        backtrack(results, numsList, 0, n);
        return results;
    }
    
    public void backtrack(List<List<Integer>> results, ArrayList<Integer> nums, int start, int n) {
    	if (start == n) {
    		results.add(new ArrayList<Integer>(nums));
    	}
    	for (int i = start; i < n; i++) {
    		Collections.swap(nums, i, start);
    		backtrack(results, nums, start + 1, n);
    		Collections.swap(nums, i, start);
    	}
    }
    
}