/**
 * Runtime: 128 ms, faster than 58.08% of Kotlin online submissions for Climbing Stairs.
 * Memory Usage: 32.8 MB, less than 43.64% of Kotlin online submissions for Climbing Stairs.
 */
class Solution {
    fun climbStairs(n: Int): Int {
        return fibonacci(n, mutableMapOf(0 to 1, 1 to 1))
    }
    
    private fun fibonacci(n: Int, memo: MutableMap<Int, Int>): Int {
        val savedValue = memo.get(n)
        
        return if (savedValue != null) {
            savedValue
        } else {
            val result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo)
            memo[n] = result
            result
        }
    }
}
