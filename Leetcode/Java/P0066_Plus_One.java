package leetcode;

import java.util.*;

public class P0066_Plus_One {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                break;
            } else {
                if (i == 0) {
                    int[] newDigits = new int[n + 1];
                    Arrays.fill(newDigits, 0);
                    newDigits[0] = 1;
                    return newDigits;
                } else {
                    digits[i] = 0;
                }
            }
        }
        return digits;
    }
}