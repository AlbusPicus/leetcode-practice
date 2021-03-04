/**
 * Runtime: 188 ms, faster than 62.42% of Kotlin online submissions for Coin Change.
 * Memory Usage: 34.9 MB, less than 94.63% of Kotlin online submissions for Coin Change.
 */
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        return getChange(coins, amount, IntArray(amount))
    }
    
    fun getChange(coins: IntArray, amount: Int, count: IntArray): Int {
        if (amount < 0) return -1
        if (amount == 0) return 0
        if (count[amount - 1] != 0) return count[amount - 1]
        
        var result: Int? = null
        coins.forEach { coin ->
            val localResult = getChange(coins, amount - coin, count)
            val prevResult = result
            if (localResult >= 0 && (prevResult == null || localResult < prevResult)) result = localResult + 1
        }
        count[amount - 1] = result ?: -1
        return count[amount - 1]
    }
    
}
