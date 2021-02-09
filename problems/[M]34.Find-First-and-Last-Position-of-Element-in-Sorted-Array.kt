/**
 * Runtime: 188 ms, faster than 95.81% of Kotlin online submissions for Find First and Last Position of Element in Sorted Array.
 * Memory Usage: 39.4 MB, less than 73.65% of Kotlin online submissions for Find First and Last Position of Element in Sorted Array.
 */
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.size == 0) return NO_RESULT
        
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid
                right = mid
            }
        }
        return if (left == right && nums[left] == target) {
            var leftmostIndex = left
            var rightmostIndex = left
            while (leftmostIndex >= 0 && nums[leftmostIndex] == target) { leftmostIndex-- }
            while (rightmostIndex < nums.size && nums[rightmostIndex] == target) { rightmostIndex++ }
            leftmostIndex++
            rightmostIndex--
            intArrayOf(leftmostIndex, rightmostIndex)
        } else NO_RESULT

    }
    
    companion object {
        private val NO_RESULT = intArrayOf(-1, -1)
    }
}
