package leetcode;

import java.util.*;

public class P0057_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int newLow = newInterval[0], newHigh = newInterval[1], index = 0;
        while (index < intervals.length) {
        	if (newLow > intervals[index][1]) {
        		result.add(intervals[index]);
        		index++;
                if (index == intervals.length) result.add(newInterval);
        	} else {
        		int nextIndex = index;
        		while (nextIndex < intervals.length && newHigh > intervals[nextIndex][1]) {
                    nextIndex++;
                }
        		int mergeLow = (newLow < intervals[index][0] ? newLow : intervals[index][0]);
        		int mergeHigh = (nextIndex >= intervals.length || newHigh < intervals[nextIndex][0] ? newHigh : intervals[nextIndex][1]);
        		result.add(new int[] {mergeLow, mergeHigh});
        		index = (nextIndex == intervals.length || newHigh < intervals[nextIndex][0] ? nextIndex : nextIndex + 1);
        		break;
        	}
        }
        while (index < intervals.length) {
        	result.add(intervals[index++]);
        }
        if (intervals.length == 0) result.add(newInterval);
        return result.toArray(new int[result.size()][2]);
    }
}