/**
 * Runtime: 252 ms, faster than 100.00% of Kotlin online submissions for Wiggle Sort II.
 * Memory Usage: 40.1 MB, less than 80.00% of Kotlin online submissions for Wiggle Sort II.
 */
class Solution {
    fun wiggleSort(nums: IntArray): Unit {
        nums.sort()
        val result = IntArray(nums.size)
        var leftIndex = 1
        var rightIndex = nums.size - 1
        while (leftIndex < nums.size) {
            result[leftIndex] = nums[rightIndex]
            rightIndex--
            leftIndex += 2
        }
        leftIndex = 0
        while (leftIndex < nums.size) {
            result[leftIndex] = nums[rightIndex]
            rightIndex--
            leftIndex = leftIndex + 2
        }
        for (i in 0 until nums.size) {
            nums[i] = result[i]
        }
    }
}
