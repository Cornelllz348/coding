package kyu6;

import java.util.*;

public class ConvertStringToCamelCase {
	public static String toCamelCase(String s) {
		if (s == null || s.isEmpty()) {
			return "";
		}
		String output = "";
		output += s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			char prev = s.charAt(i - 1);
			char cur = s.charAt(i);
			if ((prev == '-' || prev == '_') && Character.isLowerCase(cur)) {
				output += Character.toUpperCase(s.charAt(i));
			} else if (cur != '-' && cur != '_'){
				output += cur;
			}
		}
		return output;
	}
}