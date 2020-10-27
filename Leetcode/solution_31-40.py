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


