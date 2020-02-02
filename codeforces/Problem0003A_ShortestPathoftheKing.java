package problems0001to0100;

import java.util.*;

// 1200 - greedy, shortest path - accepted
public class Problem0003A_ShortestPathoftheKing {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String from = s.next();
		String to = s.next();
		char fromX = from.charAt(0);
		char fromY = from.charAt(1);
		char toX = to.charAt(0);
		char toY = to.charAt(1);
		int minSteps = Math.max(Math.abs(toY - fromY), Math.abs(toX - fromX));
		System.out.println(minSteps);
		// end is upper right to start
		while (toX > fromX && toY > fromY) {
			System.out.println("RU");
			fromX++;
			fromY++;
		}
		// end is lower left to start
		while (toX < fromX && toY < fromY) {
			System.out.println("LD");
			fromX--;
			fromY--;
		}
		// end is lower right to start
		while (toX > fromX && toY < fromY) {
			System.out.println("RD");
			fromX++;
			fromY--;
		}
		// end is upper left to start
		while (toX < fromX && toY > fromY) {
			System.out.println("LU");
			fromX--;
			fromY++;
		}
		// after diagonal moves, go for horizontal /
		// vertical moves if needed
		while (toX > fromX) {
			System.out.println("R");
			fromX++;
		}
		while (toX < fromX) {
			System.out.println("L");
			fromX--;
		}
		while (toY > fromY) {
			System.out.println("U");
			fromY++;
		}
		while (toY < fromY) {
			System.out.println("D");
			fromY--;
		}
	}
}