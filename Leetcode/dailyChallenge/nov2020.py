# NOV 1: 252. Meeting Rooms I *

# Given an array of meeting time intervals where intervals[i] = [starti, endi], 
# determine if a person could attend all meetings.

def canAttendMeetings(intervals):
    """
    :type intervals: List[List[int]]
    :rtype: bool
    """
    result = True
    if len(intervals) == 0:
        return result
    time = [False] * (10**6+1)
    for i in intervals:
        start = i[0]
        end = i[1]
        for j in range(start, end):
            if time[j] == True:
                return False
            else:
                time[j] = True
    return result

# Method: Brute Force
# Time: O(n^2)
# Space: O(1)

# -----

# NOV 2: 1290. Convert Binary Number in a Linked List *

# Given head which is a reference node to a singly-linked list. 
# The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
# Return the decimal value of the number in the linked list.

def getDecimalValue(head):
    """
    :type head: ListNode
    :rtype: int
    """
    
    # Two methods:
    
    # decimal operation
    def binaryRepresentation(head):
        num = head.val
        while head.next:
            num = num * 2 + head.next.val
            head = head.next
        return num

    # binary operation
    # example: 1 -> 0 -> 1
    def binaryManipulation(head):
        num = head.val
        while head.next:
            # 1) num = 1; num = (1 << 1) | 0 = (1 0) | (0 0) = (1 0) = 2
            # 2) num = 2; num = (2 << 1) | 1 = (1 0 0) | (0 0 1) = (1 0 1) = 5
            num = (num << 1) | head.next.val
            head = head.next
        return num

    return binaryManipulation(head)

# Method: Bit Operation
# Time: O(n)
# Space: O(1)

# -----

# NOV 4: 1446. Consecutive Characters *

# Given a string s, the power of the string is the maximum length of a non-empty substring that 
# contains only one unique character.

# Return the power of the string.

def maxPower(s):
    """
    :type s: str
    :rtype: int
    """
    n = len(s)
    result = count = 0
    slow = fast = 0
    while fast < n:
        if s[slow] == s[fast]:
            fast += 1
            count += 1
        else:
            slow = fast
            count = 0
        result = max(result, count)
    return result

# Method: Two Pointers
# Time: O(N)
# Space: O(1)

# -----

# NOV 6: 1217. Minimum Cost to Move Chips to The Same Position *

# We have n chips, where the position of the ith chip is position[i].
# We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:
# position[i] + 2 or position[i] - 2 with cost = 0.
# position[i] + 1 or position[i] - 1 with cost = 1.
# Return the minimum cost needed to move all the chips to the same position.

def minCostToMoveChips(position):
    """
    :type position: List[int]
    :rtype: int
    """
    odd = 0
    even = 0
    for i in range(len(position)):
        if position[i] % 2 == 0:
            even += 1
        else:
            odd += 1
    return min(odd, even)

# Method: Math
# Time: O(n)
# Space: O(1)

# -----

# NOV 7: 1283. Find the Smallest Divisor Given a Threshold **

# Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the array by it and sum the result of the division. 
# Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
# Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
# It is guaranteed that there will be an answer.

def smallestDivisor(nums, threshold):
    """
    :type nums: List[int]
    :type threshold: int
    :rtype: int
    """
    nums.sort()
    left = 1
    right = nums[-1]
    result = nums[-1]
    while left <= right:
        mid = left + (right - left) // 2
        total = 0
        for i in range(len(nums)):
            total += nums[i] // mid + (nums[i] % mid > 0)
        if total > threshold:
            left = mid + 1
        else:
            result = min(result, mid)
            right = mid - 1
    return result

# Method: Binary Search
# Time: O(Nlogn) where N is size of nums and n is the max integer in nums
# Space: O(1)

# -----

# NOV 8: 1099. Two Sum Less Than K *

def twoSumLessThanK(A, K):
    """
    :type A: List[int]
    :type K: int
    :rtype: int
    """
    n = len(A)
    if n == 1:
        return -1
    A.sort()
    pivot = 0
    result = -1
    while pivot < len(A) and A[pivot] < K/2:
        i = pivot + 1
        j = n - 1
        while i <= j:
            mid = i + (j - i) // 2
            if A[pivot] + A[mid] < K:
                i = mid + 1
                result = max(A[pivot] + A[mid], result)
            else:
                j = mid - 1
        pivot += 1
    return result

# Method: Binary Search
# Time: O(nlogn)
# Space: O(1)

# -----

# NOV 9: 563. Binary Tree Tilt *

def findTilt(self, root):
    """
    :type root: TreeNode
    :rtype: int
    """
    self.result = 0

    def calcSum(root):
        # base case
        if not root:
            return 0
        # go down the left subtree
        leftSum = calcSum(root.left)
        # go down the right subtree
        rightSum = calcSum(root.right)
        # calculate the tilt
        tilt = abs(leftSum - rightSum)
        self.result += tilt
        # return the total sum of the subtree
        return leftSum + rightSum + root.val

    calcSum(root)

    return self.result

# Method: Tree, DFS
# Time: O(N) where N is the total number of nodes
# Space: O(N)

# -----

# NOV 11: 832. Flipping an Image *

def flipAndInvertImage(A):
    """
    :type A: List[List[int]]
    :rtype: List[List[int]]
    """
    n = len(A)
    m = len(A[0])
    for i in range(n):
        left = 0
        right = m - 1
        while left <= right:
            self.swap(A[i], left, right)
            left += 1
            right -= 1
        A[i] = map(lambda x: x * -1 + 1, A[i])
    return A

def swap(A, i, j):
    tmp = A[i]
    A[i] = A[j]
    A[j] = tmp
    
# Method: Array
# Time: O(n^2)
# Space: O(1)
    
# -----
