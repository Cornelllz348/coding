package problems0001to0100;

import java.util.*;

// 1300 - brute force; geometry

public class Problem0006A_Triangle {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] sticks = new int[4];
		sticks[0] = s.nextInt();
		sticks[1] = s.nextInt();
		sticks[2] = s.nextInt();
		sticks[3] = s.nextInt();
		Arrays.sort(sticks);
		boolean triangle = false, segment = false;
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				for (int k = j + 1; k < 4; k++) {
					if (sticks[i] + sticks[j] == sticks[k]) {
						segment = true;
					}
					if (sticks[i] + sticks[j] > sticks[k]) {
						triangle = true;
						break;
					}
				}
			}
		}
		if (triangle == true) {
			System.out.print("TRIANGLE");
		} else if (segment == true) {
			System.out.print("SEGMENT");
		} else {
			System.out.print("IMPOSSIBLE");
		}
	}
}
