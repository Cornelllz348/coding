package kyu7;
import java.util.*;

public class NumberOfPeopleInTheBus {
	public static int countPassengers(ArrayList<int[]> stops) {
		int count = 0;
		for (int i = 0; i < stops.size(); i++) {
			int[] arr = stops.get(i);
			int on = arr[0];
			int off = arr[1];
			count = count + on - off;
		}
		return count;
	}
}