/**
 * Runtime: 160 ms, faster than 94.44% of Kotlin online submissions for Search in Rotated Sorted Array.
 * Memory Usage: 35 MB, less than 98.89% of Kotlin online submissions for Search in Rotated Sorted Array.
 */
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        nums.forEachIndexed { index, number ->
            if (number == target) return index
        }
        return -1
    }
}
