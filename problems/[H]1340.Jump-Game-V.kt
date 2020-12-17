/**
 * Runtime: 808 ms, faster than 50.00% of Kotlin online submissions for Jump Game V.
 * Memory Usage: 71.8 MB, less than 50.00% of Kotlin online submissions for Jump Game V.
 */

class Solution {
    fun maxJumps(arr: IntArray, d: Int): Int {
        var maxJumps = 0
        val memo = mutableMapOf<Int, Int>()
        for (i in 0 until arr.size) {
            maxJumps = Math.max(maxJumps, getMaxJumpsCount(arr, i, d, memo))
        }
        return maxJumps + 1
    }
    
    fun getMaxJumpsCount(heights: IntArray, startPosition: Int, maxDistance: Int, memo: MutableMap<Int, Int>): Int {    
        val savedJumps = memo.get(startPosition)
        if (savedJumps != null) {
            return savedJumps
        }
        
        val currentHeight = heights[startPosition]
        val startIndex = Math.max(0, startPosition - maxDistance)
        val endIndex = Math.min(heights.size - 1, startPosition + maxDistance)
        var maxJumps = 0
        for (i in startIndex .. endIndex) {
            if (i != startPosition) {
                if (heights[i] < currentHeight) {
                    maxJumps = Math.max(maxJumps, getMaxJumpsCount(heights, i, maxDistance, memo) + 1)
                } else if (i < startPosition) {
                    maxJumps = 0
                } else {
                    break
                }
            }
        }
        
        memo.put(startPosition, maxJumps)
        return maxJumps
    }
}
