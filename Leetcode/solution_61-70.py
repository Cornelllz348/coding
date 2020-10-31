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

#-----
