/**
 * Runtime: 2396 ms, faster than 5.71% of Kotlin online submissions for Jump Game.
 * Memory Usage: 48.1 MB, less than 5.71% of Kotlin online submissions for Jump Game.
 */
class Solution {
    fun canJump(nums: IntArray): Boolean {
        return canReachLastIndex(nums, 0, mutableSetOf())
    }
    
    private fun canReachLastIndex(nums: IntArray, position: Int, visitedIndexes: MutableSet<Int>): Boolean {
        if (position == nums.size - 1) return true
        if (position in visitedIndexes) return false
        
        visitedIndexes.add(position)
        val jumpsCount = Math.min(position + nums[position], nums.size - 1)
        for (i in jumpsCount downTo position + 1) {
            if (canReachLastIndex(nums, i, visitedIndexes)) {
                return true
            }
        }
        return false
    }
}
