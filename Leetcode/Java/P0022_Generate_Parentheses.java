package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0022_Generate_Parentheses {
	
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, result);
        return result;
    }
    
    public static void backtrack(StringBuilder sb, int left, int right, int max, List<String> result) {
    	// found solution - add to result
    	if (sb.length() == max * 2) {
    		result.add(sb.toString());
    		return;
    	}
    	// add "(" when there are still left parentheses to be added
    	if (left < max) {
    		sb.append("(");
    		backtrack(sb, left + 1, right, max, result);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    	// add ")" when there are more left parentheses than right
    	if (right < left) {
    		sb.append(")");
    		backtrack(sb, left, right + 1, max, result);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    }
    
    public static void main(String[] args) {
    	int n = 3;
    	System.out.println(generateParenthesis(n));
    }
}

//backtrack(sb = "(", left = 1, right = 0, max = 3, result)
//	backtrack(sb = "((", left = 2, right = 0, max = 3, result)
//		backtrack(sb = "(((", left = 3, right = 0, max = 3, result)
//		backtrack(sb = "((()", left = 3, right = 1, max = 3, result)
//		backtrack(sb = "((())", left = 3, right = 2, max = 3, result)
//      backtrack(sb = "((()))", left = 3, right = 3, max = 3, result={"((()))"})
//		done
//  backtrack(sb = "(()", left = 2, right = 1, max = 3, result)
//		backtrack(sb = "(()(", left = 3, right = 1, max = 3, result)
//      backtrack(sb = "(()(", left = 3, right = 2, max = 3, result)
//		backtrack(sb = "(()()", left = 3, right = 3, max = 3, result+)
//		done
//	backtrack(sb = "(())", left = 2, right = 2, max = 3, result)
//		backtrack(sb = "(())(", left = 3, right = 2, max = 3, result)
//		backtrack(sb = "(())()", left = 3, right = 3, max = 3, result+)
//		done
//backtrack(sb = "()", left = 1, right = 1, max = 3, result)
//	backtrack(sb = "()(", left = 2, right = 1, max = 3, result)
//		backtrack(sb = "()((", left = 3, right = 1, max = 3, result)
//		backtrack(sb = "()(()", left = 3, right = 2, max = 3, result)
//		backtrack(sb = "()(())", left = 3, right = 3, max = 3, result+)
//		done
//....

