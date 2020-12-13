/*
 * Runtime: 472 ms, faster than 9.09% of Kotlin online submissions for Contiguous Array.
 * Memory Usage: 45.5 MB, less than 36.36% of Kotlin online submissions for Contiguous Array.
 */

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        //Sum to first index
        val sumToIndexMap = mutableMapOf<Int, Int>()
        sumToIndexMap.put(0, -1)
        var sum = 0
        var maxLength = 0
        
        for (index in nums.indices) {
            sum += if (nums[index] == 0) -1 else 1
            
            if (sumToIndexMap.contains(sum)) {
                maxLength = Math.max(maxLength, index - sumToIndexMap.getValue(sum))
            } else {
                sumToIndexMap.put(sum, index)
            }
        }
        
        return maxLength
    }
    
}
