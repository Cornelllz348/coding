package allProblems;
import java.util.*;

/*Evaluate the value of an arithmetic expression
in Reverse Polish Notation.*/

// method: stack; iterative
// data structure: stack
// time: O(n^2)
// space: O(n)

public class Problem0008_EvaluateReversePolishNotation {
	public static int evalRPN(String[] input) {
		Deque<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < input.length; i++) {
			if (isSign(input[i]) == false) {
				q.offerFirst(Integer.parseInt(input[i]));
			} else {
				int a = q.pollFirst();
				int b = q.pollFirst();
				if (input[i].equals("+")) {
					q.offerFirst(a + b);
				} else if (input[i].equals("-")) {
					q.offerFirst(b - a);
				} else if (input[i].equals("*")) {
					q.offerFirst(a * b);
				} else {
					q.offerFirst(b / a);
				}
			}
		}
		return q.pollFirst();
	}
	
	private static boolean isSign(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String[] input = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.next();
		}
		System.out.println(evalRPN(input));
	}

}
