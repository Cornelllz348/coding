package kyu6;

import java.util.*;

public class Xbonacci {
	public double[] tribonacci(double[] s, int n) {
		double[] output = new double[n];
		for (int i = 0; i < n; i++) {
			if (i < 3) {
				output[i] = s[i];
			} else {
				output[i] = output[i - 3] + output[i - 2] + output[i - 1];
			}
		}
		return output;
	}
}