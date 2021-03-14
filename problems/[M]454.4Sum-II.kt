/**
 * Runtime: 448 ms, faster than 85.53% of Kotlin online submissions for 4Sum II.
 * Memory Usage: 61.5 MB, less than 68.55% of Kotlin online submissions for 4Sum II.
 */
class Solution {
    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        val size = A.size
        
        val sumsMap = mutableMapOf<Int, Int>()
        for (i in 0 until size) {
            for (j in 0 until size) {
                val sum = A[i] + B[j]
                sumsMap[sum] = sumsMap.getOrDefault(sum, 0) + 1
            }
        }
        
        var result = 0
        for (i in 0 until size) {
            for (j in 0 until size) {
                val sum = C[i] + D[j]
                val sumCount = sumsMap.getOrDefault(-sum, 0)
                result += sumCount
            }
        }
        
        return result
    }
}
