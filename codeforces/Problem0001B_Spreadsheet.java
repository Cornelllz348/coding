package problems0001to0100;

import java.util.Scanner;

public class Problem0001B_Spreadsheet {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (--n >= 0) {
			String str = s.next();
			int cIndex = str.indexOf('C');
			// if string is in RXCY format
			if (str.charAt(0) == 'R' && cIndex > 1 && str.charAt(1) >= '0' && str.charAt(1) <= '9') {
				int rowNum = 0;
				int colNum = 0;
				for (int i = 1; i < cIndex; i++) {
					int a = str.charAt(i);
					rowNum = rowNum * 10 + (a - '0');
				}
				for (int j = cIndex + 1; j < str.length(); j++) {
					int b = str.charAt(j);
					colNum = colNum * 10 + (b - '0');
				}
				String colAlp = toAlphabetic(colNum - 1);
				String rowString = Integer.toString(rowNum);
				System.out.println(colAlp + rowString);
			} else {
				// if string is in CX format
				int colNum = 0;
				int rowNum = 0;
				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);
					if (c < '0' || c > '9') {
						int num = c - 'A' + 1;
						colNum = colNum * 26 + num;
					} else {
						rowNum = rowNum * 10 + (c - '0');
					}
				}
				String row = Integer.toString(rowNum);
				String col = Integer.toString(colNum);
				System.out.println("R" + row + "C" + col);
			}
		}
	}
	
	public static String toAlphabetic(int i) {
		int quot = i / 26;
		int rem = i % 26;
		char letter = (char) ((int)'A' + rem);
		if (quot == 0) {
			return "" + letter;
		} else {
			return toAlphabetic(quot - 1) + letter;
		}
	}
	
}