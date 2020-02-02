package problems0001to0100;
import java.util.*;

// 1500 - constructive algorithms; greedy - accepted
public class Problem0004B_BeforeAnExam {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int d = s.nextInt();
		int sumTime = s.nextInt();
		int totalMin = 0, totalMax = 0;
		int[] minArray = new int[d];
		int[] maxArray = new int[d];
		for (int i = 0; i < d; i++) {
			int minTime = s.nextInt();
			int maxTime = s.nextInt();
			totalMin += minTime;
			totalMax += maxTime;
			minArray[i] = minTime;
			maxArray[i] = maxTime;
		}
		if (sumTime >= totalMin && sumTime <= totalMax) {
			System.out.println("YES");
			printHours(d, sumTime, totalMin, totalMax, minArray, maxArray);
		} else {
			System.out.println("NO");
		}
	}
	private static void printHours(int d, int sumTime, int totalMin, 
			int totalMax, int[] minArray, int[] maxArray) {
		int diff = totalMax - sumTime;
		int[] output = new int[d];
		for (int i = 0; i < d; i++) {
			if (diff <= 0) {
				output[i] = maxArray[i];
			} else if (minArray[i] + diff >= maxArray[i]) {
				output[i] = minArray[i];
				diff -= (maxArray[i] - minArray[i]);
			} else {
				output[i] = maxArray[i] - diff;
				diff = 0;
			}
			sumTime -= output[i];
		}
		for (int e : output) {
			System.out.print(e + " ");
		}
	}

}
