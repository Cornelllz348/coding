package kyu4;
import java.util.*;

public class Snail {
	public static int[] snail(int[][] array) {
		List<Integer> list = new ArrayList<Integer>();
		int n = array.length;
		recursiveTraverse(array, 0, n, list);
		return toArray(list);
		}
	
	private static void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> result) {
		if (size == 0) {
			return;
		}
		if (size == 1) {
			result.add(matrix[offset][offset]);
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[offset][offset + i]);
		}
		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[offset + i][offset + size - 1]);
		}
		for (int i = size - 1; i >= 1; i--) {
			result.add(matrix[offset + size - 1][offset + i]);
		}
		for (int i = size - 1; i >= 1; i--) {
			result.add(matrix[offset + i][offset]);
		}
		recursiveTraverse(matrix, offset + 1, size - 2, result);
	}
	
	private static int[] toArray(List<Integer> list) {
		int[] array = new int[list.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
}