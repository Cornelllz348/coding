	
# In this problem we are using a 24-hour clock. The clock shows time in hours and minutes, 
# from 00:00 (midnight) to 23:59 (one minute before the next midnight). These times are given as Strings. 
# Each time always has the form "HH:MM", using leading zeros if needed.
# The ACME company claims they are open all hours. You would like to verify whether their claim is true.
# The company has N branches all over the town. The branches are numbered from 0 to N-1. 
# Each branch has its own opening and closing hours. More precisely, each day branch i opens in the moment when a 24-hour clock starts showing the time openingTime[i], 
# and closes in the moment when the clock starts showing the time closingTime[i]. (It is guaranteed that for each branch its opening time is different from its closing time.)
# If the ACME company indeed has at least one branch open during every minute of the day, return "correct". 
# Otherwise, return "incorrect". (Quotes for clarity only. Note that the return value is case-sensitive.)

import math,string,itertools,fractions,heapq,collections,re,array,bisect

class OpenAllHours:
    def verify(self, N, openingTime, closingTime):
        listopen = [False] * (24*60)
        result = "correct"
        for i in range(N):
            stropen, strclose = openingTime[i], closingTime[i]
            h, m = map(int, stropen.split(":"))
            timeopen = h * 60 + m
            h, m = map(int, strclose.split(":"))
            timeclose = h * 60 + m
            if timeopen > timeclose:
                for i in range(timeopen, 24*60):
                    listopen[i] = True
                for i in range(0, timeclose):
                    listopen[i] = True
            else:
                for i in range(timeopen, timeclose):
                    listopen[i] = True
        for i in range(24*60):
            if listopen[i] == False:
                result = "incorrect"
                break
        return result
