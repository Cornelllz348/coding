package leetcode;

import java.util.Map;
import java.util.Stack;

public class P0020_Valid_Parentheses {

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//An input string is valid if:
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Input: s = "()[]{}"
//Output: true
	
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(')','(',']','[','}','{');
        for (char c : s.toCharArray()) {
        	if (c == '(' || c == '[' || c == '{') {
        		stack.add(c);
        	} else {
        		if (stack.isEmpty() || stack.pop() != map.get(c)) {
        			return false;
        		}
        	}
        }
        return stack.isEmpty() ? true : false;
    }
}
