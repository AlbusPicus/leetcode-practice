/**
 * Runtime: 1600 ms, faster than 21.53% of Kotlin online submissions for 3Sum.
 * Memory Usage: 51.1 MB, less than 35.69% of Kotlin online submissions for 3Sum.
 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val occurancesMap = mutableMapOf<Int, MutableSet<Int>>()
        nums.forEachIndexed { index, num ->
            val occurances = occurancesMap.getOrElse(num, { mutableSetOf<Int>() })
            occurances.add(index)
            occurancesMap.put(num, occurances)
        }
        val result = mutableListOf<List<Int>>()
        var lastA = if (nums.isNotEmpty()) nums[0] - 1 else 0
        for (i in 0 until nums.size) {
            val a = nums[i]
            if (a == lastA) continue
            lastA = a
            var lastB = if (i < nums.size - 1) nums[i + 1] - 1 else 0
            for (j in i + 1 until nums.size) {
                val b = nums[j]
                if (b == lastB) continue
                lastB = b
                val c = -(a + b)
                val freeToUse = occurancesMap[c]?.any { it != i && it != j && it > j } ?: false
                if (freeToUse) {
                    val triplet = listOf(a, b, c)
                    if (result.none { it == triplet }) {
                        result.add(triplet)
                    }
                }
            }
        }
        return result
    }
}
