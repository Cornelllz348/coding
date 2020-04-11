package kyu5;
import java.util.*;

public class DoubleCola {
	public static String WhoIsNext(String[] names, int n) {
		int l = names.length;
		int p = 0;
		int sum = 0;
		while (sum + l * Math.pow(2, p) < n) {
			sum += l * Math.pow(2, p);
			p++;
		}
		int i = (n - sum - 1) / (int) Math.pow(2, p);
		return names[i];
	}
}