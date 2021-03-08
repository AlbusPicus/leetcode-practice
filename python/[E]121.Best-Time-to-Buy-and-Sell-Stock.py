# Runtime: 984 ms, faster than 48.99% of Python3 online submissions for Best Time to Buy and Sell Stock.
# Memory Usage: 25.1 MB, less than 53.01% of Python3 online submissions for Best Time to Buy and Sell Stock.
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        smallestPrice = prices[0]
        profit = 0
        for price in prices:
            if price < smallestPrice:
                smallestPrice = price
            profit = max(profit, price - smallestPrice)
        return profit
