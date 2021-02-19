/**
 * Runtime: 332 ms, faster than 22.44% of Kotlin online submissions for Rotate Array.
 * Memory Usage: 37.1 MB, less than 45.37% of Kotlin online submissions for Rotate Array.
 */
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val totalRotation = k % nums.size
        for (shiftNumber in 0 until totalRotation) {
            var lastNumber = nums[nums.size - 1]
            for (i in 0 until nums.size) {
                val temp = nums[i]
                nums[i] = lastNumber
                lastNumber = temp
            }
        }
    }
}
