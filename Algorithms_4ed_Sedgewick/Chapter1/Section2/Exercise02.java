package chapter0102;

import java.util.*;
import edu.princeton.cs.algs4.*;

public class Exercise02
{
	// generate a random 1d interval
	public static Interval1D generateInterval1D() {
		Random rand = new Random();
		double a = rand.nextDouble();
		double b = rand.nextDouble();
		double min = Math.min(a, b);
		double max = Math.max(a, b);
		Interval1D interval1d = new Interval1D(min, max);
		return interval1d;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		
		// initialize intervals array
		Interval1D[] intervals = new Interval1D[n];
		// create array of n intervals on the unit length axis
		for (int i = 0; i < n; i++) {
			Interval1D interval1d = generateInterval1D();
			intervals[i] = interval1d;
		}
		
		// print all pairs that intersect
		int countIntersect = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (intervals[i].intersects(intervals[j])) {
					countIntersect++;
					System.out.printf("pair #%d: \n", countIntersect);
					System.out.printf("interval [%.5f, %.5f] intersects with interval [%.5f, %.5f]\n", 
							intervals[i].min(), intervals[i].max(), intervals[j].min(), intervals[j].max());
				}
			}
		}
	}
}