/**
 * Runtime: 220 ms, faster than 100.00% of Kotlin online submissions for Merge Intervals.
 * Memory Usage: 42.3 MB, less than 59.67% of Kotlin online submissions for Merge Intervals.
 */
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        var currentStart = intervals[0][0]
        var currentEnd = intervals[0][1]
        val result = mutableListOf<IntArray>()
        intervals.forEach { interval ->
            if (interval[0] > currentEnd) {
                result.add(intArrayOf(currentStart, currentEnd))
                currentStart = interval[0]
            }
            currentEnd = Math.max(currentEnd, interval[1])
        }
        if (result.isEmpty() || result.last()[1] < currentStart) {
            result.add(intArrayOf(currentStart, currentEnd))
        }
        return result.toTypedArray()
    }
}
