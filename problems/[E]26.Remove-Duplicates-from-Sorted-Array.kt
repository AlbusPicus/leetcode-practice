/**
 * Runtime: 212 ms, faster than 83.18% of Kotlin online submissions for Remove Duplicates from Sorted Array.
 * Memory Usage: 37.1 MB, less than 97.00% of Kotlin online submissions for Remove Duplicates from Sorted Array.
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size == 0) return 0
        
        var index = 1
        var lastNum = nums[0]
        nums.forEach { num ->
            if (num != lastNum) {
                nums[index] = num
                
                lastNum = num
                index++
            }
        }
        return index
    }
}
