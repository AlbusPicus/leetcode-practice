/**
 * Runtime: 36 ms, faster than 94.81% of Swift online submissions for Move Zeroes.
 * Memory Usage: 14.6 MB, less than 95.64% of Swift online submissions for Move Zeroes.
 */
class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        var index = nums.count - 1
        var zeroes = 0
        while index >= 0 {
            if nums[index] == 0 {
                nums.remove(at: index)
                zeroes += 1
            }
            index -= 1
        }
        index = 0
        while index < zeroes {
            nums.append(0)
            index += 1
        }
    }
}
