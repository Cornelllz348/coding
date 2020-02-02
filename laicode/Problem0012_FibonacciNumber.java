package allProblems;
import java.util.Scanner;

/*Get the Kth number in the Fibonacci Sequence. 
(K is 0-indexed, the 0th Fibonacci number is 0 
and the 1st Fibonacci number is 1).*/

// method: dp
// data structure: array
// time: O(K)
// space: O(1)

public class Problem0012_FibonacciNumber {
	public static long fibonacci(int K) {
		if (K <= 0) {
			return 0;
		}
		long[] array = new long[K + 1];
		array[1] = 1;
		for (int i = 2; i <= K; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[K];
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int K = s.nextInt();
		System.out.println(fibonacci(K));
	}

}
