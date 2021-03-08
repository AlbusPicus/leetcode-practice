/**
 * Runtime: 964 ms, faster than 44.13% of Swift online submissions for Best Time to Buy and Sell Stock.
 * Memory Usage: 17.5 MB, less than 58.54% of Swift online submissions for Best Time to Buy and Sell Stock.
 */
class Solution {
    func maxProfit(_ prices: [Int]) -> Int {
        var smallestPrice = Int.max
        var profit = 0
        for price in prices {
            if price < smallestPrice {
                smallestPrice = price
            }
            profit = max(profit, price - smallestPrice)
        }
        return profit
    }
}
