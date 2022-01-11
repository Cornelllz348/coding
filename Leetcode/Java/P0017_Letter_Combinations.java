package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Given a string containing digits from 2-9 inclusive,
//return all possible letter combinations that the number could represent. Return the answer in any order.
//A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

public class P0017_Letter_Combinations {
	
    private Map<Character, String> mapping = Map.of('2', "abc", '3', "def", '4', "ghi", 
    												'5', "jkl", '6', "mno", '7', "pqrs", 
    												'8', "tuv", '9', "wxyz");
	private List<String> combinations = new ArrayList<>();
	private String phoneDigits;
	
    public List<String> letterCombinations(String digits) {
    	if (digits.length() == 0) {											// corner case
    		return combinations;
    	}
    	phoneDigits = digits;
    	backtrack(0, new StringBuilder());									// backtrack
    	return combinations;
    }
    
    private void backtrack(int index, StringBuilder combo) {
    	if (combo.length() == phoneDigits.length()) {						// if a solution is found
    		combinations.add(combo.toString());								// output the solution
    		return;															// return
    	}
    	String possibleLetters = mapping.get(phoneDigits.charAt(index));	
    	for (char letter : possibleLetters.toCharArray()) {					// loop through all candidates
    		combo.append(letter);											// try the solution
    		backtrack(index + 1, combo);									// recursive call
    		combo.deleteCharAt(combo.length() - 1);							// backtrack
    	}
    }
}

// e.g. "23"
// backtrack(0, "a")
// 		backtrack(1, "ad")
//			backtrack(2, "ad") done
//			delete "d"
//		backtrack(1, "ae")
//			backtrack(2, "ae") done
//			delete "e"
//		backtrack(1, "af")
//			backtrack(2, "af") done
//			delete "f"
//		done
//		delete "a"
// backtrack(0, "b")
// ......