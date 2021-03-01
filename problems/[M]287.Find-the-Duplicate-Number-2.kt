/**
 * Runtime: 172 ms, faster than 94.74% of Kotlin online submissions for Find the Duplicate Number.
 * Memory Usage: 36.4 MB, less than 86.32% of Kotlin online submissions for Find the Duplicate Number.
 */
class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for (i in 0 until nums.size) {
            var currentPos = i 
            var positionToFill = nums[currentPos]
            while (positionToFill != currentPos) { 
                currentPos = positionToFill
                if (nums[positionToFill] != positionToFill) {
                    val temp = positionToFill
                    positionToFill = nums[positionToFill]
                    nums[temp] = temp
                } else {
                    return positionToFill
                }
            }
        }
        return -1
    }
}
