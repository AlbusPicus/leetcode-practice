/**
 * Runtime: 196 ms, faster than 98.69% of Kotlin online submissions for Missing Number.
 * Memory Usage: 37 MB, less than 85.62% of Kotlin online submissions for Missing Number.
 */
class Solution {
    fun missingNumber(nums: IntArray): Int {
        val numbersCount = nums.size
        var idealSum = 0
        for (i in 1 .. numbersCount) {
            idealSum += i
        }
        var sum = 0
        for (i in 0 until numbersCount) {
            sum += nums[i]
        }
        
        return idealSum - sum
    }
}
