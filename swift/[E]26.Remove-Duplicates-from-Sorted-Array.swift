/**
 * Runtime: 64 ms, faster than 79.22% of Swift online submissions for Remove Duplicates from Sorted Array.
 * Memory Usage: 14.9 MB, less than 48.16% of Swift online submissions for Remove Duplicates from Sorted Array.
 */
class Solution {
    func removeDuplicates(_ nums: inout [Int]) -> Int {
        if (nums.count == 0) {
            return 0
        }
        
        var lastNumber = nums[0]
        var index = 1
        for number in nums {
            if (lastNumber != number) {
                lastNumber = number
                nums[index] = number
                index += 1
            }
        }
        return index
    }
}
