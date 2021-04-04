/**
 * Runtime: 132 ms, faster than 80.95% of Kotlin online submissions for Factorial Trailing Zeroes.
 * Memory Usage: 32.9 MB, less than 97.62% of Kotlin online submissions for Factorial Trailing Zeroes.
 */
class Solution {
    fun trailingZeroes(n: Int): Int {
        if (n == 0) return 0
        var base = 5
        var zeroes = 0
        while (n / base >= 1) {
            zeroes += n / base
            base *= 5
        }
        return zeroes
    }
}
