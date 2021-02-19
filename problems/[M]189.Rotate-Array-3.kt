/**
 * Runtime: 180 ms, faster than 89.76% of Kotlin online submissions for Rotate Array.
 * Memory Usage: 35.9 MB, less than 81.95% of Kotlin online submissions for Rotate Array.
 */
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val totalRotation = k % nums.size
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, totalRotation - 1)
        reverse(nums, totalRotation, nums.size - 1)
    }
    
    private fun reverse(nums: IntArray, from: Int, to: Int) {
        var start = from
        var end = to
        while (start < end) {
            val temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            
            start++
            end--
        }
    }
}
