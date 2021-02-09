/**
 * Runtime: 164 ms, faster than 87.78% of Kotlin online submissions for Search in Rotated Sorted Array.
 * Memory Usage: 35.4 MB, less than 78.89% of Kotlin online submissions for Search in Rotated Sorted Array.
 */
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val size = nums.size
        if (size == 0) return -1
        if (size == 1) {
            return if (nums[0] == target) 0 else -1
        }
        
        var left = 0
        var right = size - 1
        if (nums[right] < nums[left]) {
            val rightmostValue = nums[right]
            while (left < right) {
                var mid = left + (right - left + 1) / 2
                if (nums[mid] > rightmostValue) {
                    left = mid
                } else {
                    right = mid - 1
                }
            }
            val pivot = left
            if (nums[size - 1] < target) {
                left = 0
                right = pivot
            } else {
                left = pivot + 1
                right = size - 1
            }
        }
        
        while (left < right) {
            var mid = left + (right - left + 1) / 2
            if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid
            }
        }
        return if (nums[right] == target) left else -1
    }
}
