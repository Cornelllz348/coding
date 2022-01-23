package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P0039_Combination_Sum {
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(target, comb, results, 0, candidates);
        return results;
    }
    
    public void backtrack(int remain, LinkedList<Integer> comb, List<List<Integer>> results, int start, int[] candidates) {
    	if (remain == 0) {
    		results.add(new ArrayList<Integer>(comb));
    		return;
    	} else if (remain < 0) {
    		return;
    	}
    	
    	for (int i = start; i < candidates.length; i++) {
    		comb.add(candidates[i]);
    		this.backtrack(remain - candidates[i], comb, results, i, candidates);
    		comb.removeLast();
    	}
    }

}