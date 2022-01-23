package leetcode;

import java.util.*;

public class P0030_Substring_with_Concatenation_of_All_Words {
	
    public static List<Integer> findSubstring(String s, String[] words) {
        int size = words.length * words[0].length();
        List<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        if (s.length() < size) return result;
        int i = 0, j = size;
        while (j <= s.length()) {
        	if (isMatch(s.substring(i, j), words, words[0].length(), map)) {
        		result.add(i);
        	}
            i++;
            j++;
        }
        return result;
    }
    
    public static boolean isMatch(String s, String[] words, int size, HashMap<String, Integer> map) {
    	String[] strings = s.split("(?<=\\G.{" + size + "})");
    	HashMap<String, Integer> mapCopy = new HashMap<String, Integer>(map);
    	for (String str : strings) {
    		if (mapCopy.containsKey(str)) {
    			mapCopy.put(str, mapCopy.get(str) - 1);
    			if (mapCopy.get(str) == 0) mapCopy.remove(str);
    		} else {
    			return false;
    		}
    	}
    	return mapCopy.isEmpty();
    }
    
    public static void main(String[] args) {
    	String s = "wordgoodgoodgoodbestword";
    	String[] words = {"word","good","best","good"};
    	System.out.println(findSubstring(s, words));
    }
}
