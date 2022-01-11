package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

// Given an array of intervals where intervals[i] = [starti, endi], 
// merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

public class P0056_Merge_Intervals {
	
    public static int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<int[]>();
        Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int[] interval : intervals) {
        	if (result.isEmpty() || result.getLast()[1] < interval[0]) {
        		result.add(interval);
        	} else {
        		result.getLast()[1] = Math.max(interval[1], result.getLast()[1]);
        	}
        }
        return result.toArray(new int[result.size()][]);
    }

}