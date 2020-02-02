package problems0001to0100;
import java.util.*;

// 1500 - data structures; hashing; implementation - accepted
public class Problem0004C_RegistrationSystem {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < n; i++) {
			String name = s.next();
			if (!map.containsKey(name)) {
				System.out.println("OK");
				map.put(name, 1);
			} else {
				int k = map.get(name);
				System.out.println(name + Integer.toString(k));
				map.replace(name, k + 1);
			}
		}
	}
}