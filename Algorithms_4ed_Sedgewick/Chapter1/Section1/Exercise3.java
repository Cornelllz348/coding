package chapter0101;

import edu.princeton.cs.algs4.*;

public class Exercise3
{
	public static void main(String[] args)
	{
		// right click on main -> Run As -> Run Configurations -> Arguments -> enter arguments -> run
		// current arguments are: 4 4 4
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		if (a == b && a == c) {
			StdOut.printf("a = %d, b = %d, c = %d, result is equal", a, b, c);
		} else {
			StdOut.printf("a = %d, b = %d, c = %d, result is not equal", a, b, c);
		}
	}
}