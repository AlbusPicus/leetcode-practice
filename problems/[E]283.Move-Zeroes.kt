/**
 * Runtime: 188 ms, faster than 82.27% of Kotlin online submissions for Move Zeroes.
 * Memory Usage: 36.7 MB, less than 78.93% of Kotlin online submissions for Move Zeroes.
 */
class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var insertIndex = 0
        for (i in 0 until nums.size) {
            if (nums[i] != 0) {
                nums[insertIndex] = nums[i]
                insertIndex++
            }
        }
        for (i in insertIndex until nums.size) {
            nums[i] = 0
        }
    }
}
