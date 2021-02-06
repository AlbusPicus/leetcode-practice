/**
 * Runtime: 224 ms, faster than 80.80% of Kotlin online submissions for Majority Element.
 * Memory Usage: 41.7 MB, less than 85.60% of Kotlin online submissions for Majority Element.
 */
class Solution {
    fun majorityElement(nums: IntArray): Int {
        val elementsCountMap = mutableMapOf<Int, Int>()
        var bestElementCount = 0
        var bestElement = nums[0]
        
        nums.forEach { number -> 
            val currentCount = elementsCountMap.getOrElse(number, { 0 }) + 1
            elementsCountMap.put(number, currentCount)
            if (bestElement == number) {
                bestElementCount++
            } else if (bestElementCount < currentCount) {
                bestElementCount = currentCount
                bestElement = number
            }
        }
        return bestElement
    }
}
