package chapter0101;

import edu.princeton.cs.algs4.*;

public class Exercise07
{
	public static void main(String[] args)
	{
		StdOut.println("a. ");
		double t = 9.0;
		while (Math.abs(t - 9.0/t) > 0.001) {
			t = (9.0/t + t) / 2.0;
			StdOut.printf("t = %.5f\n", t);
		}
		
		StdOut.println("b. ");
		int sum = 0;
		for (int i = 1; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				sum++;
				StdOut.printf("sum = %d, i = %d, j = %d\n", sum, i, j);
			}
		}
		
		StdOut.println("c. ");
		int sum2 = 0;
		for (int i = 1; i < 1000; i *= 2) {
			for (int j = 0; j < 1000; j++) {
				sum2++;
				StdOut.printf("sum = %d, i = %d, j = %d\n", sum2, i, j);
			}
		}
	}
}