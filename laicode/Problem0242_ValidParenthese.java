package allProblems;

import java.util.*;

/*Given a string containing just the characters 
'(', ')', '{', '}', '[' and ']', 
determine if the input string is valid. 
The brackets must close in the correct order.*/

//method: string
//data structure: stack
//time: O(n)
//space: O(n)

public class Problem0242_ValidParenthese {
	public static boolean isValid(String input) {
		Deque<Character> stack = new LinkedList<Character>();
		char[] chars = input.toCharArray();
		for (int i = 0; i < input.length(); i++) {
			if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
				stack.offerFirst(chars[i]);
			} else if (stack.isEmpty() || 
					(stack.peekFirst() == '(' && chars[i] != ')' ||
					stack.peekFirst() == '[' && chars[i] != ']' ||
					stack.peekFirst() == '{' && chars[i] != '}') ) {
				return false;
			} else {
				stack.pollFirst();
			}
		}
		return stack.isEmpty() ? true : false;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(isValid(input));
	}
}