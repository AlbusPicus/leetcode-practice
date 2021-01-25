/**
 * Runtime: 184 ms, faster than 100.00% of Kotlin online submissions for H-Index II.
 * Memory Usage: 41.8 MB, less than 100.00% of Kotlin online submissions for H-Index II.
 */
class Solution {
    fun hIndex(citations: IntArray): Int {
        val size = citations.size
        var h = 0
        if (size > 0) {
            var start = 0
            var end = size - 1
            var mid = 0
            var temp = 0
            while (start <= end) {
                mid = (start + end) / 2
                temp = size - mid
                if (citations[mid] == temp) {
                    return temp
                } else if (citations[mid] > temp) {
                    end = mid - 1
                } else {
                    start = mid + 1
                }
            }
            h = size - start
        }
        return h
    }
}
