/**
 * Runtime: 160 ms, faster than 95.83% of Kotlin online submissions for Maximum Product Subarray.
 * Memory Usage: 35.5 MB, less than 65.28% of Kotlin online submissions for Maximum Product Subarray.
 */
class Solution {
    fun maxProduct(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        
        var result = 0
        var currentMin = 1 
        var currentMax = 1
        
        nums.forEach { number ->
            val temp = currentMax * number
            currentMax = Math.max(temp, number * currentMin)
            currentMax = Math.max(currentMax, number)
            currentMin = Math.min(temp, number * currentMin)
            currentMin = Math.min(currentMin, number)
            result = Math.max(result, currentMax)
        }
        return result
    }
}
