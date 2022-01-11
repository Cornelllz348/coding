package leetcode;

public class P0004_Median_Of_Two_Sorted_Arrays {
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        // ensure n1 is the shorter array
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);
        
        int k = (n1 + n2 + 1) / 2;
        
        int l = 0, r = n1;
        
        // binary search to find how many numbers we should take from nums1
        while (l < r) {
        	int m1 = l + (r - l) / 2;
        	int m2 = k - m1;
        	if (nums1[m1] < nums2[m2 - 1]) {
        		l = m1 + 1;
        	} else {
        		r = m1;
        	}
        }
        
        int m1 = l, m2 = k - l;
        
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], 
        				  m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        
        // if combined array is of odd length, median is c1
        if ((n1 + n2) % 2 == 1) return c1;
        
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1], 
        				  m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        
        // if combined array is of even length, median is the average of c1 and c2 
        return (c1 + c2) * 0.5;
    }

}
