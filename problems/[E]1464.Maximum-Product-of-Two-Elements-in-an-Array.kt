/**
 * Runtime: 156 ms, faster than 100.00% of Kotlin online submissions for Maximum Product of Two Elements in an Array.
 * Memory Usage: 35.9 MB, less than 43.75% of Kotlin online submissions for Maximum Product of Two Elements in an Array.
 */

class Solution {
    
    fun maxProduct(nums: IntArray): Int {
        val maxNumbersQueue = PriorityQueue<Int>()
        maxNumbersQueue.offer(nums[0])
        maxNumbersQueue.offer(nums[1])
        
        for (index in 2 until nums.size) {
            maxNumbersQueue.offer(nums[index])
            maxNumbersQueue.poll()
        }
        
        return (maxNumbersQueue.poll() - 1) * (maxNumbersQueue.poll() - 1)
    }
    
}
