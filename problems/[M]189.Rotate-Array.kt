/**
 * Runtime: 180 ms, faster than 89.76% of Kotlin online submissions for Rotate Array.
 * Memory Usage: 36.5 MB, less than 61.95% of Kotlin online submissions for Rotate Array.
 */
class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val totalRotation = k % nums.size
        val result = IntArray(nums.size)
        var index = 0
        for (i in totalRotation until nums.size) {
            result[i] = nums[index]
            index ++
        }
        for (i in 0 until totalRotation) {
            result[i] = nums[index]
            index ++
        }
        for (i in 0 until nums.size) {
            nums[i] = result[i]
        }
    }
}
