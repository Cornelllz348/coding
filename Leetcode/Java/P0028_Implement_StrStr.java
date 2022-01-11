package leetcode;

public class P0028_Implement_StrStr {
	
    public int strStr(String haystack, String needle) {
        int slow = 0, fast = needle.length(), n = haystack.length();
        if (fast == 0 && n >= 0) return 0;
        if (fast == 0 && n > 0 || fast > n) return -1;
        if (fast > n) return -1;
        while (fast <= n) {
        	if (haystack.substring(slow, fast).equals(needle)) {
        		return slow;
        	} else {
        		slow++;
        		fast++;
        	}
        }
        return -1;
    }
}