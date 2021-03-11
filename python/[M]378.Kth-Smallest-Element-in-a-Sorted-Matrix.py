import heapq

# Runtime: 176 ms, faster than 75.94% of Python3 online submissions for Kth Smallest Element in a Sorted Matrix.
# Memory Usage: 20 MB, less than 93.93% of Python3 online submissions for Kth Smallest Element in a Sorted Matrix.
class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        heap = []
        
        for row in matrix:
            for element in row:
                heappush(heap, -element)
                if len(heap) > k:
                    heappop(heap)
        
        return -heappop(heap)
        
