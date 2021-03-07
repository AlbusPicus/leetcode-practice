# Runtime: 44 ms, faster than 86.25% of Python3 online submissions for Intersection of Two Arrays II.
# Memory Usage: 14.3 MB, less than 90.41% of Python3 online submissions for Intersection of Two Arrays II.
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        nums1.sort()
        nums2.sort()
        firstPointer, secondPointer = 0, 0
        result = []
        while firstPointer < len(nums1) and secondPointer < len(nums2):
            first = nums1[firstPointer]
            second = nums2[secondPointer]
            if first == second:
                result.append(first)
                firstPointer += 1
                secondPointer += 1
            elif first > second:
                secondPointer += 1
            else:
                firstPointer += 1
        
        return result
