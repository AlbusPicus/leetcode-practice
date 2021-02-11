/**
 * Runtime: 244 ms, faster than 89.71% of Kotlin online submissions for Merge Intervals.
 * Memory Usage: 38 MB, less than 95.47% of Kotlin online submissions for Merge Intervals.
 */
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        var currentStart = 0
        var currentEnd = Int.MIN_VALUE
        var resultsSize = 0
        intervals.forEach { interval ->
            if (interval[0] > currentEnd) {
                resultsSize++
                currentStart = interval[0]
            }
            currentEnd = Math.max(currentEnd, interval[1])
        }
        val result = Array<IntArray>(resultsSize) { IntArray(2) }
        var index = -1
        currentStart = 0
        currentEnd = Int.MIN_VALUE
        intervals.forEach { interval ->
            if (interval[0] > currentEnd) {
                index++
                currentStart = interval[0]
            }
            result[index][0] = currentStart
            currentEnd = Math.max(currentEnd, interval[1])
            result[index][1] = currentEnd
        }
        return result
    }
}
