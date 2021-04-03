/**
 * Runtime: 176 ms, faster than 87.50% of Kotlin online submissions for Max Points on a Line.
 * Memory Usage: 35.7 MB, less than 93.75% of Kotlin online submissions for Max Points on a Line.
 */
class Solution {

    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size < 3) {
            return points.size
        }

        var result = 1
        for (i in 0 until points.size - 1) {
            result = Math.max(maxPointsOnLineWith(points, i), result)
        }
        return result
    }
    
    public fun maxPointsOnLineWith(points: Array<IntArray>, pointIndex: Int): Int {
        val lines = mutableMapOf<Pair<Int, Int>, Int>()
        
        var maxPoints = 1
        for (j in pointIndex + 1 until points.size) {
            val firstPoint = points[pointIndex]
            val secondPoint = points[j]
            maxPoints = Math.max(addLine(lines, firstPoint, secondPoint), maxPoints)
        }
        return maxPoints
    }
    
    public fun addLine(lines: MutableMap<Pair<Int, Int>, Int>, point1: IntArray, point2: IntArray): Int {
        val x1 = point1[0]
        val y1 = point1[1]
        val x2 = point2[0]
        val y2 = point2[1]
        
        val slope = getSlope(x1, y1, x2, y2)
        val linePointsCount = lines.getOrDefault(slope, 1) + 1
        lines.put(slope, linePointsCount)
        return linePointsCount
    }
    
    private fun getSlope(x1: Int, y1: Int, x2: Int, y2: Int): Pair<Int, Int> {
        var deltaX = x1 - x2
        var deltaY = y1 - y2
        return if (deltaX == 0) {
            0 to 0
        } else if (deltaY == 0) {
            Int.MAX_VALUE to Int.MAX_VALUE
        } else {
            if (deltaX < 0) {
                deltaX = -deltaX
                deltaY = -deltaY
            }
            val gcd = BigInteger.valueOf(deltaX.toLong()).gcd(BigInteger.valueOf(deltaY.toLong())).toInt()
            deltaX / gcd to deltaY / gcd
        }
    }
}
