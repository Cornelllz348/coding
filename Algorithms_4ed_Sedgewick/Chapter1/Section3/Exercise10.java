package chapter0103;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Converts an arithmetic expression from infix to postfix
// e.g. Infix: ( (1 + 2) * 3 ); Postfix: 1 2 + 3 *
// e.g. Infix: ( (1 + 2) * (3 + 4) ); Postfix: 1 2 + 3 4 + *

public class Exercise10
{
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				ops.push(s);
			} else if (s.equals(")")) {
				String val = vals.pop();
				String op = ops.pop();
				vals.push(vals.pop() + " " + val + " " + op);
			} else if (s.equals("(")) {
				// do nothing
			} else {
				vals.push(s);
			}
		}
		StdOut.println(vals.pop());
	}
}