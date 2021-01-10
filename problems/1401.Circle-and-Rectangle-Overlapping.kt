/**
 * Runtime: 152 ms, faster than 33.33% of Kotlin online submissions for Circle and Rectangle Overlapping.
 * Memory Usage: 33.6 MB, less than 100.00% of Kotlin online submissions for Circle and Rectangle Overlapping.
 */
class Solution {
    fun checkOverlap(radius: Int, x_center: Int, y_center: Int, x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
        val xDistance = if (!isInside(x_center, x1, x2)) { 
            Math.min(Math.abs(x2 - x_center), Math.abs(x1 - x_center)) 
        } else 0
        val yDistance = if (!isInside(y_center, y1, y2)) { 
            Math.min(Math.abs(y2 - y_center), Math.abs(y1-y_center)) 
        } else 0
        
        return xDistance * xDistance + yDistance * yDistance <= radius * radius
    }
    
    fun isInside(point: Int, start: Int, end: Int) = start <= point && point <= end
}
