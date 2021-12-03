package chapter0102;

import java.util.*;
import edu.princeton.cs.algs4.*;

public class Exercise03
{
	// create a hash table which maps 2d intervals to its two 1d intervals
	private static Map<Interval2D, Interval1D[]> intervalMap = new HashMap<>();
	
	// generate random 1d-intervals within the range of min and max
	public static Interval1D generateInterval1D(double min, double max) {
		double a = StdRandom.uniform(min, max);
		double b = StdRandom.uniform(min, max);
		double l = Math.min(a, b);
		double r = Math.max(a, b);
		Interval1D interval1d = new Interval1D(l, r);
		StdOut.println(l);
		StdOut.println(r);
		return interval1d;
	}
	
	// contain function returns true of one 2d-interval is contained in the other 2d-interval
	public static boolean contain(Interval2D interval1, Interval2D interval2) {
		double xlInterval1 = intervalMap.get(interval1)[0].min();
		double xrInterval1 = intervalMap.get(interval1)[0].max();
		double ylInterval1 = intervalMap.get(interval1)[1].min();
		double yrInterval1 = intervalMap.get(interval1)[1].max();
		
		double xlInterval2 = intervalMap.get(interval2)[0].min();
		double xrInterval2 = intervalMap.get(interval2)[0].max();
		double ylInterval2 = intervalMap.get(interval2)[1].min();
		double yrInterval2 = intervalMap.get(interval2)[1].max();
		
		if ((xlInterval1 > xlInterval2 && xrInterval1 < xrInterval2 && ylInterval1 > ylInterval2 && yrInterval1 < yrInterval2) 
			|| (xlInterval1 < xlInterval2 && xrInterval1 > xrInterval2 && ylInterval1 < ylInterval2 && yrInterval1 > yrInterval2)) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		double min = s.nextDouble();
		double max = s.nextDouble();
		s.close();

		StdDraw.setCanvasSize(1024, 512);
		StdDraw.setPenRadius(0.005);
		StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
		
		Interval2D[] intervals2d = new Interval2D[n];

		for (int i = 0; i < n; i++) {
			Interval1D xInterval = generateInterval1D(min, max);
			Interval1D yInterval = generateInterval1D(min, max);
			Interval2D interval2d = new Interval2D(xInterval, yInterval);
			interval2d.draw();
			intervals2d[i] = interval2d;
			Interval1D[] interval1d = new Interval1D[] {xInterval, yInterval};
			intervalMap.put(interval2d, interval1d);
		}
		
		int countIntersect = 0;
		int countContain = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (intervals2d[i].intersects(intervals2d[j])) {
					countIntersect++;
				}
				if (contain(intervals2d[i], intervals2d[j])) {
					countContain++;
				}
			}
		}
		StdOut.printf("the number of intervals intersecting with each other is: %d\n", countIntersect);
		StdOut.printf("the number of intervals contained in one another is: %d", countContain);
	}
}