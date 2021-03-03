/**
 * Runtime: 272 ms, faster than 63.64% of Kotlin online submissions for Longest Increasing Subsequence.
 * Memory Usage: 36.1 MB, less than 98.70% of Kotlin online submissions for Longest Increasing Subsequence.
 */
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        
        val lengths = IntArray(nums.size)
        for (i in 0 until nums.size) {
            val number = nums[i]
            for (j in i - 1 downTo 0) {
                if (number > nums[j]) {
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1)
                }
            }
        }
        var maxLength = 0
        for (i in 0 until lengths.size) {
            maxLength = Math.max(maxLength, lengths[i])
        }
        return maxLength + 1
    }
}
