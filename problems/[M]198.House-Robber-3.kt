/**
 * Runtime: 140 ms, faster than 73.50% of Kotlin online submissions for House Robber.
 * Memory Usage: 35.5 MB, less than 14.53% of Kotlin online submissions for House Robber.
 */
class Solution {
    fun rob(nums: IntArray): Int {
        return if (nums.size == 0) {
            0
        } else if (nums.size == 1) {
            nums[0]
        } else {
            nums[1] = Math.max(nums[0], nums[1])
            for (i in 2 until nums.size) {
                nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1])
            }
            nums[nums.lastIndex]
        }
    }
    
}
