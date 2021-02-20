/**
 * Runtime: 148 ms, faster than 52.99% of Kotlin online submissions for House Robber.
 * Memory Usage: 35.8 MB, less than 7.69% of Kotlin online submissions for House Robber.
 */
class Solution {
    fun rob(nums: IntArray): Int {
        return if (nums.size == 0) {
            0
        } else {
            val memo = mutableMapOf<Int, Int>(
                nums.lastIndex to nums[nums.lastIndex]
            )
            maxPrize(nums, 0, memo)
        }
    }
    
    private fun maxPrize(nums: IntArray, start: Int, memo: MutableMap<Int, Int>): Int {
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
