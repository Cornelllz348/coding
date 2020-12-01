class TwoSum(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = {}

    def add(self, number):
        """
        Add the number to an internal data structure..
        :type number: int
        :rtype: None
        """
        if number in self.hashmap:
            self.hashmap[number] += 1
        else:
            self.hashmap[number] = 1

    def find(self, value):
        """
        Find if there exists any pair of numbers which sum is equal to the value.
        :type value: int
        :rtype: bool
        """
        for num in self.hashmap.keys():
            diff = value - num
            if diff != num:
                if diff in self.hashmap:
                    return True
            elif self.hashmap[num] > 1:
                return True
        return False


# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)