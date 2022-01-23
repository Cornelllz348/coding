package leetcode;

import java.util.*;

public class P0040_Combination_Sum_II {
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	
    	List<List<Integer>> results = new ArrayList<>();
    	LinkedList<Integer> comb = new LinkedList<>();
    	
    	Arrays.sort(candidates);
    	
    	backtrack(candidates, results, comb, 0, target);
    	
    	return results;
    }
    
    public void backtrack(int[] candidates, List<List<Integer>> results, LinkedList<Integer> comb, int curr, int remain) {
    	if (remain == 0) {
    		results.add(new ArrayList<Integer>(comb));
    		return;
    	} else if (remain < 0) {
    		return;
    	}
    	
    	for (int i = curr; i < candidates.length; i++) {
            if (i > curr && candidates[i] == candidates[i - 1]) {
                continue;
    		}
            int candidate = candidates[i];
            if (remain - candidate < 0) break;									// early termination
            comb.add(candidate);
            backtrack(candidates, results, comb, i + 1, remain - candidate);
            comb.removeLast();
    	}
    }
    
}
