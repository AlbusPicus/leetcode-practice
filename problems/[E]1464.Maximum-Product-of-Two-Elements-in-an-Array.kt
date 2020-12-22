/**
 * Runtime: 164 ms, faster than 90.63% of Kotlin online submissions for Maximum Product of Two Elements in an Array.
 * Memory Usage: 37.1 MB, less than 15.63% of Kotlin online submissions for Maximum Product of Two Elements in an Array.
 */

class Solution {
    fun maxProduct(nums: IntArray): Int {
        val maxNumbersQueue = PriorityQueue<Int>()
        nums.forEach { number ->
            maxNumbersQueue.offer(number)
            if (maxNumbersQueue.size > 2) {
                maxNumbersQueue.poll()
            }
        }
        return (maxNumbersQueue.poll() - 1) * (maxNumbersQueue.poll() - 1)
    }
}
