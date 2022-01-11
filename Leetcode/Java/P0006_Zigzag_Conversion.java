package leetcode;

import java.util.ArrayList;
import java.util.List;

public class P0006_Zigzag_Conversion {

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
//	P   A   H   N
//	A P L S I I G
//	Y   I   R
//	And then read line by line: "PAHNAPLSIIGYIR"
//	Write the code that will take a string and make this conversion given a number of rows:
//		string convert(string s, int numRows);
	
    public static String convert(String s, int numRows) {
    	if (numRows == 1) return s;
    	
    	List<List<Character>> ll = new ArrayList<List<Character>>(numRows);
        for (int i = 0; i < numRows; i++) {
        	ArrayList<Character> l = new ArrayList<>();
        	ll.add(l);
        }
        
        int n = s.length();
        boolean down = false;
        int p = 0;
        
        for (int i = 0; i < n; i++) {
        	if (p == 0) down = true;
        	if (p == numRows - 1) down = false;
        	ll.get(p).add(s.charAt(i));
        	if (down) {
        		p++;
        	} else {
        		p--;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> l : ll) {
        	for (char c : l) {
        		sb.append(c);
        	}
        }
        return sb.toString();
     }
    
    public static void main(String[] args) {
    	String s = "PAYPALISHIRING";
    	int numRows = 3;
    	System.out.print(convert(s, numRows));
    }
}