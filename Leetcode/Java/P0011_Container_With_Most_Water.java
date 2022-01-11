package leetcode;

public class P0011_Container_With_Most_Water {
    public int maxArea(int[] height) {
    	int n = height.length;
    	int lo = 0, hi = n - 1;
    	int result = Integer.MIN_VALUE;
    	while (lo < hi) {
    		result = Math.max(result, (hi - lo) * Math.min(height[hi], height[lo]));
    		if (height[lo] < height[hi]) {
    			lo++;
    		} else {
    			hi--;
    		}
    	}
    	return result;
    }
}