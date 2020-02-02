package problems0001to0100;

import java.util.Scanner;

public class Problem0001A_TheatreSquare {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextInt();
		long m = s.nextInt();
		long a = s.nextInt();
		double result = Math.ceil((double) n/a) * Math.ceil((double) m/a);
		System.out.println((long) result);
	}
}