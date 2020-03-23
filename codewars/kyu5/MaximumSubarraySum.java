package kyu5;
import java.util.*;

public class MaximumSubarraySum {
	public static int sequence(int[] arr) {
		int result = 0;
		int cur = 0;
		for (int i = 0; i < arr.length; i++) {
			cur = Math.max(cur + arr[i], arr[i]);
			result = Math.max(result, cur);
		}
		return result;
	}
}