package chapter0103;

import java.util.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

// Take from standard input an expression without left parentheses 
// and prints the equivalent infix expression with the parentheses inserted.

public class Exercise09 
{
	public static void main(String[] args) {
		Stack<String> ops = new Stack<String>();
		Stack<String> vals = new Stack<String>();
		while (!StdIn.isEmpty()) {
			// read token
			String s = StdIn.readString();
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				// if the token is an operator, push it to the ops stack
				ops.push(s);
			} else if (s.equals(")")) {
				// if the token is a right parenthesis, pair the top two values from val stack 
				// with the top operand from ops stack enclosed in "( )"
				String op = ops.pop();
				String val = vals.pop();
				vals.push("( " + vals.pop() + " " + op + " " + val + " )");
			} else {
				vals.push(s); // if the token is a value, push it into the val stack
			}
		}
		// there should be only one element left in the vals stack at the end
		StdOut.println(vals.pop());
	}
}