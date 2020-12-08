/**
 * Runtime: 1604 ms, faster than 25.00% of Kotlin online submissions for Detect Cycles in 2D Grid.
 * Memory Usage: 149.8 MB, less than 25.00% of Kotlin online submissions for Detect Cycles in 2D Grid.
 */

class Solution {
    fun containsCycle(grid: Array<CharArray>): Boolean {
        val visitedPoints = mutableSetOf<Point>()
        var currentlyVisitedPoints = mutableSetOf<Point>()
        val currentCharItemsToVisit = LinkedList<Point>().apply { addLast(Point(0, 0)) }
        val nextCharItemsToVisit = LinkedList<Point>()
        var point: Point
        var hasCycle = false
        var switchToNextChar = false
        
        while (!hasCycle && (currentCharItemsToVisit.isNotEmpty() || nextCharItemsToVisit.isNotEmpty())) {
            switchToNextChar = currentCharItemsToVisit.isEmpty()
            point = if (switchToNextChar) nextCharItemsToVisit.pollLast() else currentCharItemsToVisit.pollLast()
            if (point !in visitedPoints) {
                if (switchToNextChar) {
                    currentlyVisitedPoints.clear()
                }
                currentlyVisitedPoints.add(point)

                visitedPoints.add(point)
                val cycleDetected = scheduleAdjacentPointsTraversal(
                    point, 
                    visitedPoints,
                    currentlyVisitedPoints,
                    grid, 
                    currentCharItemsToVisit,
                    nextCharItemsToVisit
                )
                hasCycle = hasCycle || cycleDetected
                if (hasCycle) break
            }
            
        }
        
        return hasCycle
        
    }
    
    /**
     * Creates adjacent points.
     * Puts valid adjucent points to the corresponding list based on the value in that point
     * @returns true if any of the valid points were already visited during this continious traversal, false - otherwise
     */
    fun scheduleAdjacentPointsTraversal(
        point: Point, 
        visitedPoints: Set<Point>, 
        currentlyVisitedItemsSet: Set<Point>,
        grid: Array<CharArray>, 
        currentCharItemsToVisit: LinkedList<Point>, 
        nextCharItemsToVisit: LinkedList<Point>
    ): Boolean {
        val gridHeight = grid.size
        val gridWidth = grid[0].size
        val currentChar = grid[point.x][point.y]
        var hasAlreadyVisitedPoint = false
        point.directions.forEach { direction ->
            val adjacentPoint = createAdjacentPoint(point, direction)
            if (adjacentPoint.isValid(gridHeight, gridWidth)) {
                if (adjacentPoint !in visitedPoints) {
                    val isSameChar = grid[adjacentPoint.x][adjacentPoint.y] == currentChar
                    if (isSameChar) {
                        currentCharItemsToVisit.addLast(adjacentPoint)
                    } else {
                        nextCharItemsToVisit.addLast(adjacentPoint)
                    }
                } else if (adjacentPoint in currentlyVisitedItemsSet) {
                    hasAlreadyVisitedPoint = true
                }
            }
        }
        return hasAlreadyVisitedPoint
    }
    
    fun createAdjacentPoint(point: Point, direction: Directions): Point {
        val directionsTemplate = EnumSet.allOf(Directions::class.java)
        return when (direction) {
            Directions.LEFT -> Point(point.x, point.y - 1, directionsTemplate.apply { remove (Directions.RIGHT) })
            Directions.TOP -> Point(point.x - 1, point.y, directionsTemplate.apply { remove (Directions.BOTTOM) })
            Directions.RIGHT -> Point(point.x, point.y + 1, directionsTemplate.apply { remove (Directions.LEFT) })
            Directions.BOTTOM -> Point(point.x + 1, point.y, directionsTemplate.apply { remove (Directions.TOP) })
        }
    }
    
    data class Point(val x: Int, val y: Int) {
        
        var directions: EnumSet<Directions> = EnumSet.allOf(Directions::class.java)
        
        constructor(x: Int, y: Int, directions: EnumSet<Directions>) : this(x, y) {
            this.directions = directions
        }
        
        fun isValid(maxHeight: Int, maxWidth: Int): Boolean {
          return x >= 0 && x < maxHeight && y >= 0 && y < maxWidth
        }
        
    }
    
    enum class Directions {
        LEFT, TOP, RIGHT, BOTTOM
    }
}
