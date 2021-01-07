/**
 * Runtime: 260 ms, faster than 28.57% of Kotlin online submissions for Largest Perimeter Triangle.
 * Memory Usage: 38.8 MB, less than 28.57% of Kotlin online submissions for Largest Perimeter Triangle.
 */
class Solution {
    fun largestPerimeter(A: IntArray): Int {
        A.sort()
        var index = A.lastIndex
        while (index >= 2) {
            if (A[index - 2] + A[index - 1] > A[index]) {
                return A[index] + A[index - 1] + A[index - 2]
            } else {
                index--
            }
        }
        return 0
    }
}
