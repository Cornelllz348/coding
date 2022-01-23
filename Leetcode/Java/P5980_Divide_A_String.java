package leetcode;

import java.util.Arrays;

public class P5980_Divide_A_String {
	
    public static String[] divideString(String s, int k, char fill) {
    	int l = s.length();
    	int c = l % k == 0 ? 0 : 1;
    	int n = l / k + c;
    	for (int i = 0; i < k * n - l; i++) {
    		s = s + fill;
    	}
    	String[] result = new String[n];
    	for (int i = 0; i < n; i++) {
    		result[i] = s.substring(i * k, (i + 1) * k);
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));
    }

}
