package leetcode;

import java.util.*;

public class P0060_Permutation_Sequence {
	
    public String getPermutation(int n, int k) {
        int factorial = 1;
        for (int i = 2; i < n; i++) {
            factorial *= i;
        }
        List<Integer> integers = new ArrayList<>();
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            integers.add(i);
        }
        k--;
        while (n > 1) {
            factors.add(k / factorial);
            k = k % factorial;
            factorial /= (n - 1);
            n--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < factors.size(); i++) {
            sb.append(Integer.toString((int) integers.get((int) factors.get(i))));
            integers.remove((int) factors.get(i));
        }
        sb.append(Integer.toString(integers.get(0)));
        return sb.toString();
    }
}