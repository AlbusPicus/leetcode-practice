/**
 * Runtime: 272 ms, faster than 71.43% of Kotlin online submissions for Maximum Length of Pair Chain.
 * Memory Usage: 45 MB, less than 64.29% of Kotlin online submissions for Maximum Length of Pair Chain.
 */
class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        pairs.sortBy { it[1] }
        var currentPoint = Int.MIN_VALUE
        var currentCount = 0
        pairs.forEach { point ->
            if (currentPoint < point[0]) {
                currentPoint = point[1]
                currentCount++
            } 
        }
        
        return currentCount
    }
    
}
