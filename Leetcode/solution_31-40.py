# 31. Next Permutation **

# Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers
# If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order)
# The replacement must be in place and use only constant extra memory

def nextPermutation(nums):
    """
    :type nums: List[int]
    :rtype: None Do not return anything, modify nums in-place instead.
    """
    # find a pivot index such that nums[pivot-1] < num[pivot]
    # i.e. this is the first element counting from the end of the list that is non-ascending
    # if pivot is 0 meaning the list is descending, there is no larger permutation than the current
    pivot = len(nums) - 2
    while (pivot >= 0 and nums[pivot+1] <= nums[pivot]):
            pivot = pivot - 1
    
    # find the smallest element after pivot that is larger than the pivot element and swap
    if pivot >= 0:
        j = len(nums) - 1
        while (j >= 0 and nums[j] <= nums[pivot]):
            j = j - 1
        swap(nums, pivot, j)
    
    # if the entire list is descending, reverse the entire list
    # otherwise 
    reverse(nums, pivot+1)

# swap two elements in a list
def swap(nums, i, j):
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp

# reverse the end of the list starting from the element start   
def reverse(nums, start):
    i = start
    j = len(nums)-1
    while i < j:
        swap(nums, i, j)
        i = i + 1
        j = j - 1
        
# Method: Array
# Time: O(n)
# Space: O(1)

# -----



# -----

# 33. Search in Rotated Sorted Array **

# You are given an integer array nums sorted in ascending order, and an integer target.
# Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
# If target is found in the array return its index, otherwise, return -1.

def search(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    left, right = 0, len(nums)-1
    while left <= right:
        mid = left + (right - left) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] >= nums[left]: # pivot is mid or to the right of mid
            if target >= nums[left] and target < nums[mid]:
                right = mid - 1
            else:
                left = mid + 1
        else: # pivot is to the left of mid
            if target > nums[mid] and target <= nums[right]:
                left = mid + 1
            else:
                right = mid - 1
    return -1

# Method: Binary Search
# Time: O(logN)
# Space: O(1)

# -----

# 34. Find First and Last Position of Element in Sorted Array **

# Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
# If target is not found in the array, return [-1, -1].

def searchRange(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    result = [-1] * 2
    if nums == None or len(nums) == 0:
        return result
    left, right = 0, len(nums) - 1
    index = 0
    while left <= right:
        mid = left + (right - left) // 2
        if target == nums[mid]:
            index = mid
            break
        elif target < nums[mid]:
            right = mid - 1
        else:
            left = mid + 1
    p1 = p2 = index
    while p1 > -1 and nums[p1] == target:
        result[0] = p1
        p1 -= 1
    while p2 < len(nums) and nums[p2] == target:
        result[1] = p2
        p2 += 1
    return result

# Method: Binary Search
# Time: O(logN)
# Space: O(1)

# -----

# 35. Search Insert Position *

# Given a sorted array of distinct integers and a target value, return the index if the target is found. 
# If not, return the index where it would be if it were inserted in order.

def searchInsert(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    left = 0
    right = len(nums) - 1
    while left < right - 1:
        mid = left + (right - left) // 2
        if target == nums[mid]:
            return mid
        elif target < nums[mid]:
            right = mid
        else:
            left = mid
    if target <= nums[left]:
        return left
    elif target > nums[right]:
        return right + 1
    else: return left + 1
    
# Method: Binary Search
# Time: O(logN)
# Space: O(1)

# -----

# 36. Valid Sudoku **

# Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
# Each row must contain the digits 1-9 without repetition.
# Each column must contain the digits 1-9 without repetition.
# Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

def isValidSudoku(self, board):
    """
    :type board: List[List[str]]
    :rtype: bool
    """
    output = True
    row = [[] for i in range(9)]
    col = [[] for i in range(9)]
    grid = [[] for i in range(9)]
    for i in range(9):
        for j in range(9):
            value = board[i][j]
            igrid = j // 3 * 3 + i // 3
            if value != '.' and (value in row[i] or value in col[j] or value in grid[igrid]):
                output = False
                break
            elif value != '.':
                row[i].append(value)
                col[j].append(value)
                grid[igrid].append(value)
    return output

# Method: HashSet
# Time: O(1)
# Space: O(1)

# -----



# -----

# 38. Count and Say *

# The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
# countAndSay(1) = "1"
# countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), 
# which is then converted into a different digit string.
# To determine how you "say" a digit string, split it into the minimal number of groups 
# so that each group is a contiguous section all of the same character. 
# Then for each group, say the number of characters, then say the character. 
# To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
# Given a positive integer n, return the nth term of the count-and-say sequence.

def countAndSay(self, n):
    """
    :type n: int
    :rtype: str
    """
    # start with base case '1'
    return ''.join(self.nextSeq(n, ['1', 'E']))

def nextSeq(self, n, prevSeq):
    # if n == 1, return the subsequence of all but the last digit ('E')
    if n == 1:
        return prevSeq[:-1]
    # construct the next sequence from the previous sequence
    nextSeq = []
    prevDigit = prevSeq[0]
    count = 1
    for digit in prevSeq[1:]:
        if digit == prevDigit:
            count += 1
        else:
            nextSeq.extend([str(count), prevDigit])
            prevDigit = digit
            count = 1

    nextSeq.append('E')

    return self.nextSeq(n-1, nextSeq)

# Method: String
# Time: O(2^n)
# Space: O(2^(n-1))

# -----

# 39. Combination Sum **

# Given an array of distinct integers candidates and a target integer target, 
# return a list of all unique combinations of candidates where the chosen numbers sum to target. 
# You may return the combinations in any order.
# The same number may be chosen from candidates an unlimited number of times. 
# Two combinations are unique if the frequency of at least one of the chosen numbers is different.
# It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations 
# for the given input.

def combinationSum(self, candidates, target):
    """
    :type candidates: List[int]
    :type target: int
    :rtype: List[List[int]]
    """

    result = []

    def backtrack(remain, combination, start):
        # if remain = 0, append the combination as one of the solutions
        if remain == 0:
            result.append(list(combination))
        # if remain < 0, stop current exploration
        elif remain < 0:
            return
        for i in range(start, len(candidates)):
            # append the number into the combination
            combination.append(candidates[i])
            # give the current number another chance rather than moving on
            backtrack(remain - candidates[i], combination, i)
            # remove the number from the combination
            combination.pop()

    backtrack(target, [], 0)

    return result

# Method: DFS
# Time: O(N^(T/M+1)) where N is number of candidates, T is target value, and M is the min value among candidates
# Space: O(T/M)

# -----

# 40. Combination Sum II

# Given a collection of candidate numbers (candidates) and a target number (target), 
# find all unique combinations in candidates where the candidate numbers sum to target.
# Each number in candidates may only be used once in the combination.
# Note: The solution set must not contain duplicate combinations.

def combinationSum2(candidates, target):
    """
    :type candidates: List[int]
    :type target: int
    :rtype: List[List[int]]
    """
    result = []

    def backtrack(nums, start, path, result, remain):
        if remain == 0:
            result.append(path)
            return

        for i in range(start, len(nums)):
            # deduplicate
            if i > start and nums[i] == nums[i - 1]:
                continue

            if nums[i] > remain:
                break

            # i + 1 to start from the next number
            backtrack(nums, i + 1, path + [nums[i]], result, remain - nums[i])

    # sort candidates to more conveniently track duplicates
    backtrack(sorted(candidates), 0, [], result, target)

    return result

# Method: DFS
# Time: O(2^n)
# Space: O(kn)
