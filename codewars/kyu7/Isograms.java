package kyu7;

import java.util.*;

public class Isograms {
	public static boolean isIsogram(String str) {
		HashSet<Character> chars = new HashSet<Character>();
		char[] letters = str.toCharArray();
		boolean result = true;
		for (char l : letters) {
			if (!chars.contains(l)) {
				chars.add(l);
				if (Character.isLowerCase(l)) {
					chars.add(Character.toUpperCase(l));
				} else {
					chars.add(Character.toLowerCase(l));
				}
			} else {
				result = false;
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		System.out.println(isIsogram(str));
	}
}