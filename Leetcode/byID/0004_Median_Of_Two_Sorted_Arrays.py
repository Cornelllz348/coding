class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        n1 = len(nums1)
        n2 = len(nums2)
        
        # make sure n1 <= n2
        if n1 > n2:
            return self.findMedianSortedArrays(nums2, nums1)
        
        # kth number on the combined array is left median
        k = (n1 + n2 + 1) // 2
        
        l = 0
        r = n1
        
        while l < r:
            # use m1 elements in array1, use m2 elements in array2
            m1 = l + (r - l) // 2
            m2 = k - m1
            # binary search
            if nums1[m1] < nums2[m2 - 1]:
                l = m1 + 1
            else:
                r = m1
        
        m1 = l
        m2 = k - l
        
        # pick the max of left median element
        c1a = float('-inf') if m1 <= 0 else nums1[m1 - 1]
        c1b = float('-inf') if m2 <= 0 else nums2[m2 - 1]
        c1 = max(c1a, c1b)
        
        # if combined array has odd length, return left median
        if (n1 + n2) % 2 == 1:
            return c1
        
        # pick the min of right median element
        c2a = float('inf') if m1 >= n1 else nums1[m1]
        c2b = float('inf') if m2 >= n2 else nums2[m2]
        c2 = min(c2a, c2b)
        
        return (c1 + c2) * 0.5