package chapter0103;

import java.util.Stack;
import edu.princeton.cs.algs4.*;

public class Exercise05

// prints the binary representation of n

{
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int n = 50;
		while (n > 0) {
			stack.push(n % 2);
			n = n / 2;
		}
		for (int d : stack) {
			StdOut.print(d);
		}
		StdOut.println();
	}
	
}