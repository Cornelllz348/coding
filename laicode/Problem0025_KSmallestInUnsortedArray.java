package allProblems;
import java.util.*;

/*Find the K smallest numbers in an unsorted integer array A. 
The returned numbers should be in ascending order.*/

//method: heapify
//data structure: heap, array
//time: O(k + (n - k) logk)
//space: O(k)

public class Problem0025_KSmallestInUnsortedArray {
	public static int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}
		// max heap of size k 
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new myComparator());
		for (int i = 0; i < array.length; i++) {
			// heapify the first k elements
			if (i < k) {
				maxHeap.offer(array[i]);
				// for each of the the remaining (n - k) elements,
				// only if it is less than the max (i.e. top) of the max heap,
				// then replace the top with this element
			} else if (array[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		int[] result = new int[k];
		// iterate through the top k element to get the k smallest
		for (int i = k - 1; i >= 0; i--) {
			result[i] = maxHeap.poll();
		}
		return result;
	}
	
	// max heap comparator
	public static class myComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1.equals(o2)) {
				return 0;
			}
			return o1 > o2 ? -1 : 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}
		System.out.println(Arrays.toString(kSmallest(array, k)));
	}

}
