/**
 * Runtime: 1244 ms, faster than 32.58% of Kotlin online submissions for 3Sum.
 * Memory Usage: 45.9 MB, less than 96.88% of Kotlin online submissions for 3Sum.
 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for (i in 0 until nums.size) {
            val a = nums[i]
            if (i > 0 && a == nums[i - 1]) continue
            
            var bIndex = i + 1
            var cIndex = nums.size - 1
            while (bIndex < cIndex) {
                val sum = a + nums[bIndex] + nums[cIndex]
                if (sum < 0) {
                    bIndex++
                    continue
                }
                if (sum > 0) {
                    cIndex--
                    continue
                }
                
                val triplet = listOf(a, nums[bIndex], nums[cIndex])
                if (result.none { it == triplet }) {
                    result.add(triplet)
                }
                
                bIndex++
                while (bIndex < cIndex && nums[bIndex] == nums[bIndex - 1]) {
                    bIndex++
                }
                cIndex--
                while (cIndex > bIndex && nums[cIndex] == nums[cIndex + 1]) {
                    cIndex--
                }
            }
        }
        return result
    }
}
