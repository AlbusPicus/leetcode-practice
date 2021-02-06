/**
 * Runtime: 176 ms, faster than 82.74% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
 * Memory Usage: 35.2 MB, less than 93.45% of Kotlin online submissions for Best Time to Buy and Sell Stock II.
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = -prices[0]
        var currentSell = prices[0]
        prices.forEach { price ->
            if (price > currentSell) currentSell = price
            if (price < currentSell) {
                maxProfit += currentSell
                maxProfit -= price
                currentSell = price
            }
        }
        maxProfit += currentSell
        return maxProfit
    }
}
