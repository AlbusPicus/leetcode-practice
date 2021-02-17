/**
 * Runtime: 172 ms, faster than 71.70% of Kotlin online submissions for Find Peak Element.
 * Memory Usage: 37.3 MB, less than 31.13% of Kotlin online submissions for Find Peak Element.
 */
class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var prevElement = Int.MIN_VALUE
        for (i in 0 until nums.size - 1) {
            val number = nums[i]
            if (prevElement < number && number > nums[i + 1]) return i
            prevElement = number
        }
        return nums.lastIndex
    }
}
