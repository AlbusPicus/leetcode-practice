/**
 * Runtime: 168 ms, faster than 44.30% of Kotlin online submissions for First Missing Positive.
 * Memory Usage: 35.8 MB, less than 43.04% of Kotlin online submissions for First Missing Positive.
 */
class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        nums.sort()
        var lookingFor = 1
        for (i in 0 until nums.size) {
            val number = nums[i]
            if (number > lookingFor) {
                return lookingFor
            } else if (number > 0) {
                lookingFor = number + 1
            }
        }
        return lookingFor
    }
}
