/**
 * Runtime: 136 ms, faster than 92.37% of Kotlin online submissions for Number of 1 Bits.
 * Memory Usage: 33.1 MB, less than 73.31% of Kotlin online submissions for Number of 1 Bits.
 */
class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n:Int):Int {
        var number = n
        var bitsCount = 0
        for (i in 0 until 32) {
            if (number and 1 == 1) bitsCount++
            number = number shr 1
        }
        return bitsCount
    }
}
