package leetcode;

public class P0029_Divide_Two_Integers {
	
    private static int HALF_INT_MIN = -1073741824;
    
    public int divide(int dividend, int divisor) {
        // overflow: dividend = -2147483648, divisor = -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // make both dividend and divisor negative as negative has a wider range
        // count the number of negatives, 
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }
        // using repeated exponential searches
        int quotient = 0;
        // repeat the process until dividend is larger than divisor (negative)
        // (i.e. cannot fit more divisor into the dividend)
        while (divisor >= dividend) {
            int powerOfTwo = -1;
            int value = divisor;
            // multiply divisor by 2 (i.e. adding to itself) until divisor becomes smaller than dividend 
            while (value >= HALF_INT_MIN && value + value >= dividend) {
                value += value;
                powerOfTwo += powerOfTwo;
            }
            // handle the gap
            quotient += powerOfTwo;
            dividend -= value;
        }
        // if there is one negative amongst dividend and divisor then quotient remains negative
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }
    
}
