/**
 * Runtime: 184 ms, faster than 81.05% of Kotlin online submissions for Find the Duplicate Number.
 * Memory Usage: 36.9 MB, less than 73.68% of Kotlin online submissions for Find the Duplicate Number.
 */
class Solution {
    fun findDuplicate(nums: IntArray): Int {
        Arrays.sort(nums)
        var prevNumber = 0
        nums.forEach { number ->
            if (prevNumber == number) return number
            prevNumber = number
        }
        return -1
    }
}
