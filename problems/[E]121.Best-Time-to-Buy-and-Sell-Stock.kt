/**
 * Runtime: 504 ms, faster than 50.14% of Kotlin online submissions for Best Time to Buy and Sell Stock.
 * Memory Usage: 57 MB, less than 40.17% of Kotlin online submissions for Best Time to Buy and Sell Stock.
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        
        prices.forEach { price ->
            if (price < minPrice) {
                minPrice = price
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice
            }   
        }
        
        return maxProfit
    }
}
