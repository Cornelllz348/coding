package kyu6;
import java.util.*;

public class SplitStrings {
	public static String[] solution(String s) {
		int n = s.length();
		int size = n % 2 == 0 ? n / 2 : n / 2 + 1;
		String[] output = new String[size];
		for (int i = 0; i < n / 2; i++) {
			output[i] = s.substring(i * 2, i * 2 + 2);
		}
		if (n % 2 > 0) {
			String last = s.substring(n - 1) + "_";
			output[n / 2] = last;
		}
		return output;
	}
}