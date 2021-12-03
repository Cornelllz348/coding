package chapter0101;

import edu.princeton.cs.algs4.*;

public class Exercise05
{
	public static void main(String[] args)
	{
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		if (x < 1.0 && x > 0.0 && y < 1.0 && y > 0.0)
		{
			StdOut.printf("x = %.1f, y = %.1f -> true", x, y);
		} else {
			StdOut.printf("x = %.1f, y = %.1f -> false", x, y);
		}
	}
}