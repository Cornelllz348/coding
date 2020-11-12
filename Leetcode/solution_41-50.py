# 41. First Missing Positive ***

# Given an unsorted integer array nums, find the smallest missing positive integer.
# Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?

def firstMissingPositive(nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    if len(nums) == 0 or 1 not in nums:
        return 1

    nums1 = []
    for i in range(len(nums)):
        if nums[i] >= 0 and nums[i] not in nums1:
            nums1.append(nums[i]) 

    n = len(nums1)
    d = [0] * 300
    for i in range(n):
        if nums1[i] > n:
            d[0] += 1
        else:
            d[nums1[i] - 1] += 1

    for i in range(300):
        if d[i] == 0:
            return i+1

# Method: Array
# Time: O(N)
# Space: O(1)

# -----

# 43. Multiply Strings **

# Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
# Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

def multiply(num1, num2):
    """
    :type num1: str
    :type num2: str
    :rtype: str
    """
    if num1 == '0' or num2 == '0':
        return '0'
    l1 = len(num1)
    l2 = len(num2)
    products = [[0] * (l1 + l2) for _ in range(l2)]
    for i in range(l2):
        carry = 0
        j = 0
        n1 = int(num2[-1-i])
        for j in range(l1):
            n2 = int(num1[-1-j])
            products[i][-1 - i - j] = carry + (n1 * n2) % 10
            carry = (n1 * n2) // 10
        if carry:
            products[i][-1 - i - l1] += carry
    result = [0] * (l1 + l2)
    carry = 0
    for i in range(len(products[0])):
        tmp = 0
        for j in range(len(products)):
            tmp += products[j][-1-i]
        result[-1 - i] += (tmp + carry) % 10
        carry = (tmp + carry) // 10
    string = ''
    if result[0] == 0:
        string = ''.join(map(str, result[1:]))
    else:
        string = ''.join(map(str, result))
    return string

# Method: Math; Array
# Time: O(l1 * l2)
# Space: O(l1 * l2)

# -----

# 48. Rotate Image **

# You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
# You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

def rotate(matrix):
    n = len(matrix)
	// example: 6 x 6 matrix; rotating each 'x' would cover the entire matrix
	// x  .  .  .  .  .
	// x  x  .  .  .  .
	// x  x  x  .  .  .
	// x  x  .  .  .  .
	// x  .  .  .  .  .
	// .  .  .  .  .  .
    for i in range(n // 2):
        for j in range(i, n - i - 1):
			// assign values of the four corners
            a = matrix[j][i]
            b = matrix[i][n-1-j]
            c = matrix[n-1-j][n-i-1]
            d = matrix[n-i-1][j]
			// rotate
            matrix[j][i] = d
            matrix[i][n-1-j] = a
            matrix[n-1-j][n-i-1] = b
            matrix[n-i-1][j] = c

# Method: Array
# Time: O(n^2)
# Space: O(1)

# -----

