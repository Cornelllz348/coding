package problems0001to0100;

import java.util.*;

// 1300 - brute force; constructive algorithm - accepted

public class Problem0007A_KalevitchAndChess {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int result = 0, count = 0;
		for (int i = 0; i < 8; i++) {
			String str = s.next();
			if (str.equals("BBBBBBBB")) {
				result++;
			} else if (count == 0){
				for (int j = 0; j < 8; j++) {
					if (str.charAt(j) == 'B') {
						count++;
					}
				}
			}
		}
		System.out.println(result + count);
	}
}