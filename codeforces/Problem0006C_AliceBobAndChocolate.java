package problems0001to0100;

import java.util.*;

// 1500 - greedy, two pointers - accepted

public class Problem0006C_AliceBobAndChocolate {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] C = new int[n];
		for (int i = 0; i < n; i++) {
			C[i] = s.nextInt();
		}
		if (n == 1) {
			System.out.println(1 + " " + 0);
		} else {
			int a = 0;
			int b = n - 1;
			int aSum = C[a];
			int bSum = C[b];
			while (a < b - 1) {
				if (aSum <= bSum) {
					a++;
					aSum += C[a];
				} else {
					b--;
					bSum += C[b];
				}
			}
			System.out.println(a + 1 + " " + (n - b));
		}
	}
}