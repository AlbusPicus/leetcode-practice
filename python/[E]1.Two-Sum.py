# Runtime: 44 ms, faster than 85.74% of Python3 online submissions for Two Sum.
# Memory Usage: 14.2 MB, less than 98.60% of Python3 online submissions for Two Sum.
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        adds = {}
        for i in range(len(nums)):
            number = nums[i]
            add = target - number
            if add in adds:
                return [adds.get(add), i]
            else:
                adds[number] = i
        return []
        
