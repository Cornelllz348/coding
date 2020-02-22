package allProblems;

import java.util.*;

/*Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses 
substring.
*/

//method: string
//data structure: stack
//time: O(n)
//space: O(n)

public class Problem0237_LongestValidParentheses {
	
	public static int longestValidParentheses(String input) {
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.offerFirst(-1);
		int max = 0;
		int n = input.length();
		for (int i = 0; i < n; i++) {
			if (input.charAt(i) == '(') {
				stack.offerFirst(i);
			} else {
				stack.pollFirst();
				if (stack.isEmpty()) {
					stack.offerFirst(i);
				} else {
					max = Math.max(max, i - stack.peekFirst());
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		System.out.println(longestValidParentheses(input));
	}

}