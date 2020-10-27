

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


