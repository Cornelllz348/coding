package leetcode;

public class P0044_Wildcard_Matching {
	public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        if (p.equals(s)) return true;
        if (pl > 0 && p.chars().allMatch(c -> c == '*')) return true;
        if (p.isEmpty() || s.isEmpty()) return false;
        boolean dp[][] = new boolean[pl + 1][sl + 1];
        dp[0][0] = true;
        
        for (int pi = 1; pi < pl + 1; pi++) {
            if (p.charAt(pi - 1) == '*') {
                int si = 1;
                while (!dp[pi - 1][si - 1] && si < sl + 1) {
                    si++;
                }
                dp[pi][si - 1] = dp[pi - 1][si - 1];
                while (si < sl + 1) {
                    dp[pi][si] = true;
                    si++;
                }
            } else if (p.charAt(pi - 1) == '?') {
                for (int si = 1; si < sl + 1; si++) {
                    dp[pi][si] = dp[pi - 1][si - 1];
                }
            } else {
                for (int si = 1; si < sl + 1; si++) {
                    dp[pi][si] = dp[pi - 1][si - 1] && (p.charAt(pi - 1) == s.charAt(si - 1));
                }
            }
        }  
        return dp[pl][sl];
    }
}