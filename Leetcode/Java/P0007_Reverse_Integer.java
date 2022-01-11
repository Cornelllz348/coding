package leetcode;

public class P0007_Reverse_Integer {
	
//	Given a signed 32-bit integer x, return x with its digits reversed. 
//	If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
	
    public int reverse(int x) {
    	int sign = 1;
    	int output = 0;
    	if (x < 0) {
    		sign = -1;
    		x = -x;
    	}
    	while (x > 0) {
    		int p = x % 10;
    		x = x / 10;
            if (output > Integer.MAX_VALUE / 10 || (p > 7 && output == Integer.MAX_VALUE / 10)) return 0;
    		output = output * 10 + p;
    	}
    	return sign * output;
    }

}
