/**
 * Runtime: 172 ms, faster than 89.06% of Kotlin online submissions for Subsets.
 * Memory Usage: 35.7 MB, less than 93.75% of Kotlin online submissions for Subsets.
 */
class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        return subsets(nums, 0)
    }
    
    private fun subsets(nums: IntArray, from: Int): MutableList<List<Int>> {
        if (from == nums.size - 1) return mutableListOf(listOf(nums[from]), listOf<Int>())
        
        val number = nums[from]
        val deeperSubsets = subsets(nums, from + 1)
        val size = deeperSubsets.size
        for (i in 0 until size) {
            deeperSubsets.add(deeperSubsets[i] + number)
        }
        return deeperSubsets
    }
}
