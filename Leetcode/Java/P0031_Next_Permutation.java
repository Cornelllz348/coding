package leetcode;

public class P0031_Next_Permutation {
    public void nextPermutation(int[] nums) {
    	
    	int i = nums.length - 2;
    	// find the first decreasing element from the end (call this element P)
    	while (i >= 0 && nums[i + 1] <= nums[i]) {
    		i--;
    	}
    	// find the number just greater than P in the subarray to the right of Ps
    	// swap the number with the element P
    	// and reverse the subarray to the right of P
    	if (i >= 0) {
    		int j = nums.length - 1;
    		while (nums[j] <= nums[i]) {
    			j--;
    		}
    		swap(nums, i, j);
    	}
    	reverse(nums, i + 1);
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
