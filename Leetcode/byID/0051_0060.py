


# -----

# 53. Maximum Subarray *

# Given an integer array nums, find the contiguous subarray (containing at least one number) 
# which has the largest sum and return its sum.

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # nums = [-2,1,-3,4,-1,2,1,-5,4]
        # currSum = maxSum = -2
        currSum = maxSum = nums[0]
        
        for i in range(1, len(nums)):
            # currSum = [-2,1,1,4,3,5,6,1,5]
            # maxSum = [-2,1,1,4,4,5,6,6,6]
            currSum = max(nums[i], currSum + nums[i])
            maxSum = max(maxSum, currSum)
            
        return maxSum
    
# Method: DP
# Time: O(n)
# Space: O(1)

# -----

# 54. Spiral Matrix **

# Given an m x n matrix, return all elements of the matrix in spiral order.

def spiralOrder(matrix):
    """
    :type matrix: List[List[int]]
    :rtype: List[int]
    """
    result = []
    m = len(matrix)
    n = len(matrix[0])
    # iteration counter
    for i in range(min(m,n) // 2 + min(m,n) % 2):
        # eastbound
        for j in range(i, n - i):
            result.append(matrix[i][j])
        # southbound
        for k in range(i + 1, m - i):
            result.append(matrix[k][n - i - 1])
        # westbound
        for p in range(n - i - 2, i - 1, -1):
            # if statement to avoid duplicate
            if m - i - 1 > i:
                result.append(matrix[m - i - 1][p])
        # northbound
        for q in range(m - i - 2, i, -1):
            # if statement to avoid duplicate
            if i < n - i - 1:
                result.append(matrix[q][i])
    return result

# Method: Array
# Time: O(m*n)
# Space: O(m*n)

# -----

# 55. Jump Game **

# Given an array of non-negative integers, you are initially positioned at the first index of the array.
# Each element in the array represents your maximum jump length at that position.
# Determine if you are able to reach the last index.

def canJump(self, nums):
    """
    :type nums: List[int]
    :rtype: bool
    """
    i = len(nums) - 2
    while i >= 0:
        if nums[i] == 0:
            j = i
            count = 0
            while j >= 0:
                if nums[j] > count:
                    i = j
                    break
                elif j == 0:
                    return False
                else:
                    count += 1
                    j -= 1
        i -= 1
    return True

# Method: Array; Brute Force
# Time: O(n)
# Space: O(1)

# -----

# 58. Length of Last Word *

# Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
# return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
# If the last word does not exist, return 0.

def lengthOfLastWord(s):
    """
    :type s: str
    :rtype: int
    """
    result = 0
    if not s or len(s) == 0:
        return result
    # flag means a non-space char has been encountered
    flag = False
    for i in range(len(s)-1, -1, -1):
        # if char is not space, result += 1 and set flag to be true
        if s[i] != ' ':
            result += 1
            flag = True
        # if flag is true and a space is encountered, break
        elif flag == True and s[i] == ' ':
            break
    return result

# Method: Array
# Time: O(n)
# Space: O(1)

# -----
