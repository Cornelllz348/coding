package solutions;

import java.util.*;

public class Problem0001_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}