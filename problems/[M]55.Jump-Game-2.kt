/**
 * Runtime: 164 ms, faster than 100.00% of Kotlin online submissions for Jump Game.
 * Memory Usage: 36.5 MB, less than 90.48% of Kotlin online submissions for Jump Game.
 */
class Solution {
    fun canJump(nums: IntArray): Boolean {
        var zeroesCount = 0
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] == 0 || nums[i] <= zeroesCount) {
                zeroesCount++
            } else {
                zeroesCount = 0
            }
        }
        return zeroesCount == 0
    }
    
}
