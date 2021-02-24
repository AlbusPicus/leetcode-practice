/**
 * Runtime: 176 ms, faster than 99.65% of Kotlin online submissions for Kth Largest Element in an Array.
 * Memory Usage: 36 MB, less than 85.46% of Kotlin online submissions for Kth Largest Element in an Array.
 */
class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val heap = PriorityQueue<Int>()
        nums.forEach { number ->
            heap.offer(number)
            if (heap.size > k) heap.poll()
        }
        return heap.poll()
    }
}
