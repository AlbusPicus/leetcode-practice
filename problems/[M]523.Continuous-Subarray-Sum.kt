/**
 * Runtime: 228 ms, faster than 80.52% of Kotlin online submissions for Continuous Subarray Sum.
 * Memory Usage: 37.6 MB, less than 46.75% of Kotlin online submissions for Continuous Subarray Sum.
 */
class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val prefixSumFirstIndexMap = mutableMapOf<Int, Int>()
        prefixSumFirstIndexMap.put(0, -1)
        var sum = 0
        nums.forEachIndexed { index, num ->
            sum += num
            sum = if (k != 0) sum % k else sum
            if (prefixSumFirstIndexMap.containsKey(sum)) {
                val firstIndex = prefixSumFirstIndexMap.getValue(sum)
                if (index - firstIndex > 1) {
                    return true
                }
            } else {
                prefixSumFirstIndexMap.put(sum, index)
            }
        }
        return false
    }
    
}
