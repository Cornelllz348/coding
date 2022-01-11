package leetcode;

//Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
//
//'.' Matches any single character.​​​​
//'*' Matches zero or more of the preceding element.
//The matching should cover the entire input string (not partial).

//e.g:
//        0  1  2  3  4  5  6  7
//           a  a  b  b  c  c  c
//  0     T  F  F  F  F  F  F  F
//  1  b  F  F  F  F  F  F  F  F
//  2  *  T  F  F  F  F  F  F  F
//  3  a  F  T  F  F  F  F  F  F
//  4  *  T  T  T  F  F  F  F  F
//  5  b  F  F  F  T  F  F  F  F
//  6  .  F  F  F  F  T  F  F  F
//  7  c  F  F  F  F  F  T  F  F
//  8  *  F  F  F  F  F  T  T  T


public class P0010_Regular_Expression_Matching {
	
	public static boolean isMatch(String s, String p) {
		
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        dp[0][0] = true;
        
        // the j = 0 row is always F since an empty pattern cannot match any non-empty string
        
        // fill the i = 0 column
        for (int j = 1; j <= p.length(); j++){
        	// x* can match an empty string therefore if sss matches ppp then sss matches pppx*
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]){
                dp[0][j] = true;
            }
        }
        
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= p.length(); j++){
            	// if two chars match or pattern char is a '.' -> dp[i][j] = dp[i-1][j-1]
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // if pattern char is a '*':
                // 1. if chars don't match but pattern is '.*' -> dp[i][j] = dp[i][j-2]
                // 2. if chars match and pattern is 'x*' -> dp[i][j] is true if any of the dp[i][j-2], dp[i][j-1], or dp[i-1][j] is true
                //		1). dp[i-1][j]   -->  string keeps being the same char
                // 		2). dp[i][j-2]   -->  '*' represents zero occurrence of char
                //      3). dp[i][j-1]   -->  '*' represents an occurrence of char
                else if (p.charAt(j - 1) == '*'){
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.'){
                        dp[i][j] = dp[i][j - 2];
                    }
                    else {
                        dp[i][j] = (dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
	}
	
	public static void main(String[] args) {
		String s = "aabbccc";
		String p = "a*b.c*";
		isMatch(s, p);
	}


}
