package leetcode;

import java.util.HashMap;

public class P0013_Roman_To_Integer {
	
	//      0 1 2 3 4 5 6
	// s = "M C M X C I V"

    public int romanToInt(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
    	
    	HashMap<String, Integer> dict = new HashMap<String, Integer>();
        dict.put("M", 1000);
        dict.put("D", 500);
        dict.put("C", 100);
        dict.put("L", 50);
        dict.put("X", 10);
        dict.put("V", 5);
        dict.put("I", 1);
        dict.put("IV", 4);
        dict.put("IX", 9);
        dict.put("XL", 40);
        dict.put("XC", 90);
        dict.put("CD", 400);
        dict.put("CM", 900);
        
        int i = 0, result = 0;
        
        while (i < s.length()) {
        	if (i < s.length() - 1 && dict.containsKey(s.substring(i, i + 2))) {
        		result += dict.get(s.substring(i, i + 2));
        		i += 2;
        	} else {
        		result += dict.get(s.substring(i, i + 1));
        		i += 1;
        	}
        }
        
        return result;
        
    }
    
}
