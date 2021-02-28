/**
 * Runtime: 164 ms, faster than 94.87% of Kotlin online submissions for Perfect Squares.
 * Memory Usage: 34.7 MB, less than 97.44% of Kotlin online submissions for Perfect Squares.
 */
class Solution {
    fun numSquares(n: Int): Int {
        if (n <= 3) return n

        val dp = IntArray(n + 1)
        for (i in 1 .. n) {
            dp[i] = i
            var j = 1
            while (j*j <= i) {
                val sqare = j * j
                dp[i] = Math.min(dp[i], dp[i - sqare] + 1)
                j++
            }
        }

        return dp[n]
    }
}
