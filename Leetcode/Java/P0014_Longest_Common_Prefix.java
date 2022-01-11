package leetcode;

public class P0014_Longest_Common_Prefix {
	
    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
    	if (strs.length == 1) return result;
        for (int i = 1; i < strs.length; i++) {
        	result = commonPrefix(result, strs[i]);
        	if (result == "") break;
        }
        return result;
    }
    
    public String commonPrefix(String str1, String str2) {
    	int n = Math.min(str1.length(), str2.length());
    	int index = 0;
    	while (index < n && str1.charAt(index) == str2.charAt(index)) {
    		index++;
    	}
    	return str1.substring(0, index);
    }

}
