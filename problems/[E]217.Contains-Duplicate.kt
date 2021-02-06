/**
 * Runtime: 228 ms, faster than 91.78% of Kotlin online submissions for Contains Duplicate.
 * Memory Usage: 42.4 MB, less than 66.21% of Kotlin online submissions for Contains Duplicate.
 */
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        // 1 - O(n) time with O(n) space [set]
        // 2 - O(n*log(n)) time with O(1) space [sorting]
        
        return containsDuplicateStoring(nums)
    }
    
    fun containsDuplicateSorting(nums: IntArray): Boolean {
        if (nums.size == 0) return false
        
        nums.sort()
        var currentNumber = nums[0] - 1
        nums.forEach { number -> 
            if (number == currentNumber) return true
            currentNumber = number
        }
        return false
    }
    
    fun containsDuplicateStoring(nums: IntArray): Boolean {
        val numbersSet = mutableSetOf<Int>()
        
        nums.forEach { number -> 
            if (number in numbersSet) return true
            numbersSet.add(number)
        }
        return false
    }
}
