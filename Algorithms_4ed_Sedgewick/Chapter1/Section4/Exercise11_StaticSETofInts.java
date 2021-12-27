package chapter0104;

import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class Exercise11_StaticSETofInts {
	private int[] a;
	
	// create a set from the values in a[]
	public Exercise11_StaticSETofInts(int[] keys) {
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++) {
			a[i] = keys[i]; // defensive copy
		}
		Arrays.sort(a);
	}
	
	public boolean contains(int key) {
		return indexOf(key) != -1;
	}
	
	// finds the number of occurrences of a given key in O(logn) time
	public int howMany(int key) {
		int first = firstOccur(key);
		int last = lastOccur(key);
		if (first == - 1 || last == -1) {
			return 0;
		} else {
			return last - first + 1;
		}
	}

	public int firstOccur(int key) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int left = 0;
		int right = a.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (a[mid] >= key) {
				right = mid;
			} else {
				left = mid;
			}
		}
		if (a[left] == key) {
			return left;
		}
		if (a[right] == key) {
			return right;
		}
		return -1;
	}
	
	public int lastOccur(int key) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int left = 0;
		int right = a.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (a[mid] <= key) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (a[left] == key) {
			return left;
		}
		if (a[right] == key) {
			return right;
		}
		return -1;
	}
	
	public int indexOf(int key) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) {
				hi = mid - 1;
			} else if (key > a[mid]) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	

}