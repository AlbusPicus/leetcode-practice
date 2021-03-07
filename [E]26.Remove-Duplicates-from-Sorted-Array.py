# Runtime: 80 ms, faster than 82.51% of Python3 online submissions for Remove Duplicates from Sorted Array.
# Memory Usage: 15.8 MB, less than 82.79% of Python3 online submissions for Remove Duplicates from Sorted Array.
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if not nums: 0
        else: 
            index = 1
            lastNum = nums[0]
            for number in nums:
                if number != lastNum:
                    lastNum = number
                    nums[index] = number
                    index += 1
            del nums[index:]
        
