/**
 * Runtime: 204 ms, faster than 94.46% of Kotlin online submissions for Container With Most Water.
 * Memory Usage: 37 MB, less than 80.97% of Kotlin online submissions for Container With Most Water.
 */
class Solution {
    fun maxArea(height: IntArray): Int {
        var leftIndex = 0
        var rightIndex = height.size - 1
        var maxArea = 0
        while (leftIndex < rightIndex) {
            val area = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex])
            maxArea = Math.max(maxArea, area)
            
            if (height[leftIndex] > height[rightIndex]) {
                rightIndex--
            } else leftIndex++
        }
        return maxArea
    }
}
