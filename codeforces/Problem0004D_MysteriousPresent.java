package problems0001to0100;

import java.util.*;

// 1800 - dp, sortings - accepted
public class Problem0004D_MysteriousPresent {
	public static void main(String[] args) {
		List<List<Integer>> envelops = new ArrayList<List<Integer>>();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int w = s.nextInt();
		int h = s.nextInt();
		for (int i = 0; i < n; i++) {
			List<Integer> e = new ArrayList<Integer>();
			int wi = s.nextInt();
			int hi = s.nextInt();
			if (wi > w && hi > h) {
				e.add(i + 1);
				e.add(wi);
				e.add(hi);
				envelops.add(e);
			}
		}

		int size = envelops.size();
		if (size == 0) {
			System.out.println("0");
		} else {
			Collections.sort(envelops, new WidthComparator());
			int[] heightIndex = longestAscendingHeight(envelops);
			System.out.println(heightIndex.length);
			print(heightIndex);
		}
		
	}
	
	// helper function to sort envelops by width
	public static class WidthComparator implements Comparator<List<Integer>> {
		@Override
		public int compare(List<Integer> o1, List<Integer> o2) {
			if (o1.get(1) == o2.get(1)) {
				if (o1.get(2) < o2.get(2)) {
					return -1;
				} else if (o1.get(2) > o2.get(2)) {
					return 1;
				} else {
					return 0;
				}
			}
			return o1.get(1) < o2.get(1) ? -1 : 1;
		}
	}

	// helper function to obtain index array of the longest ascending subsequence of height given sorted width
	public static int[] longestAscendingHeight(List<List<Integer>> list) {
		int[] M = new int[list.size()];
		int count = 1;
		for (int i = 0; i < list.size(); i++) {
			M[i] = 1;
			for (int j = 0; j < i; j++) {
				if (list.get(j).get(2) < list.get(i).get(2) && list.get(j).get(1) < list.get(i).get(1)) {
					M[i] = Math.max(M[j] + 1, M[i]);
				}
			}
			count = Math.max(M[i], count);
		}
		// stores the indices corresponding to the longest ascending subsequence
		int[] indices = new int[count];
		int maxW = Integer.MAX_VALUE;
		int maxH = Integer.MAX_VALUE;
		for (int i = list.size() - 1; i >= 0; i--) {
			if (M[i] == count && list.get(i).get(1) < maxW && list.get(i).get(2) < maxH) {
				indices[count - 1] = list.get(i).get(0);
				maxW = list.get(i).get(1);
				maxH = list.get(i).get(2);
				count--;
			}
		}
		return indices;
	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
}
