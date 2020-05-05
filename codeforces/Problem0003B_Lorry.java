package problems0001to0100;

import java.util.*;

// 1900 - greedy, sortings - time limit exceeded
public class Problem0003B_Lorry {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int v = s.nextInt();
		// put scanner inputs into a list
		List<List<Integer>> kayak = new ArrayList<List<Integer>>();
		List<List<Integer>> catam = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			int t = s.nextInt(); // type = 1 for kayak or 2 for catam
			int p = s.nextInt(); // carrying capacity of each vehicle
			// list stores combinations of index and capacity
			List<Integer> vehicle = new ArrayList<Integer>();
			vehicle.add(i + 1);
			vehicle.add(p);
			if (t == 1) {
				kayak.add(vehicle);
			} else {
				catam.add(vehicle);
			}
		}
		// sort each list in descending order by capacity
		Collections.sort(kayak, new MyComparator());
		Collections.sort(catam, new MyComparator());
		
//		System.out.println(kayak);
//		System.out.println(catam);
		
		int i = 0, j = 0, sumVolume = 0, total = 0;
		List<List<Integer>> catamList = new ArrayList<List<Integer>>();
		List<List<Integer>> kayakList = new ArrayList<List<Integer>>();
		// fill as many catamarans as possible into the lorry
		while (i < catam.size() && sumVolume < v - 1) {
			total += catam.get(i).get(1);
			catamList.add(catam.get(i));
			sumVolume += 2;
			i++;
		}
//		System.out.println(catamList);
		// starting from the smallest catamaran, if the sum of the two largest kayaks are larger than the catamaran, 
		// then replace the catamaran with the two kayaks
		while (j < kayak.size() - 2 && i > 0) {
			if (kayak.get(j).get(1) + kayak.get(j + 1).get(1) > catamList.get(i - 1).get(1)) {
				total += kayak.get(j).get(1) + kayak.get(j + 1).get(1) - catamList.get(i - 1).get(1);
				kayakList.add(kayak.get(j));
				kayakList.add(kayak.get(j + 1));
				j += 2;
				i--;
			}
//			System.out.println(kayakList);
//			System.out.println(i);
		}
		
		while (j < kayak.size() && sumVolume < v) {
			total += kayak.get(j).get(1);
			kayakList.add(kayak.get(j));
			sumVolume++;
			j++;
		}
		
		while (i > 0) {
			kayakList.add(catam.get(i - 1));
			i--;
		}
//		System.out.println(kayakList);
		System.out.println(total);
		for (int a = 0; a < kayakList.size(); a++) {
			System.out.print(kayakList.get(a).get(0) + " ");
		}
	}
	
	private static class MyComparator implements Comparator<List<Integer>> {
		@Override
		public int compare(List<Integer> o1, List<Integer> o2) {
			if (o1.get(1) == o2.get(1)) {
				return 0;
			}
			return o1.get(1) > o2.get(1) ? -1 : 1;
		}
	}

}
