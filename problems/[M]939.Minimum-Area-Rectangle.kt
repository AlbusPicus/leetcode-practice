/**
 * Runtime: 1064 ms, faster than 23.08% of Kotlin online submissions for Minimum Area Rectangle.
 * Memory Usage: 78.6 MB, less than 15.38% of Kotlin online submissions for Minimum Area Rectangle.
 */
class Solution {
    fun minAreaRect(points: Array<IntArray>): Int {
        val vectorToLastX = mutableMapOf<Vector, Int>()
        
        var minArea = Int.MAX_VALUE
        val columnYSet = mutableSetOf<Int>()
        var lastX = 0
        points.sortBy { it[0] }
        points.forEach { point ->
            val x = point[0]
            val y = point[1]
            if (lastX != x) {
                columnYSet.clear()
            }
            columnYSet.forEach { savedY ->
                val distance = Math.abs(y - savedY)
                val startY = Math.min(y, savedY)
                val vector = Vector(startY, distance)
                vectorToLastX[vector]?.let { previousX ->
                    val area = (x - previousX) * distance
                    minArea = Math.min(minArea, area)
                }
                vectorToLastX.put(vector, x)
            }
            
            lastX = x
            columnYSet.add(y)
        }
        
        return if (minArea == Int.MAX_VALUE) 0 else minArea
        
    }
    
    data class Vector(val coord: Int, val distance: Int)
    
}
