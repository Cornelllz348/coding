package problems0001to0100;

import java.util.*;

// 1400 - implementation, strings - accepted

public class Problem0005B_CenterAlignment {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<String> array = new ArrayList<String>();
		int maxLength = 0;
		while (s.hasNextLine()) {
			String input = s.nextLine();
			array.add(input);
			maxLength = Math.max(maxLength, input.length());
		}
		StringBuilder stars = new StringBuilder();
		for (int i = 0; i < maxLength + 2; i++) {
			stars.append("*");
		}
		System.out.println(stars);
		// for each line of text stored in the array
		int flag = 1;
		int odd = 0;
		for (int i = 0; i < array.size(); i++) {
			StringBuilder sb = new StringBuilder();
			int length = array.get(i).length();
			if (maxLength > 1 && length % 2 != maxLength % 2) {
				flag += 1;
				odd = 1;
			} else {
				odd = 0;
			}
			sb.append("*");
			int leftSpaceCount = (maxLength - length) / 2 + odd * (flag % 2);
			for (int j = 0; j < leftSpaceCount; j++) {
				sb.append(" ");
			}

			sb.append(array.get(i));
			int rightSpaceCount = maxLength - leftSpaceCount - length;
			for (int j = 0; j < rightSpaceCount; j++) {
				sb.append(" ");
			}
			sb.append("*");
			
			/*
			 * System.out.println("length " + length); System.out.println("flag " + flag);
			 * System.out.println("odd " + odd); System.out.println("leftSpace " +
			 * leftSpaceCount); System.out.println("rightSpace " + rightSpaceCount);
			 */
			
			System.out.println(sb);
		}
		System.out.println(stars);
	}

}