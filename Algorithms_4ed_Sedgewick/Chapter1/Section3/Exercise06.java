package chapter0103;

import java.util.Stack;
import edu.princeton.cs.algs4.*;

// the code reverses queue q

public class Exercise06

{
	public static void main(String[] args) {
		
		Queue<String> q = new Queue<String>();
		//          ------------>
		// eg. q = [1, 2, 3, 4, 5]
		Stack<String> stack = new Stack<String>();
		
		while (!q.isEmpty()) {
			stack.push(q.dequeue());
		}
		//          ------------>
		// stack = [1, 2, 3, 4, 5]
		
		while (!stack.isEmpty()) {
			q.enqueue(stack.pop());
		}
		//      ------------>
		// q = [5, 4, 3, 2, 1]

	}
	
}