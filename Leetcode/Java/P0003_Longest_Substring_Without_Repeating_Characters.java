package leetcode;

import java.util.HashMap;

// Given a string s, find the length of the longest substring without repeating characters.

public class P0003_Longest_Substring_Without_Repeating_Characters {
	
    public int lengthOfLongestSubstring(String s) {
    	// use hashmap to store index of most recent char
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0, n = s.length(), j = 0;
        for (int i = 0; i < n; i++) {
        	if (map.containsKey(s.charAt(i))) {
        		j = Math.max(j, map.get(s.charAt(i)));
        	}
        	result = Math.max(result, i - j + 1);
        	map.put(s.charAt(i), i + 1);
        }
    	return result;
    }
    
}