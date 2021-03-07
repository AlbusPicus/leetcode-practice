/**
 * Runtime: 124 ms, faster than 100.00% of Swift online submissions for Missing Number.
 * Memory Usage: 14.2 MB, less than 75.99% of Swift online submissions for Missing Number.
 */
class Solution {
    func missingNumber(_ nums: [Int]) -> Int {
        var expectedSum = nums.count
        var totalSum = 0
        for i in 0...(nums.count - 1) {
            expectedSum += i
            totalSum += nums[i]
        }
        return expectedSum - totalSum
    }
}
