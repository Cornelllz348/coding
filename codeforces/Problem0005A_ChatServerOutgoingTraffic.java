package problems0001to0100;

import java.util.*;

// 1200, implementation - accepted

public class Problem0005A_ChatServerOutgoingTraffic {
	
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int count = 0;
		int result = 0;
		while(s.hasNextLine()) {
			String input = s.nextLine();
			if (input.charAt(0) == '+') {
				count++;
			} else if (input.charAt(0) == '-') {
				count--;
			} else {
				int loc = input.indexOf(':');
				int length = input.length();
				result += (length - loc - 1) * count;
			}
		}
		System.out.println(result);
	}
}