/**
 * Runtime: 240 ms, faster than 48.86% of Kotlin online submissions for Single Number.
 * Memory Usage: 38 MB, less than 62.50% of Kotlin online submissions for Single Number.
 */
class Solution {
    fun singleNumber(nums: IntArray): Int {
        var unpairedNumbers = mutableSetOf<Int>()
        nums.forEach { number ->
            if (number in unpairedNumbers) {
                unpairedNumbers.remove(number)
            } else {
                unpairedNumbers.add(number)
            }
        }
        return unpairedNumbers.first()
    }
}
