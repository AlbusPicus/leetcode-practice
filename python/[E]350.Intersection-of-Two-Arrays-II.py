# Runtime: 44 ms, faster than 86.25% of Python3 online submissions for Intersection of Two Arrays II.
# Memory Usage: 14.3 MB, less than 90.41% of Python3 online submissions for Intersection of Two Arrays II.
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        intCount = {}
        for number in nums1:
            intCount[number] = intCount.get(number, 0) + 1
        result = []
        for number in nums2:
            if intCount.get(number, 0) > 0:
                intCount[number] = intCount[number] - 1
                result.append(number)
        return result
