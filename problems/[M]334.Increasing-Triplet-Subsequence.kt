/**
 * Runtime: 172 ms, faster than 70.54% of Kotlin online submissions for Increasing Triplet Subsequence.
 * Memory Usage: 36.6 MB, less than 90.70% of Kotlin online submissions for Increasing Triplet Subsequence.
 */
class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        var firstCandidate: Int = nums[0]
        var secondCandidate: Int? = null
        nums.forEach { num ->
            if (num > firstCandidate) {
                val second = secondCandidate
                if (second == null || num < second) {
                    secondCandidate = num
                } else if (num > second) {
                    return true
                }
            } else {
                firstCandidate = num
            }
        }
        return false
    }
}
