/**
 * Runtime: 388 ms, faster than 50.00% of Kotlin online submissions for Jump Game V.
 * Memory Usage: 37.4 MB, less than 50.00% of Kotlin online submissions for Jump Game V.
 */

class Solution {
    fun maxJumps(arr: IntArray, d: Int): Int {
        var maxIndexesVisited = 0
        val memo = IntArray(arr.size)
        for (i in 0 until arr.size) {
            maxIndexesVisited = Math.max(maxIndexesVisited, getMaxmaxIndexesVisited(arr, i, d, memo))
        }
        return maxIndexesVisited
    }
    
    fun getMaxmaxIndexesVisited(heights: IntArray, startPosition: Int, maxDistance: Int, memo: IntArray): Int {    
        val savedJumps = memo[startPosition]
        if (savedJumps != 0) {
            return savedJumps
        }
        
        val currentHeight = heights[startPosition]
        val startIndex = Math.max(0, startPosition - maxDistance)
        val endIndex = Math.min(heights.size - 1, startPosition + maxDistance)
        var maxIndexesVisited = 1
        for (i in startIndex .. endIndex) {
            if (i != startPosition) {
                if (heights[i] < currentHeight) {
                    maxIndexesVisited = Math.max(maxIndexesVisited, getMaxmaxIndexesVisited(heights, i, maxDistance, memo) + 1)
                } else if (i < startPosition) {
                    maxIndexesVisited = 1
                } else {
                    break
                }
            }
        }
        
        memo[startPosition] = maxIndexesVisited
        return maxIndexesVisited
    }
}
