/**
 * Runtime: 112 ms, faster than 96.67% of Kotlin online submissions for Sum of Two Integers.
 * Memory Usage: 32.2 MB, less than 96.67% of Kotlin online submissions for Sum of Two Integers.
 */
class Solution {
    fun getSum(a: Int, b: Int): Int {
        var additionValue = b
        var result = a
        while (additionValue != 0) {
            val carry = result and additionValue
            result = result xor additionValue
            additionValue = carry shl 1 
        }
        return result
    }
}
