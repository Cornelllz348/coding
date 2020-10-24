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
