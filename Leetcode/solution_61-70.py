#-----

# 66. Plus One *

# Given a non-empty array of digits representing a non-negative integer, increment one to the integer.
# The digits are stored such that the most significant digit is at the head of the list, 
# and each element in the array contains a single digit.
# You may assume the integer does not contain any leading zero, except the number 0 itself.

def plusOne(digits):
    """
    :type digits: List[int]
    :rtype: List[int]
    """
    if digits[-1] < 9:
        digits[-1] += 1
    else:
        i = -1
        while digits[i] == 9 and i > -len(digits):
            digits[i] = 0
            i -= 1
        digits[i] += 1
    if digits[0] == 10:
        digits = digits[1:]
        digits = [1, 0] + digits
    return digits

# Method: Array
# Time: O(n)
# Space: O(1)

# -----

# 69. Sqrt(x) *

# Given a non-negative integer x, compute and return the square root of x.
# Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        left = 0
        right = x // 2 + 1
        while left < right - 1:
            mid = left + (right - left) // 2
            if mid * mid == x:
                return mid
            elif mid * mid > x:
                right = mid
            else:
                left = mid
        return x if x == 1 else left

# Method: Binary Search
# Time: O(logx)
# Space: O(1)

# -----

