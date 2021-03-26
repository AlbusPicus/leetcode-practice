/**
 * Runtime: 168 ms, faster than 100.00% of Kotlin online submissions for Longest Consecutive Sequence.
 * Memory Usage: 36.3 MB, less than 78.18% of Kotlin online submissions for Longest Consecutive Sequence.
 */
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.size == 0) return 0
        
        nums.sort()
        var longestConsecutive = 1
        var currentConsecutive = 1
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) continue
            
            if (nums[i] == nums[i - 1] + 1) {
                currentConsecutive++
            } else {
                longestConsecutive = Math.max(longestConsecutive, currentConsecutive)
                currentConsecutive = 1
            }
        }
        return Math.max(longestConsecutive, currentConsecutive)
    }
}
