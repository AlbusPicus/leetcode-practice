/**
 * Runtime: 140 ms, faster than 73.50% of Kotlin online submissions for House Robber.
 * Memory Usage: 35.5 MB, less than 22.22% of Kotlin online submissions for House Robber.
 */
class Solution {
    fun rob(nums: IntArray): Int {
        return if (nums.size == 0) {
            0
        } else {
            val memo = Array<Int?>(nums.size) { null }
            memo[memo.lastIndex] = nums[nums.lastIndex]
            maxPrize(nums, 0, memo)
        }
    }
    
    private fun maxPrize(nums: IntArray, start: Int, memo: Array<Int?>): Int {
        val size = nums.size
        if (start >= size) return 0
        
        val savedValue = memo[start]
        return if (savedValue != null) {
            savedValue
        } else {
            val robCurrent = nums[start] + maxPrize(nums, start + 2, memo)
            val skipCurrent = maxPrize(nums, start + 1, memo)
            val result = Math.max(robCurrent, skipCurrent)
            memo[start] = result
            result
        }
    }
}
