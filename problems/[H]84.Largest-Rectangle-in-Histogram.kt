/**
 * Runtime: 444 ms, faster than 21.62% of Kotlin online submissions for Largest Rectangle in Histogram.
 * Memory Usage: 47.1 MB, less than 5.40% of Kotlin online submissions for Largest Rectangle in Histogram.
 */
class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var currentTopHeight = 0
        var maxArea = 0
        heights.forEachIndexed { index, height ->
            if (height < currentTopHeight) {
                maxArea = Math.max(maxArea, foldHeightsForMaxArea(heights, index))
            }
            currentTopHeight = height
        }
        maxArea = Math.max(maxArea, foldHeightsForMaxArea(heights))
        return maxArea
    }
    
    fun foldHeightsForMaxArea(heights: IntArray, currentIndex: Int? = null): Int {
        var maxArea = 0
        var width = 0
        val height: Int
        var index: Int 
        if (currentIndex != null) {
            height = heights[currentIndex]
            index = currentIndex - 1
        } else {
            height = 0
            index = heights.lastIndex
        }
        while (index >= 0 && heights[index] > height) {
            width++
            val elementHeight = heights[index]
            maxArea = Math.max(maxArea, elementHeight * width)
            heights[index] = height
            index--
        }
        return maxArea
    }
}
