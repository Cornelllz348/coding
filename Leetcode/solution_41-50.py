# 41. First Missing Positive

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

# 43. Multiply Strings

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

# -----

