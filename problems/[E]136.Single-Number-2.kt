/**
 * Runtime: 208 ms, faster than 84.47% of Kotlin online submissions for Single Number.
 * Memory Usage: 36.8 MB, less than 97.73% of Kotlin online submissions for Single Number.
 */
class Solution {
    fun singleNumber(nums: IntArray): Int {
        var bitwise = 0
        nums.forEach { number ->
            bitwise = bitwise xor number
        }
        return bitwise
    }
}
