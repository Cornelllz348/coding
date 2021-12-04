package chapter0103;

import java.util.HashMap;
import java.util.Stack;

// reads in a text stream from standard input and uses a stack to determine whether its parentheses are properly balanced

public class Exercise04

{
	public static boolean Parentheses(String s) {
		
		Stack<Character> pstack = new Stack<Character>();
		
		HashMap<Character, Character> pmap = new HashMap<Character, Character>();
		pmap.put(')', '(');
		pmap.put(']', '[');
		pmap.put('}', '{');
		
		char[] parray = s.toCharArray();
		for (char c: parray) {
			// if c is a right parenthesis:
			// 1. return false if the stack is empty
			// 2. return false if top of stack is not the correct left parenthesis
			if (pmap.containsKey(c)) {
		        char top = pstack.isEmpty() ? '#' : pstack.pop();
		        if (top != pmap.get(c)) {
		        	return false;
		        }
			} else { // push c into stack if c is a left parenthesis
				pstack.push(c);
			}
		}
		// return true if the stack ends up empty
		return pstack.isEmpty();
	}
}