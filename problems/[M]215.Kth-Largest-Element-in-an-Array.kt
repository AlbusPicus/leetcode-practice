/**
 * Runtime: 200 ms, faster than 85.46% of Kotlin online submissions for Kth Largest Element in an Array.
 * Memory Usage: 36.9 MB, less than 58.51% of Kotlin online submissions for Kth Largest Element in an Array.
 */
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sortDescending()
        return nums[k - 1]
    }
}
