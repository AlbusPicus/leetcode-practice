/**
 * Runtime: 120 ms, faster than 84.19% of Kotlin online submissions for Climbing Stairs.
 * Memory Usage: 33.2 MB, less than 32.65% of Kotlin online submissions for Climbing Stairs.
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
