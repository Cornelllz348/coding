# 252. Meeting Rooms I *

# Given an array of meeting time intervals where intervals[i] = [starti, endi], 
# determine if a person could attend all meetings.

def canAttendMeetings(intervals):
    """
    :type intervals: List[List[int]]
    :rtype: bool
    """
    result = True
    if len(intervals) == 0:
        return result
    time = [False] * (10**6+1)
    for i in intervals:
        start = i[0]
        end = i[1]
        for j in range(start, end):
            if time[j] == True:
                return False
            else:
                time[j] = True
    return result

# Method: Brute Force
# Time: O(n^2)
# Space: O(1)

# -----

# 1510. Stone Game IV ***

# Alice and Bob take turns playing a game, with Alice starting first.
# Initially, there are n stones in a pile.  On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.
# Also, if a player cannot make a move, he/she loses the game.
# Given a positive integer n. Return True if and only if Alice wins the game otherwise return False, assuming both players play optimally.

def winnerSquareGame(self, n):
    """
    :type n: int
    :rtype: bool
    """
    dp = [False] * (n+1)
    for i in range(1, n+1):
        for k in range(1, int(i**0.5)+1):
            if dp[i-k*k] == False:
                dp[i] = True
                break
    return dp[n]
    
# Method: DP
# Time: O(n*sqrt(n))
# Space: O(n)
