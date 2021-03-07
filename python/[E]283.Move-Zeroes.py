# Runtime: 40 ms, faster than 98.37% of Python3 online submissions for Move Zeroes.
# Memory Usage: 15.3 MB, less than 64.36% of Python3 online submissions for Move Zeroes.
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        index = len(nums) - 1
        zeroes = 0
        while index >= 0:
            if nums[index] == 0:
                del nums[index]
                zeroes += 1
            index -= 1
        for i in range(0, zeroes):
            nums.append(0)
        
