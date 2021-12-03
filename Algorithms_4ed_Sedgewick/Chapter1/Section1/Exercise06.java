package chapter0101;

import edu.princeton.cs.algs4.*;

public class Exercise06
{
	public static void main(String[] args)
	{
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			StdOut.printf("i = %d, f = %d, g = %d\n",i, f, g);
			f = f + g;
			g = f - g;
		}
	}
}