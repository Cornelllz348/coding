package kyu5;
import java.util.*;

public class PrimesInNumbers {
	public static String factors(int n) {
		StringBuilder sb = new StringBuilder();
		int twoPower = 0;
		while (n % 2 == 0) {
			n /= 2;
			twoPower++;
		}
		write(sb, 2, twoPower);
		for (int i = 3; i <= n; i += 2) {
			int power = 0;
			while (n % i == 0) {
				n /= i;
				power++;
			}
			write(sb, i, power);
		}
		return sb.toString();
	}
	public static String write(StringBuilder sb, int factor, int power) {
		if (power > 1) {
			sb.append("(");
			sb.append(factor);
			sb.append("**");
			sb.append(power);
			sb.append(")");
		} else if (power == 1) {
			sb.append("(");
			sb.append(factor);
			sb.append(")");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(factors(n));
	}

}
