/**
 * Runtime: 116 ms, faster than 96.88% of Kotlin online submissions for XOR Operation in an Array.
 * Memory Usage: 32.7 MB, less than 62.50% of Kotlin online submissions for XOR Operation in an Array.
 */
class Solution {
    fun xorOperation(n: Int, start: Int): Int {
        var result = 0
        for (i in 0 until n) {
            result = result xor (start + 2*i)
        }
        return result
    }
}
