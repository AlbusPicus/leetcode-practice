/**
 * Runtime: 172 ms, faster than 90.82% of Kotlin online submissions for Number of Islands.
 * Memory Usage: 40.4 MB, less than 34.78% of Kotlin online submissions for Number of Islands.
 */
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val height = grid.size
        val width = grid[0].size
        var islandsCount = 0
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (grid[i][j] == '1') {
                    islandsCount++
                    visitIsland(grid, i, j)
                } 
            }
        }
        return islandsCount
    }
    
    fun visitIsland(grid: Array<CharArray>, i: Int, j: Int) {
        val height = grid.size
        val width = grid[0].size
        
        var cellQueue = LinkedList<Point>()
        cellQueue.offerLast(Point(i, j))
        while (cellQueue.isNotEmpty()) {
            val currentPoint = cellQueue.pop()
            if (grid[currentPoint.i][currentPoint.j] == '1') {
                grid[currentPoint.i][currentPoint.j] = '0'
                if (currentPoint.j > 0) {
                    cellQueue.offerLast(Point(currentPoint.i, currentPoint.j - 1))
                }
                if (currentPoint.j < width - 1) {
                    cellQueue.offerLast(Point(currentPoint.i, currentPoint.j + 1))
                }
                if (currentPoint.i > 0) {
                    cellQueue.offerLast(Point(currentPoint.i - 1, currentPoint.j))
                }
                if (currentPoint.i < height - 1) {
                    cellQueue.offerLast(Point(currentPoint.i + 1, currentPoint.j))
                }
            }
        }
    }
    
    data class Point(val i: Int, val j: Int)
}
