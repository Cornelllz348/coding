package problems0001to0100;
import java.util.*;

// 1200 - brute force; math - accepted
public class Problem0004A_Watermelon {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int w = s.nextInt();
		if (w > 2 && w % 2 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}