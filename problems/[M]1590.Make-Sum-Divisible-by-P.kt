/**
 * Runtime: 520 ms, faster than 80.00% of Kotlin online submissions for Make Sum Divisible by P.
 * Memory Usage: 60.4 MB, less than 60.00% of Kotlin online submissions for Make Sum Divisible by P.
 */

class Solution {
    fun minSubarray(nums: IntArray, p: Int): Int {
        var overallRemainder = 0
        for (i in 0 until nums.size) {
            overallRemainder = (overallRemainder + nums[i]) % p
        }
        
        if (overallRemainder == 0) {
            return 0
        }
        
        val remaindersIndexesMap = mutableMapOf<Int, Int>()
        remaindersIndexesMap.put(0, -1)
        var remainder = 0
        var minDistance = nums.size
        var cumulativeSum = 0
        for (i in 0 until nums.size) {
            cumulativeSum = (cumulativeSum + nums[i]) % p
            remainder = (cumulativeSum - overallRemainder + p) % p
            val index = remaindersIndexesMap.get(remainder)
            if (index != null) {
                val distance = Math.abs(i - index)
                if (distance < minDistance) {
                    minDistance = distance
                }
            }
            remaindersIndexesMap.put(cumulativeSum, i)
        }
        return if (minDistance == nums.size) -1 else minDistance
    }
}
