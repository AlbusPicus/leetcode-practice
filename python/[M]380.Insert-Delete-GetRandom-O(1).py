# Runtime: 92 ms, faster than 88.86% of Python3 online submissions for Insert Delete GetRandom O(1).
# Memory Usage: 18.5 MB, less than 61.36% of Python3 online submissions for Insert Delete GetRandom O(1).
class RandomizedSet:
    def __init__(self):
        self.itemsList = []
        self.valueIndexesMap = {}

    def insert(self, val: int) -> bool:
        if val in self.valueIndexesMap:
            return False
        
        self.valueIndexesMap[val] = len(self.itemsList)
        self.itemsList.append(val)
        
        return True

    def remove(self, val: int) -> bool:
        if val not in self.valueIndexesMap:
            return False
        
        idx, end = self.valueIndexesMap[val], len(self.itemsList)-1
        self.valueIndexesMap[self.itemsList[end]] = idx
        self.itemsList[end], self.itemsList[idx] = self.itemsList[idx], self.itemsList[end]
        self.itemsList.pop()
        del self.valueIndexesMap[val]
        
        return True
        
    def getRandom(self) -> int:
        return random.choice(self.itemsList)


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
