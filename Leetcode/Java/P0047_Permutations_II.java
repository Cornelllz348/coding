package leetcode;

import java.util.*;

public class P0047_Permutations_II {
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
        	if (!map.containsKey(num)) {
        		map.put(num, 0);
        	}
        	map.put(num, map.get(num) + 1);
        }
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(results, comb, map, nums.length);
        return results;
    }
    
    
    public void backtrack(List<List<Integer>> results, LinkedList<Integer> comb, HashMap<Integer, Integer> map, int n) {
    	if (comb.size() == n) {
    		results.add(new ArrayList<Integer>(comb));
    		return;
    	}
    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		Integer num = entry.getKey();
    		Integer count = entry.getValue();
    		if (count == 0) continue;
    		comb.addLast(num);
    		map.put(num, count - 1);
    		backtrack(results, comb, map, n);
    		comb.removeLast();
    		map.put(num, count);
    	}
    }

}
