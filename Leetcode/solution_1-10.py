# 1: Two Sum *

# Given an array of integers, return indices of the two numbers such that they add up to a specific target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.

# Solution:

def twoSum(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    d = {} # d is a dictionary that stores numbers as key and index as value
    r = [] # r is result array to return
    
    # loop through nums; for each number, if (target - number) is not found in d, add the number and its index to d;
    # if found, which means the current number and a previous number in d add up to target,
    # return the current index and index of (target - number)
    
    for i in range(len(nums)):
        if d.get(target - nums[i]) == None:
            d.update({nums[i]: i})
        else:
            r.append(d.get(target - nums[i]))
            r.append(i)
    return r

# Method: Array, Hashtable
# Time: O(n)
# Space: O(n)

# -----

# 2: Add Two Numbers **

# You are given two non-empty linked lists representing two non-negative integers. 
# The digits are stored in reverse order and each of their nodes contain a single digit. 
# Add the two numbers and return it as a linked list.
# You may assume the two numbers do not contain any leading zero, except the number 0 itself.

# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: 7 -> 0 -> 8
# Explanation: 342 + 465 = 807.

# Definition for singly-linked list

class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Solution:

def addTwoNumbers(l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
    h1 = l1 # h1 is the head of linked list l1
    h2 = l2 # h2 is the head of linked list l2
    l3 = ListNode(0) # create a ListNode l3 whose value is zero 
    h3 = l3 # h3 is the head of linked list l3
    c = 0 # c represents a carry factor which is 1 when sum of two nodes is a two digit number (i.e. >= 10)
    
    # traverse l1, l2 together until 1). neither l1 or l2 has any remaining nodes, AND 2). carry is 0
    # e.g. l1 = 9, l2 = 2 -> cannot stop after the first node as the result is two digit (i.e. carry = 1)
    
    while h1 or h2 or c:
        a = (h1.val if h1 else 0) # if a list runs out of nodes, value is 0
        b = (h2.val if h2 else 0)
        c, val = divmod(a + b + c, 10)
        h3.next = ListNode(val)
        h3 = h3.next
        print(h3.val)
        h1 = (h1.next if h1 else None)
        h2 = (h2.next if h2 else None)
    return l3.next

# Method Linked List
# Time: O(max(m,n))
# Space: O(max(m,n))

# -----

# 3: Longest Substring Without Repeating Characters **

# Given a string s, find the length of the longest SUBSTRING without repeating characters

# Solution:

def lengthOfLongestSubstring(s):
    ans = p1 = p2 = 0 # fast / slow pointer
    d = set() # a set d used to store all encountered chars
    while p1 < len(s) and p2 < len(s):
        # when p2 points to a char that is not in d, add the char to d, p2 + 1, and update ans
        if (s[p2] not in d):
            d.add(s[p2])
            p2 += 1
            ans = max(ans, p2 - p1)
        # if p2 points to a char that is already in d, need to move p1 such that there is no duplicate char
        # between p1 and p2 while deleting the duplicate chars from d
        else:
            d.remove(s[p1])
            p1 += 1
        print('d =', d)
        print('p1 = ', p1)
        print('p2 = ', p2)
    return ans

# Method: String; Two Pointers; Sliding Window; Hash Set
# Time: O(n)
# Space: O(k) where k is the size of the hash set; 
#        worst case is then O(min(m,n)) where m is the size of the string s and n is the size of the hashset d

# -----

# 4: Median of Two Sorted Arrays ***

# Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
# Follow up: The overall run time complexity should be O(log (m+n)).

def findMedianSortedArrays(nums1, nums2):
    """
    :type nums1: List[int]
    :type nums2: List[int]
    :rtype: float
    """
    m = len(nums1)
    n = len(nums2)

    # make nums1 the shorter array
    if m > n:
        nums1, nums2, m, n = nums2, nums1, n, m
    
    # if both arrays are empty then raise error
    if n == 0:
        raise ValueError

    imin, imax, half_len = 0, m, (m + n + 1) // 2

    while imin <= imax:
        """
        initialize two partitions i and j such that total size of left side of the two arrays is equal to
        (even case) or one plus (odd case) the total size of right side of the two arrays
        nums1:  3 5 (i-1) | 8 (i) 15
        nums2:  1 9 10 (j-1) | 13 (j) 18
        """
        i = (imin + imax) // 2
        j = half_len - i
        """
        We need to guarantee that the partitions works in a way such that all numbers on the left side
        of the two arrays are smaller than all numbers or the right side.
        To achieve that, we only need to make sure that:
            1). nums1[i-1] < nums2[j], and
            2). nums2[j-1] < nums1[i]
        -> if 1) is violated we need to move the nums1 partition to the left (i.e. make nums1 smaller)
        -> if 2) is violated we need to move the nums1 partition to the right (i.e. make nums2 larger)
        -> if the correct partition is found, then the median number is one of the following:
            1). if m + n is even, then median is the average of the maximum of nums1[i-1] and nums2[j-1] and the minimum
            of nums1[i] and nums2[j], or
            2). if m + n is odd, then median is maximum of nums1[i-1] and nums2[j-1]
        """
        if i < m and nums2[j - 1] > nums1[i]:
            imin = i + 1
        elif i > 0 and nums1[i - 1] > nums2[j]:
            imax = i - 1
        else:
            if i == 0: max_of_left = nums2[j - 1]
            elif j == 0: max_of_left = nums1[i - 1]
            else: max_of_left = max(nums1[i - 1], nums2[j - 1])

            if (m + n) % 2 == 1:
                    return max_of_left

            if i == m: min_of_right = nums2[j]
            elif j == n: min_of_right = nums1[i]
            else: min_of_right = min(nums1[i], nums2[j])

            return (max_of_left + min_of_right) / 2.0

# Method: Array, Binary Search, Divide and Conqueur
# Time: O(log(m+n))
# Space: O(1)

# -----

# 5: Longest Palindromic Substring **

# Given a string s, return the longest palindromic substring in s

def longestPalindrome(s):
    """
    :type s: str
    :rtype: str
    """
    p1 = p2 = 0
    for i in range(len(s)):
        l1 = expandAroundCenter(s, i, i)         # when len(s) is odd
        l2 = expandAroundCenter(s, i, i+1)       # when len(s) is even
        l = max(l1, l2)
        if (l > p2 - p1):
            p1 = i - (l - 1) // 2
            p2 = i + l // 2
    return s[p1:p2+1]

# given a string s and two pointers, expand around center and return the length of the palindrome substring
def expandAroundCenter(s, left, right):
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left = left - 1
        right = right + 1
    return right - left - 1

# Method: String
# Time: O(n^2)
# Space: O(1)

# -----

# 6. ZigZag Conversion **

# The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
# P   A   H   N
# A P L S I I G
# Y   I   R
# Output: "PAHNAPLSIIGYIR"

def zigZagConvert(s, numRows):
    """
    :type s: str
    :type numRows: int
    :rtype: str
    """
    if numRows == 1:
        return s
    lists = ['' for i in range(numRows)]
    row = 0
    down = False
    # iterate through s and record row number
    # if row = 0 or row = numRows - 1, then change direction
    for i in range(len(s)):
        lists[row] += s[i]
        if row == 0 or row == numRows - 1:
            down = not down
        if down:
            row = row + 1
        else: row = row - 1
    return ''.join(lists)

# Method: Math
# Time: O(n)
# Space: O(n)

# -----

# 7: Reverse Integer *

# Given a 32-bit signed integer, reverse digits of an integer

def reverse(x):
    """
    :type x: int
    :rtype: int
    """
    result = 0
    sign = 1
    if x < 0:
        x = -x
        sign = -1
    while x != 0:
        x, b = divmod(x, 10)
        result = result * 10 + b
    if result < - 2**31 or result > 2**31 - 1:
        return 0
    else:
        return result * sign

# Method: Math
# Time: O(n)
# Space: O(1)

# -----

# 8. String to Integer (atoi) **

"""
Implement atoi which converts a string to an integer.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits 
as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, 
which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, 
no conversion is performed.
If no valid conversion could be performed, a zero value is returned.
"""

def myAtoi(s):
    """
    :type s: str
    :rtype: int
    """
    s = s.strip()
    if s == "":
        return 0

    sign = 1

    if s[0] in {'-', '+'}:
        sign = -1 if s[0] == '-' else 1
        s = s[1:]

    result = 0
    flag = False

    for i in range(len(s)):
        if (flag == False and not s[i].isnumeric()):
            return 0
        if s[i].isnumeric():
            result = result * 10 + int(s[i])
            flag = True
        if (flag == True and not s[i].isnumeric()):
            break

    if sign == 1:
        return min(result, 2**31 - 1)
    else:
        return max(sign * result, -2**31)

# -----

# 9. Palindrome Number *

# Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

def isPalindrome(x):
    """
    :type x: int
    :rtype: bool
    """
    if x < 0:
        return False
    y = 0
    s = x
    while s > 0:
        s, r = divmod(s, 10)
        y = y * 10 + r
    if y == x:
        return True
    else:
        return False
        
# -----

# 10. Regular Expression Matching ***

# Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where: 

# '.' Matches any single character.
# '*' Matches zero or more of the preceding element.
# The matching should cover the entire input string (not partial).

def regExpMatch(text, pattern):
    """
    :type s: str
    :type p: str
    :rtype: bool
    """
    s = ' ' + s
    p = ' ' + p
    dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]
    dp[0][0] = True

# DP rules:
# T[i][j] where i is ith index in text and j is jth index in pattern
# If text[i] == pattern[j] or pattern[j] == '.':
    # T[i][j] = T[i-1][j-1]
# If pattern[j] = '*':
    # 1). T[i][j] = T[i][j-2] if zero occurrence
    # 2). T[i][j] if text[i] == pattern[j-1] or pattern[j-1] = '.'
    
    # takes care of the first row where pattern might be a*, a*b*, a*b*c*, etc.
    for i in range(1, len(p)):
        if p[i] == '*':
            dp[0][i] = dp[0][i-2]

    for i in range(1, len(s)):
        for j in range(1, len(p)):
            if p[j] in {s[i], '.'}:
                dp[i][j] = dp[i-1][j-1]
            elif p[j] == '*':
                dp[i][j] = dp[i][j-2]
                if p[j-1] in {s[i], '.'}:
                    dp[i][j] = dp[i][j] or dp[i-1][j]

    return dp[len(s)-1][len(p)-1]

"""
dp grid:

        0    1    2    3    4    5    6
             x    a    *    b    .    c

0       T    F    F    F    F    F    F

1   x   F    T    F    T    F    F    F

2   a   F    F    T    T    F    F    F

3   a   F    F    F    T    F    F    F

4   b   F    F    F    F    T    F    F

5   y   F    F    F    F    F    T    F

6   c   F    F    F    F    F    F    T  

"""

# Method: Dynamic Programming
# Time: O(mn) where m is length of text and n is length of pattern
# Space: O(mn)
