/**
 * Runtime: 1256 ms, faster than 46.67% of Kotlin online submissions for Sliding Window Maximum.
 * Memory Usage: 59.3 MB, less than 28.00% of Kotlin online submissions for Sliding Window Maximum.
 */
class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray { 
        val result = IntArray(nums.size - k + 1)
        
        val numbers = sortedSetOf<Int>()
        val frequency = mutableMapOf<Int, Int>()
        
        for (i in 0 until k) {
            val number = nums[i]
            frequency[number] = frequency.getOrDefault(number, 0) + 1
            numbers.add(number)
        }
        
        var left = 0
        var right = k
        while (right < nums.size) {
            result[left] = numbers.last()
            val insertNumber = nums[right]
            frequency[insertNumber] = frequency.getOrDefault(insertNumber, 0) + 1
            numbers.add(insertNumber)
            
            val removalNumber = nums[left]
            val newFrequency = frequency.getOrDefault(removalNumber, 0) - 1
            frequency[removalNumber] = newFrequency
            if (newFrequency == 0) {
                numbers.remove(removalNumber)
            }
            
            left++
            right++
        }
        
        result[left] = numbers.last()
            
        return result
    }
}
