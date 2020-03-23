package kyu7;
import java.util.*;

public class SquareDigit {
	public static int solution(int n) {
		String in = Integer.toString(n);
		String out = "";
		char[] digits = in.toCharArray();
		for (char d : digits) {
			int num = Integer.parseInt(String.valueOf(d));
			num = num * num;
			String str = Integer.toString(num);
			out += str;
		}
		return Integer.parseInt(String.valueOf(out));
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		System.out.println(solution(number));
	}
}