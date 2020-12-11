/*
 * Runtime: 276 ms, faster than 94.44% of Kotlin online submissions for Shortest Path in Binary Matrix.
 * Memory Usage: 46.4 MB, less than 75.00% of Kotlin online submissions for Shortest Path in Binary Matrix.
 */

class Solution {
    
    /*
     * Time complexity: O(n)
     */
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val gridHeight = grid.size
        val gridWidth = grid[0].size
        if (grid[0][0] == 1 || grid[gridHeight - 1][gridWidth - 1] == 1) {
            return -1 //unreachable path
        }
        
        val queue = LinkedList<Point>()
        queue.addLast(Point(0, 0, 1))
        
        val distancesGrid = Array<IntArray>(gridHeight) { IntArray(gridWidth) { -1 } }
        distancesGrid[0][0] = 1
        
        var currentPoint: Point
        while (queue.isNotEmpty()) {
            currentPoint = queue.pollFirst()
            if (currentPoint.pathDistance <= distancesGrid[currentPoint.i][currentPoint.j]) {
                updateAdjacentCellsShortestDistances(grid, distancesGrid, queue, currentPoint)  
            }
        }
        
        return distancesGrid[gridHeight - 1][gridWidth - 1]
    }
    
    
    fun updateAdjacentCellsShortestDistances(
        valuesGrid: Array<IntArray>, 
        distancesGrid: Array<IntArray>, 
        pointsQueue: LinkedList<Point>,
        currentPoint: Point
    ) {
        val gridHeight = valuesGrid.size
        val gridWidth = valuesGrid[0].size
        val nextDistance = currentPoint.pathDistance + 1
        
        val iStart = (currentPoint.i - 1).takeIf { it >= 0} ?: 0
        val iFinish = (currentPoint.i + 1).takeIf { it < gridHeight} ?: gridHeight - 1
        val jStart = (currentPoint.j - 1).takeIf { it >= 0} ?: 0
        val jFinish = (currentPoint.j + 1).takeIf { it < gridWidth} ?: gridWidth - 1
        
        //Maximum of 9 points check. Time complexity: O(1)
        for (i in iStart .. iFinish) {
            for (j in jStart .. jFinish) {
                val currentDistance = distancesGrid[i][j]
                if (currentPoint.isNotCurrent(i, j) && valuesGrid[i][j] == 0 
                    && (currentDistance == -1 || currentDistance > nextDistance)) {
                    distancesGrid[i][j] = nextDistance
                    pointsQueue.addLast(Point(i, j, nextDistance))
                }
            }
        }
    }
    
    
    data class Point(val i: Int, val j: Int, val pathDistance: Int) {
        
        fun isNotCurrent(i: Int, j: Int) = i != this.i || j != this.j
        
    }
}
