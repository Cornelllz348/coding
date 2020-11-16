# 11. Container with Most Water **

# Given n non-negative integers a1, a2, ..., an, 
# where each represents a point at coordinate (i, ai).
# n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
# Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
# Notice that you may not slant the container.

def maxArea(height):
    """
    :type height: List[int]
    :rtype: int
    """
    l = 0
    r = len(height) - 1
    a = 0
    # Left and right pointers start at the beginning and end of the height array respectively
    # calculate current area bounded by the left and right pointers
    # if height[left] < height[right] then move left pointer to the right
    # else move right pointer to the left
    while l < r:
        a = max(a, min(height[l], height[r]) * (r - l))
        if height[l] < height[r]:
            l = l + 1
        else:
            r = r - 1
    return a

# Method: array, two pointers
# Time: O(n)
# Space: O(1)

# -----

# 12. Integer to Roman **

# Given an integer, convert it to a roman numeral.

def intToRoman(num):
    """
    :type num: int
    :rtype: str
    """
    result = ""
    base = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]
    roman = ['M', 'CM', 'D', 'CD', 'C', 'XC', 'L', 'XL', 'X', 'IX', 'V', 'IV', 'I']
    index = [0] * 13
    b = num
    for i in range(len(base)):
        a, b = divmod(b, base[i])
        index[i] = a
    # print(index)
    for i in range(len(roman)):
        result = result + ''.join(roman[i]*index[i])
    return result
    
# -----

# 13. Roman to Integer *

# Given a roman numeral, convert it to an integer
# I can be placed before V (5) and X (10) to make 4 and 9. 
# X can be placed before L (50) and C (100) to make 40 and 90. 
# C can be placed before D (500) and M (1000) to make 400 and 900.

def romanToInt(s):
    i = result = 0
    M = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    N = {'IV': 4, 'IX': 9, 'XL': 40, 'XC': 90, 'CD': 400, 'CM': 900}
    while i < len(s) - 1:
        if (N.get(s[i:i+2]) == None):
            result = result + M.get(s[i])
            i = i + 1
        else:
            result = result + N.get(s[i:i+2])
            i = i + 2
    if i == len(s) - 1:
        result = result + M.get(s[i])
    return result

# -----

# 14. Longest Common Prefix *

# Write a function to find the longest common prefix string amongst an array of strings.
# If there is no common prefix, return an empty string "".

def longestCommonPrefix(strs):
    """
    :type strs: List[str]
    :rtype: str
    """
    if strs == None or len(strs) == 0:
        return ""
    for i in range(len(strs[0])):
        # c is the ith char of the first string in the array
        c = strs[0][i]
        # iterate through the remaining strings in the array
        for j in range(1, len(strs)):
            # if i hits the shortest string or char doesn't match, return the prefix
            if (i == len(strs[j]) or strs[j][i] != c):
                return strs[0][0:i]
    return strs[0]

# Method: String
# Time: O(S) where S is sum of all chars in all strings
# Space: O(1)

# -----

# 15. 3 Sum **

# Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
# Find all unique triplets in the array which gives the sum of zero.
# Notice that the solution set must not contain duplicate triplets.

def threeSum(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """
    res = []
    # first sort the array from smallest to largest
    nums.sort()
    for i in range(len(nums)-2):
        # deduplicate i
        if i > 0 and nums[i] == nums[i-1]:
            continue
        # fix i, let l and r be the left-most and right-most index of the subarray after i
        # calculate 3 sum, if >0, move r to the left (nums[r] needs to be smaller), if <0, move l to the right
        l, r = i+1, len(nums)-1
        while l < r:
            s = nums[i] + nums[l] + nums[r]
            if s < 0:
                l += 1 
            elif s > 0:
                r -= 1
            else:
                res.append((nums[i], nums[l], nums[r]))
                # deduplicate l and r
                while l < r and nums[l] == nums[l+1]:
                    l += 1
                while l < r and nums[r] == nums[r-1]:
                    r -= 1
                l += 1; r -= 1
    return res

"""
     i   l        r<--r
-4  -1  -1  0  1  2  3
"""

# Method: Two pointers
# Time: O(n^2)
# Space: O(n) from sorting

# -----

# 16. 3Sum Closest **

# Given an array nums of n integers and an integer target, 
# find three integers in nums such that the sum is closest to target. Return the sum of the three integers. 
# You may assume that each input would have exactly one solution.

def threeSumClosest(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    result = 0
    nums.sort()
    diff = float('inf')
    for i in range(len(nums)):
        j = i + 1
        k = len(nums) - 1
        while j < k:
            s = nums[i] + nums[j] + nums[k]
            # update diff if s becomes closer to target in either direction
            if abs(target - s) < abs(diff):
                diff = target - s
            if s < target:
                j = j + 1
            else:
                k = k - 1
        if diff == 0:
            break
    return target - diff

# Method: Two pointers
# Time: O(n^2)
# Space: O(n) from sorting

# -----

# 17. Letter Combinations of a Phone Number **

# Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number 
# could represent. Return the answer in any order.
# A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

def letterCombinations(digits):
    phone = {'2': ['a', 'b', 'c'],
             '3': ['d', 'e', 'f'],
             '4': ['g', 'h', 'i'],
             '5': ['j', 'k', 'l'],
             '6': ['m', 'n', 'o'],
             '7': ['p', 'q', 'r', 's'],
             '8': ['t', 'u', 'v'],
             '9': ['w', 'x', 'y', 'z']}

    def backtrack(combination, next_digits):
        # if there is no more digits to check
        if len(next_digits) == 0:
            output.append(combination)
        # if there are still digits to check
        else:
            # iterate over all letters which map the next available digit
            for letter in phone[next_digits[0]]:
                # append the current letter to the combination
                # and proceed to the next digit
                backtrack(combination + letter, next_digits[1:])

    output = []
    if digits:
        backtrack("", digits)
    return output


"""
DFS call stack:
2                 a           b           c

             /    |  \   /    |  \   /    |  \
             
3            ad  ae  af  bd  be  bf  cd  ce  cf

"""

# Method: String, DFS
# Time: O(4^n) where n is the length of digits
# Space: O(n)

# -----

# 18. 4Sum **

# Given an array nums of n integers and an integer target, are there elements a, b, c, 
# and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
# Notice that the solution set must not contain duplicate quadruplets.

def fourSum(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[List[int]]
    """

    def kSum(nums, target, k):
        res = []
        # if nums is empty, or if k * the largest number in nums is smallest than target,
        # or if k * the smallest numer in nums is larger than target, than return empty
        # as it is imposssible to find k numbers that sum to target
        if len(nums) == 0 or nums[0] * k > target or target > nums[-1] * k:
            return res
        # at base case of recursion (i.e. k == 2), do twoSum
        if k == 2:
            return twoSum(nums, target)
        # recursion
        for i in range(len(nums)):
            # deduplicate condition
            if i == 0 or nums[i - 1] != nums[i]:
                # Recursion down from kSum to 2Sum. Example:
                # [-2, -1, 0, 0, 1, 2]  target = 0, k = 4
                #  i   <--  3Sum  -->   target = 2, k = 3
                #  i  i+1  <- 2Sum ->   target = 3, k = 2 --> append([-2, -1, 1, 2])
                for set in kSum(nums[i + 1:], target - nums[i], k - 1):
                    res.append([nums[i]] + set)
        return res

    def twoSum(nums, target):
        # twoSum on sorted array using two pointers
        res = []
        i, j = 0, len(nums) - 1
        while i < j:
            s = nums[i] + nums[j]
            # if s is smaller than target, or duplicate, than move left pointer
            if s < target or (i > 0 and nums[i] == nums[i - 1]):
                i = i + 1
            # if s is larger than target, or duplicate, than move right pointer
            elif s > target or (j < 0 and nums[j] == nums[j + 1]):
                j = j - 1
            # if s is equal to target, append and move both pointers
            else:
                res.append([nums[i], nums[j]])
                i = i + 1
                j = j - 1
        return res

    nums.sort()
    return kSum(nums, target, 4)

# Method: Two pointers
# Time: O(n^(k-1)) for kSum
# Space: O(n)

# -----

# 19. Remove Nth Node From End of List **

# Given the head of a linked list, remove the nth node from the end of the list and return its head.

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def removeNthFromEnd(head, n):
    """
    :type head: ListNode
    :type n: int
    :rtype: ListNode
    """
    # use fast and slow pointer with a distance of n nodes
    dummy = ListNode(0)
    dummy.next = head
    fast = dummy
    slow = dummy
    for i in range(n+1):
        fast = fast.next
    while (fast != None):
        fast = fast.next
        slow = slow.next
    slow.next = slow.next.next
    return dummy.next

# Method: Linked List, two pointers
# Time: O(L) where L is length of the linked list
# Space: O(1)

# -----

# 20. Valid Parentheses *

# Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
# An input string is valid if:
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.

def isValid(s):
    stack = []
    mapping = {")": "(", "]": "[", "}": "{"}
    for c in s:
        # if it is a closing bracket
        if c in mapping:
            # if the stack is not empty then pop the top element of the stack
            # if the stack is empty then assign a dummy char
            top = stack.pop() if stack else '#'
            # return False if the top element is not the corresponding open bracket of c,
            # or c is a closing bracket when the stack is empty
            if mapping[c] != top:
                return False
        # if it is an opening bracket push c into the stack
        else:
            stack.append(c)
    # return True is the stack is empty at the end
    return not stack

# Method: Stack
# Time: O(n)
# Space:O(n)