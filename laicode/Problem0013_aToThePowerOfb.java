package allProblems;
import java.util.Scanner;

/*Evaluate a to the power of b, 
assuming both a and b are integers and b is non-negative.*/

// method: recursion
// data structure: n/a
// time: O(logb)
// space: O(logb)
// assumption: a and b are integers; b is non-negative

public class Problem0013_aToThePowerOfb {
	public static long power(int a, int b) {
		if (b == 0) {
			return 1;
		}
		long p = power(a, b/2);
		if (b % 2 == 0) {
			return p * p;
		} else {
			return p * p * a;
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(power(a, b));
	}

}
