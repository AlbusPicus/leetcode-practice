/**
 * Runtime: 296 ms, faster than 100.00% of Kotlin online submissions for Minimum Area Rectangle II.
 * Memory Usage: 37.9 MB, less than 100.00% of Kotlin online submissions for Minimum Area Rectangle II.
 */
class Solution {
    fun minAreaFreeRect(points: Array<IntArray>): Double {
        val sideVectors = mutableMapOf<SideVector, MutableSet<IntArray>>()
        val allPoints = mutableSetOf<Point>()
        points.forEachIndexed { index, point ->
            for (j in index + 1 until points.size) {
                val firstPoint = points[index]
                val secondPoint = points[j]
                allPoints.add(Point(firstPoint[0], firstPoint[1]))
                allPoints.add(Point(secondPoint[0], secondPoint[1]))
                val startingPoint = getVectorStartingPoint(firstPoint, secondPoint)
                val vector = getVector(firstPoint, secondPoint)
                val pointsSet = sideVectors.getOrElse(vector) { mutableSetOf<IntArray>() }
                pointsSet.add(startingPoint)
                sideVectors.put(vector, pointsSet)
            }
        }
        var minimumArea: Double? = null
        sideVectors.entries.forEach { entry ->
            val vector = entry.key
            val startingPoints = ArrayList(entry.value)
            startingPoints.forEachIndexed { index, point ->
                for (j in index + 1 until startingPoints.size) {
                    val firstPoint = startingPoints[index]
                    val secondPoint = startingPoints[j]
                    val startingPoint = getVectorStartingPoint(firstPoint, secondPoint)
                    val secondVector = getVector(firstPoint, secondPoint)
                    val complementingPoint = if (vector != secondVector && isRightAngle(vector, secondVector)) {
                        Point(startingPoint[0] + vector.x, startingPoint[1] + vector.y)
                    } else null
                    if (complementingPoint in allPoints) {
                        minimumArea = getMinimumRectangleArea(minimumArea, vector, secondVector)
                    }
                }
            }
            
        }
        return minimumArea ?: 0.0
    }
    
    fun isRightAngle(firstVector: SideVector, secondVector: SideVector): Boolean {
        val scalarMultiplication = firstVector.x * secondVector.x + firstVector.y * secondVector.y
        val vectorMultiplication = Math.sqrt(firstVector.x.toDouble()*firstVector.x + firstVector.y*firstVector.y) * Math.sqrt(secondVector.x.toDouble()*secondVector.x + secondVector.y*secondVector.y)
        return Math.abs(scalarMultiplication / vectorMultiplication) < 0.0000000001
    }
    
    fun getMinimumRectangleArea(currentMinimum: Double?, firstVector: SideVector, secondVector: SideVector): Double {
        val area = Math.sqrt(firstVector.x.toDouble()*firstVector.x + firstVector.y*firstVector.y) * Math.sqrt(secondVector.x.toDouble()*secondVector.x + secondVector.y*secondVector.y)
        return if (currentMinimum == null) area else Math.min(currentMinimum, area)
    }
    
    fun getVectorStartingPoint(firstPoint: IntArray, secondPoint: IntArray): IntArray {
        return if (firstPoint[0] == secondPoint[0]) {
            if (firstPoint[1] > secondPoint[1]) {
                firstPoint
            } else {
                secondPoint
            }
        } else if (firstPoint[1] == secondPoint[1]) {
            if (firstPoint[0] > secondPoint[0]) {
                firstPoint
            } else {
                secondPoint
            }
        } else if (firstPoint[0] > secondPoint[0] && firstPoint[1] < secondPoint[1]) {
            firstPoint
        } else {
            secondPoint
        }
    }
    
    private fun getVector(firstPoint: IntArray, secondPoint: IntArray): SideVector {
        val startingPoint = getVectorStartingPoint(firstPoint, secondPoint)
        return if (firstPoint == startingPoint) {
            SideVector(secondPoint[0] - firstPoint[0], secondPoint[1] - firstPoint[1])
        } else {
            SideVector(firstPoint[0] - secondPoint[0], firstPoint[1] - secondPoint[1])
        }
    }
    
    data class SideVector(val x: Int, val y: Int)
    
    data class Point(val x: Int, val y: Int)
    
}
