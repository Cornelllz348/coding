package leetcode;

public class P0009_Palindromic_Number {
	
//	Given an integer x, return true if x is palindrome integer.
//
//			An integer is a palindrome when it reads the same backward as forward.
//
//			For example, 121 is a palindrome while 123 is not.
	
    public boolean isPalindrome(int x) {
        if (x < 0) {
        	return false;
        }
        int xprime = x, y = 0;
        while (xprime > 0) {
        	int p = xprime % 10;
        	y = y * 10 + p;
        	xprime /= 10;
        }
        return x == y;
    }

}
