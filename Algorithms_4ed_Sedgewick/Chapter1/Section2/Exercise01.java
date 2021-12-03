package chapter0102;

import java.util.*;
import edu.princeton.cs.algs4.*;

public class Exercise01

{
	// generate a random point in the 2d unit square
	public static Point2D generatePoint() {
		Random rand = new Random();
		double x = rand.nextDouble();
		double y = rand.nextDouble();
		Point2D point2d = new Point2D(x, y);
		return point2d;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		s.close();
		
		// initialize points array
		Point2D[] points = new Point2D[n];
		// generate points
		for (int i = 0; i < n; i++) {
			Point2D point2d = generatePoint();
			points[i] = point2d;
		}
		
		// calculate distance of the two closest points
		double minDistance = Double.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				double distance = points[i].distanceTo(points[j]);
				minDistance = Math.min(distance, minDistance);
			}
		}

		System.out.printf("Distance separating the closest pair of points is: %.5f", minDistance);

	}
	
	
}