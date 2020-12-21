
/**
 * Runtime: 164 ms, faster than 98.92% of Kotlin online submissions for Two Sum.
 * Memory Usage: 36.9 MB, less than 56.61% of Kotlin online submissions for Two Sum.
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numsSize = nums.size
        val addendNumbersSet = HashSet<Int>(numsSize)
        var secondNumberIndex: Int = -1
        var secondNumber: Int = -1
        for (i in 0 until numsSize) {
            if (nums[i] !in addendNumbersSet) {
                addendNumbersSet.add(target - nums[i])
            } else {
                secondNumberIndex = i
                secondNumber = nums[i]
                break
            }
        }
        val firstNumber = target - secondNumber
        var firstNumberIndex = target - secondNumber
        for (i in 0 .. secondNumberIndex) {
            if (nums[i] == firstNumber) {
                firstNumberIndex = i
                break
            }
        }
        return intArrayOf(firstNumberIndex, secondNumberIndex)
    }
}
