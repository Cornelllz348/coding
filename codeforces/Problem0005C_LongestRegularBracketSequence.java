package problems0001to0100;

import java.util.*;

// 1900 - constructive algorithms, dp, greedy, sortings, strings - accepted

public class Problem0005C_LongestRegularBracketSequence {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String string = s.next();
		int n = string.length();
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.offerFirst(-1);
		int max = 0;
		int countMax = 0;
		for (int i = 0; i < n; i++) {
			if (string.charAt(i) == '(') {
				stack.offerFirst(i);
			} else {
				stack.pollFirst();
				if (stack.isEmpty()) {
					stack.offerFirst(i);
				} else {
					if (i - stack.peekFirst() > max) {
						max = i - stack.peekFirst();
						countMax = 1;
					} else if (i - stack.peekFirst() == max) {
						countMax++;
					}
				}
			}
		}
		System.out.println(max + " " + (max == 0 ? 1 : countMax));
	}
	
}