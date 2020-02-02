package problems0001to0100;

import java.util.*;

//1600 - hashing, implementation - accepted
public class Problem0002A_Winner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String str[] = new String[n];
		int sum[] = new int[n];
		for (int i = 0; i < n; i++) {
			str[i] = s.next();
			sum[i] = s.nextInt();
			if (map.containsKey(str[i])) {
				sum[i] += map.get(str[i]);
			}
			map.put(str[i], sum[i]);
		}
		int max = Collections.max(map.values());
		for (int i = 0; i < n; i++) {
			if (map.get(str[i]) == max && sum[i] >= max) {
				System.out.println(str[i]);
				break;
			}
		}
	}
}