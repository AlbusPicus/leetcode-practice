/**
 * Runtime: 124 ms, faster than 82.76% of Kotlin online submissions for Reverse Bits.
 * Memory Usage: 31.9 MB, less than 89.66% of Kotlin online submissions for Reverse Bits.
 */
class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n:Int):Int {
        var number = n
        var bit = 0
        var result = 0
        for (i in 0 until 32) {
            bit = number and 1
            number = number shr 1
            result = (result shl 1) + bit
        }
        return result
    }
}
